package sk.amokk.imagesorter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Picture extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	
	public Picture(BufferedImage bimg) {
		super(true);
		this.img = bimg;
	}	
	
	@Override
	public void paintComponent(Graphics g) {
		int width = 0; 
		int height = 0;
		int positionX = 0;
		int positionY = 0;
		
		int parWidth = getParent().getWidth();
		int parHeight = getParent().getHeight();
		int picWidth = img.getWidth();
		int picHeight = img.getHeight();
		
		
		//if picture Width and Height is lower than parent window then we don't need to scale it
		if ((picWidth <= parWidth) && (picHeight <= parHeight)) {
			positionX = (parWidth - picWidth) / 2;
			positionY = (parHeight - picHeight) / 2;
			g.drawImage(img, positionX, positionY, picWidth, picHeight, null);
			return;
		}
		
		double scaleX = (double)picWidth / (double)parWidth;
		double scaleY = (double)picHeight / (double)parHeight;
		
		//System.err.println("scaleX: " + scaleX + " scaleY: " + scaleY);
		
		if (scaleX >= scaleY) {
			width = parWidth;
			double scale = (double) picWidth / (double) parWidth;
			height = (int) (picHeight / scale);
			positionY = (parHeight - height) / 2;
			
		}
		else {
			height = parHeight;
			double scale = (double) picHeight / (double) parHeight;
			width = (int) (picWidth / scale);
			positionX = (parWidth - width) / 2;
		}
		

		
		g.drawImage(img, positionX, positionY, width, height, null);
	}
}
