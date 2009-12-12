package sk.amokk.imagesorter.gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import sk.amokk.imagesorter.ImageSorter;
import sk.amokk.imagesorter.actions.ActionPrev;
import sk.amokk.imagesorter.actions.ActionNext;
import sk.amokk.imagesorter.utils.ENavigation;
import sk.amokk.imagesorter.utils.ImageUtils;


public class MenuBarTop extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private static MenuBarTop instance;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuItem aboutMenuItem;
	private JMenuItem exitMenuItem;
	private JMenu helpMenu;
	private JMenuItem saveMenuItem;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu = null;
	private JMenu goMenu = null;
	private JMenuItem goPrevMenuItem = null;
	private JMenuItem goNextMenuItem = null;
	private JMenuItem goBeginMenuItem = null;
	private JMenuItem goEndMenuItem = null;
	
	private MenuBarTop() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.add(getFileMenu());
		this.add(getEditMenu());
		this.add(getGoMenu());
		this.add(getHelpMenus());
	}

	public static MenuBarTop getInstance() {
		if (instance == null)
			instance = new MenuBarTop();
		return instance;
	}

	
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}
	
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Edit");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}
	
	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenus() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
			helpMenu.add(getJMenu());
		}
		return helpMenu;
	}

	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ImageSorter.quit();
				}
			});
		}
		return exitMenuItem;
	}

	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = DialogAbout.getInstance();
					aboutDialog.pack();
					//Point loc = getJFrame().getLocation();
					//loc.translate(20, 20);
					//boutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}
	
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Cut");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK, true));
			cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("cut");
				}
			});
			
		}
		return cutMenuItem;
	}

	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Copy");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Paste");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}

	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
		}
		return jMenu;
	}

	private JMenu getGoMenu() {
		if (goMenu == null) {
			goMenu = new JMenu("Go");
			goMenu.add(getGoBeginMenuItem());
			goMenu.add(getGoPrevMenuItem());
			goMenu.add(getGoNextMenuItem());
			goMenu.add(getGoEndMenuItem());
			
		}
		return goMenu;
	}

	private JMenuItem getGoPrevMenuItem() {
		if (goPrevMenuItem == null) {
			goPrevMenuItem = new JMenuItem("Previous");
			goPrevMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, true));
			goPrevMenuItem.setAction(ActionPrev.getInstance());
		}
		return goPrevMenuItem;
	}

	private JMenuItem getGoNextMenuItem() {
		if (goNextMenuItem == null) {
			goNextMenuItem = new JMenuItem("Next");
			goNextMenuItem.setAction(ActionNext.getInstance());
		}
		return goNextMenuItem;
	}

	private JMenuItem getGoBeginMenuItem() {
		if (goBeginMenuItem == null) {
			goBeginMenuItem = new JMenuItem("Begin");
			goBeginMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0, true));
			goBeginMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ImageUtils.showImage(ENavigation.BEGINNING);
				}
			});
		}
		return goBeginMenuItem;
	}
	
	private JMenuItem getGoEndMenuItem() {
		if (goEndMenuItem == null) {
			goEndMenuItem = new JMenuItem("End");
			goEndMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_END, 0, true));
			goEndMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ImageUtils.showImage(ENavigation.END);
				}
			});
		}
		return goEndMenuItem;
	}

}
