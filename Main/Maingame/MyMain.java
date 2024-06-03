package Maingame;

import javax.swing.JOptionPane;

public class MyMain {
	MyFrame frame;
	static Sound sound;
	public int row = 8;
	public int col = 8;

	
	public MyMain() {
		frame = new MyFrame(row, col, false, 300);
		frame.setTime(300);
		MyTimeCount timeCount = new MyTimeCount();
		timeCount.start();
		new Thread(frame).start();
	}

	public static void main(String[] args) {
		new MyMain();
		sound.playSound("/sound/background1.wav");
	}

	class MyTimeCount extends Thread {

		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				frame.setTime(frame.getTime() - 1);
				if (frame.getTime() == 0) {
					frame.showDialogNewGame(
							"Full time\nDo you want play again?", "Lose");
				}
			}
		}
	}
}
