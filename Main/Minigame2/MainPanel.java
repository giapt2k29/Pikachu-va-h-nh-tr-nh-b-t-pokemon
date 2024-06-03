package Minigame2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.swing.JPanel;

import object.AssetSetter;
import object.SuperObject;

public class MainPanel extends JPanel implements Runnable{
	//SCEEN SETTINGS
	final int orginalTitleSize = 16; // 16x16 tile
	final int Scale = 3;
	
	public final int titleSize = orginalTitleSize * Scale; //48x48 tile
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 20;
	public final int screenWidth = maxScreenCol * titleSize;//768 pixels
	public final int screenHeight = maxScreenRow * titleSize;//576 pixels
	//WORLD SETTING
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;
	public final int worldWidth = titleSize * maxWorldCol;
	public final int worldHeight = titleSize * maxWorldRow;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	int mapTileNum[][];
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this, keyH);
	//FPS
	int FPS = 60;

	EnvironmentManager eManager = new EnvironmentManager(this);
	
	public AssetSetter aSetter = new AssetSetter(this); 
	
	public SuperObject obj[] = new SuperObject[2];
	
	public entity npc[] = new entity[20];
	
	public ArrayList<entity> pokemonballList = new ArrayList<>();
	public ArrayList<entity> entityList = new ArrayList<>();
	public MainPanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		eManager.setup();
	}

	public void setupGame() {
		eManager.setup();
		//aSetter.setObject();
		aSetter.setNPC();
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;

			lastTime = currentTime;

			if(delta >= 1) {
				//1. UPDATE: update information
				update();
				//2. DRAW:
				repaint();

				delta--;
			}
		}
	}

	public void update() {
		
		player.update();
		
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) {
				npc[i].update();
			}
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) {
				npc[i].draw(g2);
			}
		}
		
		for(int i = 0; i < pokemonballList.size(); i++) {
			if(pokemonballList.get(i) != null) {
				if(pokemonballList.get(i).alive == true) {
					pokemonballList.get(i).update();
				}
				else {
					pokemonballList.remove(i);
				}
			}
		}
		
		player.draw(g2);
		
		eManager.draw(g2);
		
		for(int i = 0; i < pokemonballList.size(); i++) {
			if(pokemonballList.get(i) != null) {
				entityList.add(pokemonballList.get(i));
			}
		}
		
		for(int i = 0; i < entityList.size(); i++) {
			if(entityList.get(i) != null) {
				entityList.get(i).draw(g2);
				entityList.remove(i);
			}
		}
		
		g2.dispose();
	}
}
