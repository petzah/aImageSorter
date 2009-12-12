package sk.amokk.imagesorter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;

import javax.swing.SwingUtilities;

import javax.swing.JPanel;
import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sk.amokk.imagesorter.gui.MenuBarTop;
import sk.amokk.imagesorter.gui.PanelBottom;
import sk.amokk.imagesorter.gui.PanelCenter;
import sk.amokk.imagesorter.gui.PanelTop;
import sk.amokk.imagesorter.utils.PropertiesHandler;


public class ImageSorter extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static JFrame jFrame;
	private JPanel jContentPane = null;
	private PanelBottom jPanelBottom;
	private PanelTop jPanelTop;
	private static Logger log = Logger.getLogger(ImageSorter.class.getName());
	

	
	private ImageSorter() {
		super();
		initialize();
	}
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setJMenuBar(MenuBarTop.getInstance());
		this.setSize(640, 480);
		this.setContentPane(getJContentPane());
		this.setTitle("aImageSorter");
		
		this.addWindowListener( new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        quit();
		      }
		 });
		
		//initialize log4j
		PropertyConfigurator.configure("log4j.properties");
		log.info("application started");
	}
	
	public static void quit() {
		PropertiesHandler.store();
		log.info("application ended");
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
			jContentPane.add(getPanelTop(), BorderLayout.NORTH);
			jContentPane.add(PanelCenter.getInstance(), BorderLayout.CENTER);
			jContentPane.add(getPanelBottom(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}	
	
	private PanelBottom getPanelBottom() {
		if (jPanelBottom == null) {
			jPanelBottom = new PanelBottom();
		}
		return jPanelBottom;
	}
	
	private PanelTop getPanelTop() {
		 if (jPanelTop == null) {
			 jPanelTop = new PanelTop();
		 }
		 return jPanelTop;
	}

	
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PropertiesHandler.load();
				ImageSorter.getJFrame().setVisible(true);
			}
		});
	}



}
