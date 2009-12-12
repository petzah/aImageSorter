package sk.amokk.imagesorter.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.FileRecursive;
import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.Picture;
import sk.amokk.imagesorter.gui.PanelCenter;

public class ImageUtils {
	private static List<File> listImages = new ArrayList<File>();
	
	private static final Logger log = Logger.getLogger(ImageUtils.class.getName());
	
	private static BufferedImage actualImage = null;
	
	private static int indexOfImage = -1;

	private ImageUtils(){}
	
	private static BufferedImage loadImage(File f) {
		if(f == null)	return null;
		BufferedImage bimg = null;  
		try {
			bimg = ImageIO.read(f);
		} catch (Exception e) {  
			//e.printStackTrace();
			log.error("can't read file: " + f);
			JOptionPane.showMessageDialog(ImageSorter.getJFrame(), "Can't read file: " + f, "Can't read file", JOptionPane.ERROR_MESSAGE);
		}
		
		return bimg;  
	}
	
	public static void showImage(ENavigation nav) {
		PanelCenter.getInstance().removeAll();
		switch (nav) {
		case NEXT:
			indexOfImage++;
			actualImage = loadImage(listImages.get(indexOfImage));
			break;
		case PREV:
			if(indexOfImage == 0) {
				JOptionPane.showMessageDialog(ImageSorter.getJFrame(), "You are on beginning", "Info", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			indexOfImage--;
			actualImage = loadImage(listImages.get(indexOfImage));
			break;
		default:
			break;
		}
		log.debug("showing Image with index number: " + indexOfImage );
		PanelCenter.getInstance().add(new Picture(actualImage));
		PanelCenter.getInstance().revalidate();
		PanelCenter.getInstance().repaint();
	}
	
	public static void loadImages(String directory) {
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.contains("jpg");
	        }
	    };	
	    FileRecursive f = new FileRecursive(directory);
	    List<File> a = f.listFilesRecursive(filter);
	    for (File file : a) {
	    	log.debug("found file: " + file.getPath());
	    }
	    ImageUtils.listImages = a;
	}
	
		

	public static void moveImage(String pathDestination) {
		File imageFile = listImages.get(indexOfImage);
		copyImage(pathDestination);
		if (!imageFile.delete()) {
			log.error("File: " + imageFile.getAbsolutePath() + " was copied to destination directory: " + pathDestination + "" +
					" but not removed from source directory");
		}
		else {
			log.debug("removed: " + imageFile.getAbsolutePath());
			//remove also from list
			listImages.remove(indexOfImage);
			//because one was removed we need to decrease index 
			indexOfImage--;
		}
	}
	
	public static void copyImage(String pathDestination) {
		File imageFile = listImages.get(indexOfImage);
		if (imageFile == null)
			return;
		try {
			FileChannel srcChannel = new FileInputStream(imageFile).getChannel();
			FileChannel dstChannel = new FileOutputStream(pathDestination + File.separator + imageFile.getName()).getChannel();
			log.debug("copying " + imageFile.getName() + " to " + pathDestination);
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
			srcChannel.close();
			dstChannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static BufferedImage getActualImage() {
		return actualImage;
	}


	public static List<File> getListImages() {
		return listImages;
	}
	

}
