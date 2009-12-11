package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.utils.ENavigation;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionBack extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static ActionBack instance;
	private static final Logger log = Logger.getLogger(ActionBack.class.getName());
	
	private ActionBack() {
		super();
	}
	
	public static ActionBack getInstance() {
		if (instance == null)
			instance = new ActionBack();
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug("ActionBack action fired");
		ImageUtils.showImage(ENavigation.PREV);
	}

}
