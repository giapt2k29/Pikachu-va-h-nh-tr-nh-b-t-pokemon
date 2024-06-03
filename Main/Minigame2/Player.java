package Minigame2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Maingame.MyFrame;
import object.OBJ_Pokemonball;
import object.Pokemonball;
import object.Question;
import object.QuestionBank;

public class Player extends entity {
	KeyHandler keyH;
	MyFrame frame;
	
	public final int screenX;
	public final int screenY;
	
	private QuestionBank questionBank;
	
	public Player(MainPanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		screenX = gp.screenWidth / 2 - (gp.titleSize / 2);
		screenY = gp.screenHeight / 2 - (gp.titleSize / 2);
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 20;
		
		this.questionBank = new QuestionBank();
		setDefaultValues();
		getPlayerImage();	
	}

	
	public void setDefaultValues() {
		worldX = 23 * gp.titleSize;
		worldY = 21 * gp.titleSize;
		speed = 4;
		direction = "down";
		direction2 = "down";
		pokemonball = new OBJ_Pokemonball(gp);
	}

	public void getPlayerImage() {

		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_4.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_4.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if(keyH.upPressed == true 
		|| keyH.leftPressed == true
		|| keyH.rightPressed == true
		|| keyH.downPressed == true) {
			direction1 = "";
			if (keyH.upPressed == true) {
				//worldY -= speed;
				direction = "up";
				direction2 = "up";
			}
			if(keyH.downPressed == true) {
				//worldY += speed;
				direction = "down";
				direction2 = "down";
			}
			if (keyH.leftPressed == true) {
				//worldX -= speed;
				direction = "left";
				direction2 = "left";
			}
			if(keyH.rightPressed == true) {
				//worldX += speed;
				direction = "right";
				direction2 = "right";
			}
			
			collisionOn = false;
			
			gp.cChecker.checkTile(this);
			
			gp.cChecker.checkEntity(this, gp.npc);
			
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			
			interactNPC(npcIndex);
			//int objIndex = gp.cChecker.checkObject(this, true);
			//pickUpObject(objIndex);
			
			if(gp.cChecker.anscount >= 2) {
				frame.showDialogNewGame2(
						"You are winer!\nDo you want play again?", "Win");
			}
			
			if(collisionOn == false) {
				switch (direction) {
					case "up": worldY -= speed; break;
					case "down": worldY += speed;break;
					case "left": worldX -= speed;break;
					case "right":worldX += speed;break;
					case "nothing":break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum1 == 1) {
					spriteNum1 = 2;
				}
				else if(spriteNum1 == 2){
					spriteNum1 = 1;
				}
				
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
		else {
			if(direction == "up") {
				direction1 = "up";
			}
			if(direction == "down" ) {
				direction1 = "down";
			}
			if(direction == "left") {
				direction1 = "left";
			}
			if(direction == "right") {
				direction1 = "right";
			}
			direction = "";
			spriteCounter1++;
			if(spriteCounter1 > 12) {
				if(spriteNum2 == 1) {
					spriteNum2 = 2;
				}
				else if(spriteNum2 == 2){
					spriteNum2 = 1;
				}
				spriteCounter1 = 0;
			}
		}
		if(gp.keyH.spacePressed == true && pokemonball.alive == false) {
			pokemonball.set(worldX, worldY, direction2, true, this);
			
			gp.pokemonballList.add(pokemonball);
			
			System.out.println("ok");
		}
}

	public void pickUpObject(int i) {
		if(i != 999) {
			gp.obj[i] = null;
		}
	}
	
	public void interactNPC(int i) {
		if(i != 999) {
			boolean validAnswer = false;
	        do {
	        	direction = "nothing";
	        	Question randomQuestion = questionBank.getRandomQuestion();
	            String answer = JOptionPane.showInputDialog(null, randomQuestion.question);
	            if (answer != null && answer.equals(randomQuestion.answer)) {
	                validAnswer = true;
	                gp.npc[i] = null;
				}
	            else {
	                JOptionPane.showMessageDialog(null, "Câu trả lời không đúng hoặc bạn đã hủy.");
	                validAnswer = true;
	            }
	        } while (!validAnswer);
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		if (direction == "up" && spriteNum1 == 1) {
			image = up1;
		}
		if (direction == "up" && spriteNum1 == 2) {
			image = up2;
		}
		
		if (direction1 == "up" && spriteNum2 == 1) {
			image = up3;
		}
		if (direction1 == "up" && spriteNum2 == 2) {
			image = up4;
		}
		
		if (direction == "up" && spriteNum1 == 4) {
			image = up4;
		}
		
		if (direction == "down" && spriteNum1 == 1) {
			image = down1;
		}
		if (direction == "down" && spriteNum1 == 2) {
			image = down2;
		}
		if (direction1 == "down" && spriteNum2 == 1) {
			image = down3;
		}
		if (direction1 == "down" && spriteNum2 == 2) {
			image = down4;
		}
		
		if (direction == "left" && spriteNum1 == 1) {
			image = left1;
		}
		if (direction == "left" && spriteNum1 == 2) {
			image = left2;
		}
		if (direction1 == "left" && spriteNum2 == 1) {
			image = left3;
		}
		if (direction1 == "left" && spriteNum2 == 2) {
			image = left4;
		}
		
		if (direction == "right" && spriteNum1 == 1) {
			image = right1;
		}
		if (direction == "right" && spriteNum1 == 2) {
			image = right2;
		}
		if (direction1 == "right" && spriteNum2 == 1) {
			image = right3;
		}
		if (direction1 == "right" && spriteNum2 == 2) {
			image = right4;
		}

		g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
	}
	
}
