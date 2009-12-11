package sk.amokk.imagesorter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Picture extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage pic;
	
	public Picture(BufferedImage bimg) {
		super(true);
		this.pic = bimg;
	}	

	@Override
	public void paintComponent(Graphics g) {
		if (pic == null)
			return;
		int width = 0; 
		int height = 0;
		int positionX = 0;
		int positionY = 0;
		
		int parWidth = getParent().getWidth();
		int parHeight = getParent().getHeight();
		int picWidth = pic.getWidth();
		int picHeight = pic.getHeight();
		
		
		//if picture Width and Height is lower than parent window width and height then we don't need to scale it
		if ((picWidth <= parWidth) && (picHeight <= parHeight)) {
			positionX = (parWidth - picWidth) / 2;
			positionY = (parHeight - picHeight) / 2;
			width = picWidth;
			height = picHeight;
			g.clearRect(0, 0, parWidth, parHeight);
			g.drawImage(pic, positionX, positionY, width, height, null);
			return;
		}
		
		double scaleX = (double)picWidth / (double)parWidth;
		double scaleY = (double)picHeight / (double)parHeight;
		
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
		g.clearRect(0, 0, parWidth, parHeight);
		g.drawImage(pic, positionX, positionY, width, height, null);
	}
	
	
}
