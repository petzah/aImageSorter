package sk.amokk.imagesorter;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtils {
	

	
	public static BufferedImage loadImage(File f) {  
		BufferedImage bimg = null;  
		try {     
			bimg = ImageIO.read(f);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return bimg;  
	} 
	
	public static File[] scanDirectory(File f) {
		if (!f.isDirectory()) {
			throw new IllegalArgumentException(f + "is not a directory");
		}
		
		return null;
	}


}
