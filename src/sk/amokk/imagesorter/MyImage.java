package sk.amokk.imagesorter;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {
	

	
	public static BufferedImage loadImage(File f) {  
		BufferedImage bimg = null;  
		try {     
			bimg = ImageIO.read(f);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return bimg;  
	}  


}
