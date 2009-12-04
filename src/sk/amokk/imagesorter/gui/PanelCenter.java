package sk.amokk.imagesorter.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JPanel;

import sk.amokk.imagesorter.Picture;
import sk.amokk.imagesorter.utils.ImageUtils;

public class PanelCenter extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PanelCenter instance;
	private Picture picture;
	
	private PanelCenter() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(200,200));
		this.setLayout(new BorderLayout());
		BufferedImage image = ImageUtils.loadImage(new File("/home/amokk/temp/tux.jpg"));
		picture = new Picture(image);
        this.add(picture);
	}
	
	public static PanelCenter getInstance() {
		if (instance == null)
			instance = new PanelCenter();
		return instance;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	

}
