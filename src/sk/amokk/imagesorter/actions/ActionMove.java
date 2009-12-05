package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.gui.PanelMover;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionMove extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private PanelMover mover;
	private static final Logger log = Logger.getLogger("sk.amokk.imagesorter.actions.ActionMove");
	

	public ActionMove(PanelMover panelMover) {
		this.mover = panelMover;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ((mover.getPath() == null) || mover.getPath().isEmpty() ) {
			log.error("directory for moving isn't set");
			return;
		}
		
		log.info("moved to: " + mover.getPath());
		File image = ImageUtils.getActualImage();
		ImageUtils.copyImage(image, mover.getPath()); //copy -> move
		ActionNext.getInstance().actionPerformed(e);
	}
}
