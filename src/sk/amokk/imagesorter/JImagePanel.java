package sk.amokk.imagesorter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JImagePanel extends JPanel {
	private BufferedImage img;
	
	public JImagePanel(BufferedImage bimg) {
		super();
		this.img = bimg;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		//g.drawImage(img, 0, 0, null);
	}
}
