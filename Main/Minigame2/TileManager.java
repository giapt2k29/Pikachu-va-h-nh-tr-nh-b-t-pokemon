package Minigame2;

import java.io.File;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileManager {
	MainPanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	KeyHandler keyH;
	
	public TileManager(MainPanel gp) {
		this.gp = gp;
		
		tile = new Tile[38];
		
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

		getTileImage();
		
		loadmap("/res/map/world03.txt");
		
	}
	
	public void getTileImage() {
		try {
			for(int i = 0; i <= 37; i++) {
				String file;
				if(i < 10) {
					file = "/res/tiles/00" + String.valueOf(i) + ".png";
				}
				else {
					file = "/res/tiles/0" + String.valueOf(i) + ".png";
				}
				tile[i] = new Tile();
				tile[i].image = ImageIO.read(getClass().getResourceAsStream(file));
			}
			tile[16].collision = true;
			for(int i = 18; i <= 33; i++) {
				tile[i].collision = true;
			}
//			tile[0] = new Tile();
//			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));
//			
//			tile[1] = new Tile();
//			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
//			tile[1].collision = true;
//			
//			
//			tile[2] = new Tile();
//			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
//			tile[2].collision = true;
//			
//			tile[3] = new Tile();
//			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));
//			
//			tile[4] = new Tile();
//			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
//			tile[4].collision = true;
//			
//			
//			tile[5] = new Tile();
//			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadmap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					
					col++;
				}
				
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		
		int worldcol = 0;
		int worldrow = 0;
	
		while(worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldcol][worldrow];
			
			int worldX = worldcol * gp.titleSize;
			int worldY = worldrow * gp.titleSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.titleSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.titleSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.titleSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.titleSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.titleSize, gp.titleSize, null);
			}
			
			worldcol++;
	
			if(worldcol == gp.maxWorldCol) {
				worldrow++;
				worldcol = 0;
			}
		}
	}
	public Tile[] getTileArray() {
	    return tile;
	}
}
