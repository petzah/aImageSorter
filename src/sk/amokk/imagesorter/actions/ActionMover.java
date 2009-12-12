package sk.amokk.imagesorter.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.gui.PanelMover;
import sk.amokk.imagesorter.utils.ImageUtils;

public class ActionMover extends AbstractAction {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass().getName());
	private PanelMover mover = null;
	
	public ActionMover(PanelMover mover) {
		super();
		this.mover  = mover;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.debug("ActionMover action fired");
		if ((mover.getPath() == "" ) || (mover.getPath() == null)) {
			log.error("destination path for files is null");
			JOptionPane.showMessageDialog(ImageSorter.getJFrame(), "destination path is invalid", "Error", JOptionPane.ERROR_MESSAGE);
			return; 
		}
		if (mover.isMoveRadioButtonSelected()) {
			ImageUtils.moveImage(mover.getPath());
		}
		else {
			ImageUtils.copyImage(mover.getPath());
		}
		ActionNext.getInstance().actionPerformed(e);
	}

}
