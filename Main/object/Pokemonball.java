package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Minigame2.MainPanel;
import Minigame2.entity;

public class Pokemonball extends entity{
	MainPanel gp;
	public String name;
	entity user;
	public Pokemonball(MainPanel gp) {
		super(gp);
	}
	
	public void set(int worldX, int worldY, String direction2, boolean alive, entity user) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction2 = direction2;
		this.user = user;
		this.life = this.maxlife;
		this.alive = alive;
	}
	
	public void update() {		
		switch(direction2) {
		case "up": worldY -= speed; break;
		case "down": worldY += speed; break;
		case "left": worldX -= speed; break;
		case "right": worldX += speed; break;
		}
		
		life--;
		if(life < 0) {
			alive = false;
		}
		
		spriteCounter+=2;
		if(spriteCounter > 12) {
			if(spriteNum3 == 1) {
				spriteNum3 = 2;
			}
			else if(spriteNum3 == 2){	
				spriteNum3 = 3;
			}
			else if(spriteNum3 == 3) {
				spriteNum3 = 4;
			}
			else if(spriteNum3 == 4) {
				spriteNum3 = 1;
			}
			spriteCounter = 0;
		}
	}
}
