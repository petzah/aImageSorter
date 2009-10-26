package sk.amokk.imagesorter.gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DialogAbout extends JDialog {
	
	
	private static final long serialVersionUID = 1L;
	private static DialogAbout instance;
	private JLabel aboutVersionLabel;
	private JPanel aboutContentPane;
	
	private DialogAbout() {
		super();
		initialize();
		
	}

	private void initialize() {
		this.setTitle("About");
		this.setContentPane(getAboutContentPane());
		
	}

	public static DialogAbout getInstance() {
		if (instance == null)
			instance = new DialogAbout();
		return instance;
	}
	
	
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}


}
