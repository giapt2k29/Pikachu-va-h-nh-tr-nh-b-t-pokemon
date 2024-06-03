package object;

import java.util.Random;

import Minigame2.MainPanel;
import Minigame2.NPC;
import Minigame2.TileManager;

public class AssetSetter {
	MainPanel gp;
	TileManager Tile;
	public AssetSetter(MainPanel gp) {
		this.gp = gp;
	}
	
//	public void setObject() {
//		gp.obj[0] = new OBJ_Key();
//		gp.obj[0].worldX = 23 * gp.titleSize;
//		gp.obj[0].worldY = 7 * gp.titleSize;
//		
//		gp.obj[1] = new OBJ_Key();
//		gp.obj[1].worldX = 23 * gp.titleSize;
//		gp.obj[1].worldY = 40 * gp.titleSize;
//	}
	
	public void setNPC() {
		gp.npc[0] = new NPC(gp);
		gp.npc[0].worldX = gp.titleSize * 23;
		gp.npc[0].worldY = gp.titleSize * 21;
		
		gp.npc[1] = new NPC(gp);
		gp.npc[1].worldX = gp.titleSize * 62;
		gp.npc[1].worldY = gp.titleSize * 13;
		
		gp.npc[2] = new NPC(gp);
		gp.npc[2].worldX = gp.titleSize * 81;
		gp.npc[2].worldY = gp.titleSize * 32;
		
		gp.npc[3] = new NPC(gp);
		gp.npc[3].worldX = gp.titleSize * 53;
		gp.npc[3].worldY = gp.titleSize * 87;
		
		gp.npc[4] = new NPC(gp);
		gp.npc[4].worldX = gp.titleSize * 12;
		gp.npc[4].worldY = gp.titleSize * 75;
		
		gp.npc[5] = new NPC(gp);
		gp.npc[5].worldX = gp.titleSize * 74;
		gp.npc[5].worldY = gp.titleSize * 35;
		
		gp.npc[6] = new NPC(gp);
		gp.npc[6].worldX = gp.titleSize * 64;
		gp.npc[6].worldY = gp.titleSize * 12;
		
		gp.npc[7] = new NPC(gp);
		gp.npc[7].worldX = gp.titleSize * 75;
		gp.npc[7].worldY = gp.titleSize * 64;
		
		gp.npc[8] = new NPC(gp);
		gp.npc[8].worldX = gp.titleSize * 43;
		gp.npc[8].worldY = gp.titleSize * 75;
		
		gp.npc[9] = new NPC(gp);
		gp.npc[9].worldX = gp.titleSize * 32;
		gp.npc[9].worldY = gp.titleSize * 23;
		
		gp.npc[10] = new NPC(gp);
		gp.npc[10].worldX = gp.titleSize * 55;
		gp.npc[10].worldY = gp.titleSize * 35;
	}
	
	public void setPokemonball() {
		
	}
}
