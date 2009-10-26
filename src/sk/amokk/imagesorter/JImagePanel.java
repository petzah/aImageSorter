package sk.amokk.imagesorter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	
	public JImagePanel(BufferedImage bimg) {
		super();
		this.img = bimg;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

