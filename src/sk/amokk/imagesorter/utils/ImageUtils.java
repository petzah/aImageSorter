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
import java.util.ListIterator;

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
	private static ListIterator<File> listIterator = listImages.listIterator();
	
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
		BufferedImage bimg;
		switch (nav) {
		case NEXT:
			bimg = loadImage(getNextImage());
			break;
		case PREV:
			bimg = loadImage(getPrevImage());
			break;
		default:
			bimg = null;
			break;
		}
		PanelCenter.getInstance().add(new Picture(bimg));
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
	    	System.out.println(file.getPath());
	    }
	    ImageUtils.listImages = a;
	    listIterator = listImages.listIterator();
	}
	
	public static boolean copyImage(String pathSource, String pathDestination) {
		return false;
	}
	
	public static boolean moveImage(File imageFile, String pathDestination) {
		return (imageFile.renameTo(new File(pathDestination, imageFile.getName()))) ? true : false;
	}
	
	public static void copyImage(File imageFile, String pathDestination) {
		if (imageFile == null)
			return;
		try {
			FileChannel srcChannel = new FileInputStream(imageFile).getChannel();
			FileChannel dstChannel = new FileOutputStream(pathDestination + File.separator + imageFile.getName()).getChannel();
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
			srcChannel.close();
			dstChannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	public static File getNextImage() {
		return (listIterator.hasNext()) ? listIterator.next() : null;
	}
	
	public static File getPrevImage() {
		return (listIterator.hasPrevious()) ? listIterator.previous() : null;
	}
	
	public static List<File> getListImages() {
		return listImages;
	}

	public static void setListImages(List<File> listImages) {
		ImageUtils.listImages = listImages;
	}

}
