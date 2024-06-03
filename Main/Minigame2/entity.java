package Minigame2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import object.Pokemonball;

public class entity {
	MainPanel gp;
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, up3, up4, down3, down4, left3, left4, right3, right4;
	public String direction;
	public String direction1;
	public String direction2;
	
	public int spriteCounter = 0;
	public int spriteCounter1 = 0;
	public int spriteNum1 = 1;
	public int spriteNum2 = 1;
	public int spriteNum3 = 1;
	
	public int maxlife;
	public int life;
	public Rectangle solidArea = new Rectangle(16, 16, 32, 32);
	
	public Pokemonball pokemonball;
	
	public boolean alive = true;
	
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public boolean collisionOn = false;
	
	public int actionLockCounter = 0;
	public entity(MainPanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {}
	public void update() {
		setAction();
		
		gp.cChecker.checkEntity(this, gp.npc);
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		if(collisionOn == false) {
			switch (direction2) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed;break;
				case "left": worldX -= speed;break;
				case "right":worldX += speed;break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum3 == 1) {
				spriteNum3 = 2;
			}
			else {
				if(spriteNum3 == 2) {
					spriteNum3 = 3;
				}
				else if(spriteNum3 == 3) {
					spriteNum3 = 1;
				}
				else if(spriteNum3 == 4) {
					spriteNum3 = 1;
				}
			}
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.titleSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.titleSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.titleSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.titleSize < gp.player.worldY + gp.player.screenY) {
			
			if (direction2 == "up" && spriteNum3 == 1) {
				image = up1;
			}
			if (direction2 == "up" && spriteNum3 == 2) {
				image = up2;
			}
			
			if (direction2 == "up" && spriteNum3 == 1) {
				image = up3;
			}
			if (direction2 == "up" && spriteNum3 == 3) {
				image = up3;
			}
			
			if (direction2 == "up" && spriteNum3 == 4) {
				image = up4;
			}
			
			if (direction2 == "down" && spriteNum3 == 1) {
				image = down1;
			}
			if (direction2 == "down" && spriteNum3 == 2) {
				image = down2;
			}
			if (direction2 == "down" && spriteNum3 == 3) {
				image = down3;
			}
			if (direction2 == "down" && spriteNum3 == 4) {
				image = down4;
			}
			
			if (direction2 == "left" && spriteNum3 == 1) {
				image = left1;
			}
			if (direction2 == "left" && spriteNum3 == 2) {
				image = left2;
			}
			if (direction2 == "left" && spriteNum3 == 3) {
				image = left3;
			}
			if (direction2 == "left" && spriteNum3 == 4) {
				image = left4;
			}
			
			if (direction2 == "right" && spriteNum3 == 1) {
				image = right1;
			}
			if (direction2 == "right" && spriteNum3 == 2) {
				image = right2;
			}
			if (direction2 == "right" && spriteNum3 == 3) {
				image = right3;
			}
			if (direction2 == "right" && spriteNum3 == 4) {
				image = right4;
			}

			
			g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
		}
	}
}
