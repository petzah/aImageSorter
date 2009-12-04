package sk.amokk.imagesorter.gui;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;

import javax.swing.SwingUtilities;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import sk.amokk.imagesorter.actions.ActionNext;
import sk.amokk.imagesorter.utils.PropertiesHandle;

public class ImageSorter extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static JFrame jFrame;
	private JPanel jContentPane = null;
	private PanelBottom jPanelRight;
	private PanelTop jPanelGetImagesDirectory;
	

	
	private ImageSorter() {
		super();
		initialize();
	}
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(MenuBarTop.getInstance());
		this.setSize(640, 480);
		this.setContentPane(getJContentPane());
		this.setTitle("aImageSorter");
		this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "next");
		this.getRootPane().getActionMap().put("next", ActionNext.getInstance());
		this.addWindowListener( new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        quit();
		      }
		 });
		
	}
	
	protected void quit() {
		PropertiesHandle.store();
		System.exit(0);
	}
	public static JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new ImageSorter();
		}
		return jFrame;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanelGetImagesDirectory(), BorderLayout.NORTH);
			jContentPane.add(PanelCenter.getInstance(), BorderLayout.CENTER);
			jContentPane.add(getPanelRight(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}	
	
	private PanelBottom getPanelRight() {
		if (jPanelRight == null) {
			jPanelRight = new PanelBottom();
		}
		return jPanelRight;
	}
	
	private PanelTop getPanelGetImagesDirectory() {
		 if (jPanelGetImagesDirectory == null) {
			 jPanelGetImagesDirectory = new PanelTop();
		 }
		 return jPanelGetImagesDirectory;
	}


	
	
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PropertiesHandle.load();
				ImageSorter.getJFrame().setVisible(true);
				ImageSorter.getJFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}



}
