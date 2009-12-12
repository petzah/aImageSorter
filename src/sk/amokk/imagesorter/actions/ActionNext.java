package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.utils.ENavigation;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionNext extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static ActionNext instance;
	private static final Logger log = Logger.getLogger(ActionNext.class.getName());
	
	private static final URL imageURL = ImageSorter.class.getResource("/images/addCategory.png");
	private static final String NAME = "Next";
	private static final String DESCRIPTION = "Show next image";
	

	public ActionNext() {
		super(NAME, new ImageIcon(imageURL));
		putValue(SHORT_DESCRIPTION, DESCRIPTION);
		putValue(MNEMONIC_KEY, KeyEvent.VK_SPACE);
		
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
