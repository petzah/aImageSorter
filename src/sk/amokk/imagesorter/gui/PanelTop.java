package sk.amokk.imagesorter.gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.utils.ImageUtils;
import sk.amokk.imagesorter.utils.PropertiesHandle;

import javax.swing.JLabel;

public class PanelTop extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField = null;
	private JButton jButton = null;
	private JFileChooser jFileChooserGetImagesDirectory;
	private JLabel jLabelCountImages = null;

	/**
	 * This is the default constructor
	 */
	public PanelTop() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(553, 32);
		this.setLayout(new FlowLayout());
		this.add(getJTextField());
		this.add(getJButton(), null);
		this.add(getJLabelCountImages(), null);
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setText("");
			jTextField.setPreferredSize(new Dimension(400, 20));
			jTextField.setEditable(false);
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("...");
			jButton.setFocusable(false);
			jButton.setPreferredSize(new Dimension(53, 20));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = getJFileChooserImagesDirectory();
					int returnValue = fc.showOpenDialog(ImageSorter.getJFrame());
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						String choosedDir = fc.getSelectedFile().getAbsolutePath();
			            getJTextField().setText(choosedDir);
			            //TODO fix this ugly line
			            ImageUtils.listImages = ImageUtils.getImages(choosedDir);
			            getJLabelCountImages().setText(""+ImageUtils.listImages.length);
			            PropertiesHandle.properties.setProperty("lastOpenedDir", choosedDir);
					}
				}
			});
			
		}
		return jButton;
	}
	
	protected JLabel getJLabelCountImages() {
		if (jLabelCountImages == null) {
			jLabelCountImages = new JLabel("0");
		}
		return jLabelCountImages;
	}

	private JFileChooser getJFileChooserImagesDirectory() {
		if (jFileChooserGetImagesDirectory == null) {
			jFileChooserGetImagesDirectory = new JFileChooser(PropertiesHandle.properties.getProperty("lastOpenedDir"));
			jFileChooserGetImagesDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		return jFileChooserGetImagesDirectory;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
