package sk.amokk.imagesorter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;


import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static File[] listImages;
	private static int actualImage = 0;
	
	private ImageUtils(){}
	
	public static void props() {
		// create and load default properties
		Properties defaultProps = new Properties();
		// create application properties with default
		Properties applicationProps = new Properties(defaultProps);
		
		FileInputStream in;
		try {
			
			in = new FileInputStream("defaultProperties");
			defaultProps.load(in);
			in.close();
			
			// now load properties from last invocation
			in = new FileInputStream("appProperties");
			applicationProps.load(in);
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		

	}
	
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
