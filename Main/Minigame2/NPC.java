package Minigame2;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import object.Question;

public class NPC extends entity{
	public NPC(MainPanel gp) {
		super(gp);
		direction2 = "down";
		speed = 1;
		
		getPlayerImage();
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_up_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_up_3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_up_3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_down_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_down_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_down_3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_left_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_left_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_left_3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_right_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_right_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemon/soido_right_3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			
			Random random = new Random();
			
			int i = random.nextInt(100) + 1;
			
			if(i <= 25) {
				direction2 = "up";
			}
			if(i > 25 && i <= 50) {
				direction2 = "down";
			}
			if(i > 50 && i <= 75) {
				direction2 = "left";
			}
			if(i > 75) {
				direction2 = "right";
			}
			actionLockCounter = 0;
		}
	}
}
