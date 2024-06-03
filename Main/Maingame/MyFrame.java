package Maingame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Minigame2.*;

public class MyFrame extends JFrame implements ActionListener, Runnable {
    private static final long serialVersionUID = 1L;
    private String author = "HUST";
    public int time;
    public int maxTime;
    private int row;
    private int col;
    public int width = 1200;
    public int height = 1000;
    private JLabel lbScore;
    private JProgressBar progressTime;
    private JButton btnNewGame;
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private JButton Minigame2;
    private JButton Minigame1;
    private MyGraphics graphicsPanel;
    private Minigame1 minigame1;
    private JPanel mainPanel;
    private boolean minigame = false;

    public MyFrame(int rows, int cols, boolean minigame, int maxTime) {
        this.row = rows;
        this.col = cols;
        this.minigame = minigame;
        this.maxTime = maxTime;
        add(mainPanel = createMainPanel());
        setTitle("Pokemon Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        Background panel = new Background("/icon/Meme.jpg");
        panel.setLayout(new BorderLayout());
        panel.add(createGraphicsPanel(), BorderLayout.CENTER);
        panel.add(createControlPanel(), BorderLayout.EAST);
        panel.add(createStatusPanel(), BorderLayout.PAGE_END);
        return panel;
    }

    private JPanel createGraphicsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        if (minigame) {
            minigame1 = new Minigame1(this, row, col);
            panel.add(minigame1);
        } else {
            graphicsPanel = new MyGraphics(this, row, col);
            panel.add(graphicsPanel);
        }
        return panel;
    }

    private JPanel createControlPanel() {
        lbScore = new JLabel("0");
        progressTime = new JProgressBar(0, 100);
        progressTime.setValue(100);

        JPanel panelLeft = new JPanel(new GridLayout(0, 1, 5, 5));
        panelLeft.add(new JLabel("Score:"));
        panelLeft.add(new JLabel("Time:"));

        JPanel panelCenter = new JPanel(new GridLayout(0, 1, 5, 5));
        panelCenter.add(lbScore);
        panelCenter.add(progressTime);

        JPanel panelScoreAndTime = new JPanel(new BorderLayout(5, 0));
        panelScoreAndTime.add(panelLeft, BorderLayout.WEST);
        panelScoreAndTime.add(panelCenter, BorderLayout.CENTER);

        JPanel panelControl = new JPanel(new BorderLayout(10, 10));
        panelControl.setBorder(new EmptyBorder(10, 3, 5, 3));
        panelControl.add(panelScoreAndTime, BorderLayout.CENTER);
        panelControl.setLayout(new GridLayout(0, 1, 10, 10));
        panelControl.add(panelScoreAndTime, BorderLayout.CENTER);
        panelControl.add(btnNewGame = createButton("New Game"));
        panelControl.add(easy = createButton("Easy"));
        panelControl.add(medium = createButton("Medium"));
        panelControl.add(hard = createButton("Hard"));
        panelControl.add(Minigame1 = createButton("MiniGame1"));
        panelControl.add(Minigame2 = createButton("MiniGame2"));
        
        Icon icon = new ImageIcon(getClass().getResource("/icon/images.jpg"));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Status"));
        panel.add(panelControl, BorderLayout.PAGE_START);
        panel.add(new JLabel(icon), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(Color.lightGray);
        JLabel lbAuthor = new JLabel(author);
        lbAuthor.setForeground(Color.blue);
        panel.add(lbAuthor);
        return panel;
    }

    private JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }

    public void newGame() {
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    
    public void newGame1() {
    	MyFrame frame = new MyFrame(3, 3, true, 10);
    	frame.setTime(10);
    	new Minigame1(this, 3, 3);
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    
    public void minigame2() {
    	JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Project");
		
		MainPanel gamePanel = new MainPanel();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame();
		
		gamePanel.startGameThread();
    }
    
    public void minigame1() {
    	MyFrame frame = new MyFrame(3, 3, true, 10);
    	frame.setTime(10);
    	new Minigame1(frame, 3, 3);
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    public void easy() {
        MyFrame frame1 = new MyFrame(8, 8, false, 300);
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }

    public void medium() {
        MyFrame frame = new MyFrame(10, 10, false, 300);
        frame.setTime(300);
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    
    public void hard() {
    	new MyFrame(12, 12, false, 300);
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewGame) {
            newGame();
        } else {
            if (e.getSource() == easy) {
                easy();
            } else {
                if (e.getSource() == hard) {
                    hard();
                } else 
                	if (e.getSource() == medium) {
                		medium();
                	}
                	else {
                		if(e.getSource() == Minigame1) {
                			minigame1();
                		}
                		else if(e.getSource() == Minigame2) {
                			minigame2();
                		}
                	}
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressTime.setValue((int) ((double) time / maxTime * 100));
        }
    }

    public JLabel getLbScore() {
        return lbScore;
    }

    public void setLbScore(JLabel lbScore) {
        this.lbScore = lbScore;
    }

    public JProgressBar getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(JProgressBar progressTime) {
        this.progressTime = progressTime;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void showDialogNewGame(String message, String title) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            newGame();
        } else {
            System.exit(0);
        }
    }
    public void showDialogNewGame1(String message, String title) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            newGame1();
        } else {
            System.exit(0);
        }
    }
    
    public void showDialogNewGame2(String message, String title) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            minigame2();
        } else {
            System.exit(0);
        }
    }
}
