package sk.amokk.imagestorter.temp;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hhhh extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField = null;
	/**
	 * This is the default constructor
	 */
	public Hhhh() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new BorderLayout());
		this.add(getJTextField(), BorderLayout.CENTER);
		this.add(new JLabel("dfs"), BorderLayout.CENTER);
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField("gfdgd");
		}
		return jTextField;
	}

	

}
