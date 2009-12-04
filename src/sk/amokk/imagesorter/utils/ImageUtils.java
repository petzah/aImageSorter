package sk.amokk.imagesorter.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;

import sk.amokk.imagesorter.FileRecursive;

public class ImageUtils {
	
	public static File[] listImages;
	private static int actualImage = 0;
	
	private ImageUtils(){}
	
	
	
	public static BufferedImage loadImage(File f) {  
		BufferedImage bimg = null;  
		try {     
			bimg = ImageIO.read(f);  
		} catch (Exception e) {  
			e.printStackTrace();
			System.err.println("can't read file: " + f);
		}  
		return bimg;  
	}
	
	public static File[] getImages(String directory) {
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.contains("jpg");
	        }
	    };
	    
	    FileRecursive f = new FileRecursive(directory);
	    File[] a = f.listFilesRecursive(filter);
	    for (File file : a) {
	    	System.out.println(file.getPath());
	    }
	    return a;
	}
	
	public static boolean copyImage(String pathSource, String pathDestination) {
		return false;
	}
	
	public static boolean moveImage(File image, String pathDestination) {
		if (image.renameTo(new File(pathDestination, image.getName())))
			return true;
		else
			return false;
	}

	public static File getActualImage() {
		return listImages[actualImage];
	}
	
	public static File getNextImage() {
		if (listImages[actualImage+1] != null)
			actualImage++;
		return listImages[actualImage];
	}
	
	public static File getPrevImage() {
		//TODO condition > -1
		return listImages[actualImage-1];
	}


}
