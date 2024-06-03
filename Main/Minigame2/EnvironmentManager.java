package Minigame2;

import java.awt.Graphics2D;

import Minigame2.MainPanel;
public class EnvironmentManager {
	MainPanel gp;
	
	Lighting lightning;
	
	public EnvironmentManager(MainPanel gp) {
		this.gp = gp;
	}
	
	public void setup() {
		lightning = new Lighting(gp, 1500);
	}
	
	public void draw(Graphics2D g2) {
		lightning.draw(g2);
	}
}
