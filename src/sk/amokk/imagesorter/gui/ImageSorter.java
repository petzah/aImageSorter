package sk.amokk.imagesorter.gui;

import java.awt.image.BufferedImage;
import java.awt.BorderLayout;

import javax.swing.SwingUtilities;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JPanel;
import javax.swing.JFrame;

import sk.amokk.imagesorter.FileRecursive;
import sk.amokk.imagesorter.ImageUtils;
import sk.amokk.imagesorter.JImagePanel;

public class ImageSorter  {

	//private JFrame jFrame = null;
	private JFrame jFrame;
	private JPanel jContentPane = null;
	private JImagePanel jImagePanel;  //  @jve:decl-index=0:
	private PanelBottom jPanelRight;
	private PanelGetImagesDirectory jPanelGetImagesDirectory;

	

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(MenuBarTop.getInstance());
			jFrame.setSize(640, 480);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Application");
			
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanelGetImagesDirectory(), BorderLayout.NORTH);
			jContentPane.add(getJImagePanel(), BorderLayout.CENTER);
			jContentPane.add(getPanelRight(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}	
	
	private JImagePanel getJImagePanel() {
		if (jImagePanel == null) {
			BufferedImage bimg = ImageUtils.loadImage(new File("/usr/lib/openoffice/basis3.1/share/gallery/www-back/wood.jpg"));
			jImagePanel = new JImagePanel(bimg);
		}
		return jImagePanel;
	}
	
	private PanelBottom getPanelRight() {
		if (jPanelRight == null) {
			jPanelRight = new PanelBottom();
		}
		return jPanelRight;
	}
	
	private PanelGetImagesDirectory getPanelGetImagesDirectory() {
		 if (jPanelGetImagesDirectory == null) {
			 jPanelGetImagesDirectory = new PanelGetImagesDirectory();
		 }
		 return jPanelGetImagesDirectory;
	}


	
	
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				ImageSorter application = new ImageSorter();
				application.getJFrame().setVisible(true);
				FileRecursive fr = new FileRecursive("/mnt/data1/fotky/florida");
				FilenameFilter filter = new FilenameFilter() {
			        public boolean accept(File dir, String name) {
			            return name.contains("jpg");
			        }
			    };

				File[] fff = fr.listFilesRecursive(filter);
				for (File file : fff) {
					System.out.println(file);
				}
				System.out.println(fff.length);
				
			}
		});
	}

	public void nextImage() {
		//ImageUtils.loadImage(images[i]);
		BufferedImage bimg = ImageUtils.loadImage(new File("/mnt/data1/fotky/florida/new.york/dcim/100km763/100_2736.jpg"));
		JImagePanel jip = new JImagePanel(bimg);
		jFrame.remove(getJImagePanel());
		jFrame.add(jip);
		jFrame.pack();
	}


}
