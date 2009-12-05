package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;

import sk.amokk.imagesorter.Picture;
import sk.amokk.imagesorter.gui.PanelCenter;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionNext extends AbstractAction {
	
	
	private static final long serialVersionUID = 1L;
	private static ActionNext instance;
	private static int actualImage = 0;
	
	

	private ActionNext() {
		super();
	}
	
	public static ActionNext getInstance() {
		if (instance == null)
			instance = new ActionNext();
		return instance;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ImageUtils.getNextImage() == null)
			return;
		PanelCenter.getInstance().removeAll();
		BufferedImage bimg = ImageUtils.loadImage(ImageUtils.getNextImage());
		PanelCenter.getInstance().add(new Picture(bimg));
		PanelCenter.getInstance().revalidate();
		PanelCenter.getInstance().repaint();
		actualImage++;
		
	}

	
	
}