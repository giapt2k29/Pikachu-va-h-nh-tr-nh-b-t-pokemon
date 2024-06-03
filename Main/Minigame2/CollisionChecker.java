package Minigame2;

import javax.swing.JOptionPane;

import Maingame.MyFrame;
import object.Question;
import object.QuestionBank;

public class CollisionChecker {
	
	public int anscount = 0;
	
	MainPanel gp;
//	private QuestionBank questionBank;
	
	private MyFrame frame;
	public CollisionChecker(MainPanel gp) {
		this.gp = gp;
	}
	
	
	public void checkTile(entity entity) {
		boolean answer1 = false;
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gp.titleSize;
		int entityRightCol = entityRightWorldX / gp.titleSize;
		int entityTopRow = entityTopWorldY / gp.titleSize;
		int entityBottomRow = entityBottomWorldY / gp.titleSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction2) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed) / gp.titleSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true
					||gp.tileM.tile[tileNum2].collision == true) {
						entity.collisionOn = true;
					}
			break;
			
		case "down" :
			answer1 = false;
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.titleSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true
			||gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "left" :
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.titleSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true
			||gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "right" :
			entityLeftCol = (entityRightWorldX + entity.speed) / gp.titleSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true
			||gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
//	public int checkObject(entity entity, boolean player) {
//		int index = 999;
//		
//		for(int i = 0; i < gp.obj.length; i++) {
//			if(gp.obj[i] != null) {
//				entity.solidArea.x = entity.worldX + entity.solidArea.x;
//				entity.solidArea.y = entity.worldY + entity.solidArea.y;
//				
//				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
//				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
//				
//				switch(entity.direction2) {
//				case "up": 
//					entity.solidArea.y -= entity.speed;
//					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
//						if(gp.obj[i].collision == true) {
//					        boolean validAnswer = false;
//					        do {
//					        	Question randomQuestion = questionBank.getRandomQuestion();
//					            String answer = JOptionPane.showInputDialog(null, randomQuestion.question);
//					            if (answer != null && answer.equals(randomQuestion.answer)) {
//					                validAnswer = true;
//							        entity.collisionOn = true;
//									if(player == true) {
//										anscount++;
//										index = i;
//									}
//					            } else {
//					                JOptionPane.showMessageDialog(null, "Câu trả lời không đúng hoặc bạn đã hủy.");
//					                validAnswer = true;
//					            }
//					        } while (!validAnswer);
//						}
//						
//					}
//					break;
//				case "down": 
//					entity.solidArea.y += entity.speed;
//					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
//						if(gp.obj[i].collision == true) {
//							if(gp.obj[i].collision == true) {
//						        boolean validAnswer = false;
//						        do {
//						        	Question randomQuestion = questionBank.getRandomQuestion();
//						            String answer = JOptionPane.showInputDialog(null, randomQuestion.question);
//						            if (answer != null && answer.equals(randomQuestion.answer)) {
//						                validAnswer = true;
//								        entity.collisionOn = true;
//										if(player == true) {
//											index = i;
//											anscount++;
//										}
//						            } else {
//						                JOptionPane.showMessageDialog(null, "Câu trả lời không đúng hoặc bạn đã hủy.");
//						                validAnswer = true;
//						            }
//						        } while (!validAnswer);
//							
//							}
//						}
//					}
//					break;
//				case "left":
//					entity.solidArea.x -= entity.speed;
//					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
//						if(gp.obj[i].collision == true) {
//					        boolean validAnswer = false;
//					        do {
//					        	Question randomQuestion = questionBank.getRandomQuestion();
//					            String answer = JOptionPane.showInputDialog(null, randomQuestion.question);
//					            if (answer != null && answer.equals(randomQuestion.answer)) {
//					                validAnswer = true;
//							        entity.collisionOn = true;
//									if(player == true) {
//										index = i;
//										anscount++;
//									}
//					            } else {
//					                JOptionPane.showMessageDialog(null, "Câu trả lời không đúng hoặc bạn đã hủy.");
//					                validAnswer = true;
//					            }
//					        } while (!validAnswer);
//						}
//					}
//					break;
//				case "right":
//					entity.solidArea.x += entity.speed;
//					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
//						if(gp.obj[i].collision == true) {
//							if(gp.obj[i].collision == true) {
//						        boolean validAnswer = false;
//						        do {
//						        	Question randomQuestion = questionBank.getRandomQuestion();
//						            String answer = JOptionPane.showInputDialog(null, randomQuestion.question);
//						            if (answer != null && answer.equals(randomQuestion.answer)) {
//						                validAnswer = true;
//								        entity.collisionOn = true;
//										if(player == true) {
//											index = i;
//											anscount++;
//										}
//						            } else {
//						                JOptionPane.showMessageDialog(null, "Câu trả lời không đúng hoặc bạn đã hủy.");
//						                validAnswer = true;
//						            }
//						        } while (!validAnswer);
//							}
//						}
//					}
//					break;
//				}
//				entity.solidArea.x = entity.solidAreaDefaultX;
//				entity.solidArea.y = entity.solidAreaDefaultY;
//				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
//				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
//			}
//		}
//		
//		return index;
//	}
	
	public int checkEntity(entity entity, entity[] target) {
		int index = 999;
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
				
				switch(entity.direction2) {
				case "up": 
					entity.solidArea.y -= entity.speed;
					break;
				case "down": 
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if(entity.solidArea.intersects(target[i].solidArea)) {
					entity.collisionOn = true;
					index = i;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}
		}
		
		return index;
	}
	public int checkPokemon(entity entity, entity[] target) {
		int index = 999;
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
				
				switch(entity.direction2) {
				case "up": 
					entity.solidArea.y -= entity.speed;
					if(target[i].collisionOn == true) {
						System.out.println("test");
					}
					break;
				case "down": 
					entity.solidArea.y += entity.speed;
					if(target[i].collisionOn == true) {
						System.out.println("test");
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(target[i].collisionOn == true) {
						System.out.println("test");
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if(entity.solidArea.intersects(target[i].solidArea)) {
					entity.collisionOn = true;
					index = i;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}
		}
		
		return index;
	}
}
