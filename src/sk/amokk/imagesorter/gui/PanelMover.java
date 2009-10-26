package sk.amokk.imagesorter.gui;


import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import sk.amokk.imagesorter.actions.ActionMove;
import javax.swing.JRadioButton;


public class PanelMover extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField = null;
	private JButton chooserButton = null;
	private int number;
	private JButton moveButton = null;
	private JFileChooser jFileChooser;
	protected PanelMover pm = null;
	protected String path = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	

	public int getNumber() {
		return number;
	}

	
	public String getPath() {
		return path;
	}

	

	/**
	 * This is the default constructor
	 */
	public PanelMover(int number) {
		super();
		this.number = number;
		initialize();
		this.pm = this;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(getButtonMove(), null);
		this.add(getJTextField(), null);
		this.add(getButtonChooser(), null);
		this.add(getJRadioButton(), null);
		this.add(getJRadioButton1(), null);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(""+number), "huhu");
		this.getActionMap().put("huhu", new ActionMove(this));
		
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setPreferredSize(new Dimension(400, 20));
			jTextField.setEditable(false);
			jTextField.setHorizontalAlignment(JTextField.LEFT);
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonChooser() {
		if (chooserButton == null) {
			chooserButton = new JButton("...");
			chooserButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = getJFileChooser();
					int returnValue = fc.showOpenDialog(pm);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						path = fc.getSelectedFile().getAbsolutePath();
			            getJTextField().setText(path);
					}

				}
			});
		}
		return chooserButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonMove() {
		if (moveButton == null) {
			moveButton = new JButton();
			moveButton.setAction(new ActionMove(this));
			moveButton.setText(""+number);

		}
		return moveButton;
	}

	private JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new JFileChooser();
			jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
		}
		return jFileChooser;
	}


	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton("Copy");
		}
		return jRadioButton;
	}


	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton("Move");
		}
		return jRadioButton1;
	}



}  //  @jve:decl-index=0:visual-constraint="10,22"
