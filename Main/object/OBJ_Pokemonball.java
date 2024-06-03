package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Minigame2.MainPanel;

public class OBJ_Pokemonball extends Pokemonball{
	MainPanel gp;
	public OBJ_Pokemonball(MainPanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Pokemonball";
		speed = 2;
		maxlife = 80;
		life = maxlife;
		alive = false;
		getPlayerImage();
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_4.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_4.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/res/pokemonball/pokemonball_4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
