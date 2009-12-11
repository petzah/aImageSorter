package sk.amokk.imagesorter.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelCenter extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PanelCenter instance;
	
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
		this.setPreferredSize(new Dimension(200,200));
		this.setLayout(new BorderLayout());
	}
	
	public static PanelCenter getInstance() {
		if (instance == null) 
			instance = new PanelCenter();
		return instance;
	}

}
