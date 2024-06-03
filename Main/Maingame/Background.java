package Maingame;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
	
    private Image backgroundImage;

    public Background(String fileName) {
        try {
            backgroundImage = new ImageIcon(getClass().getResource(fileName)).getImage();
        } catch (Exception e) {
            
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 1000, 1000, this);
        }
    }
}
