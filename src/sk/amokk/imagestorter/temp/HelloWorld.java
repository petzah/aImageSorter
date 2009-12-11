package sk.amokk.imagestorter.temp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloWorld extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("sk.amokk.imagestorter.temp.HelloWorld");
	

	
	public static void main(String[] args) {
		
		HelloWorld hw = new HelloWorld();
		hw.addKeyListener(hw);
		hw.setVisible(true);
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("hello world");
		logger.info("test");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		logger.info("pressed: " + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		logger.info("released: " + e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		logger.info("typed: " + e.getKeyCode());
	}

	

}
