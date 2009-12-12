package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.utils.ENavigation;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionNext extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static ActionNext instance;
	private static final Logger log = Logger.getLogger(ActionNext.class.getName());
	
	private static ImageIcon smallIcon = new ImageIcon(ImageSorter.class.getResource("/images/right_16.png"));
	private static ImageIcon largeIcon = new ImageIcon(ImageSorter.class.getResource("/images/right_32.png"));
	private static final String name = "Next";
	private static final String description = "Show next image";
	

	private ActionNext() {
		super(name);
		putValue(SHORT_DESCRIPTION, description);
		putValue(MNEMONIC_KEY, KeyEvent.VK_SPACE);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true));
		putValue(SMALL_ICON, smallIcon);
		putValue(LARGE_ICON_KEY, largeIcon);
	}

	
	public static ActionNext getInstance() {
		if (instance == null)
			instance = new ActionNext();
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug("ActionNext action fired");
		ImageUtils.showImage(ENavigation.NEXT);
	}
}
