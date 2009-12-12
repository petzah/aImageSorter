package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.utils.ENavigation;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionPrev extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static ActionPrev instance;
	
	private static String name = "Prev";
	private static final Logger log = Logger.getLogger(ActionPrev.class.getName());
	private static String description = "show previous image";
	private static ImageIcon smallIcon = new ImageIcon(ImageSorter.class.getResource("/resources/images/left_16.png"));
	private static ImageIcon largeIcon = new ImageIcon(ImageSorter.class.getResource("/resources/images/left_32.png"));
	
	private ActionPrev() {
		super(name);
		putValue(SHORT_DESCRIPTION, description );
		putValue(MNEMONIC_KEY, KeyEvent.VK_BACK_SPACE);
		putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, true));
		putValue(SMALL_ICON, smallIcon);
		putValue(LARGE_ICON_KEY, largeIcon);
	}
	
	public static ActionPrev getInstance() {
		if (instance == null)
			instance = new ActionPrev();
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug("ActionBack action fired");
		ImageUtils.showImage(ENavigation.PREV);
	}

}
