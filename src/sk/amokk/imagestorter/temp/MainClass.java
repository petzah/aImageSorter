package sk.amokk.imagestorter.temp;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MainClass() {
    super("Opaque JPanel Demo");
    setSize(400, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel opaque = createNested(true);
    JPanel notOpaque = createNested(false);

    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(opaque);
    getContentPane().add(notOpaque);
  }

  public static void main(String[] args) {
    MainClass oe = new MainClass();
    oe.setVisible(true);
  }

  public JPanel createNested(boolean opaque) {
    JPanel outer = new JPanel(new FlowLayout());
    JPanel inner = new JPanel(new FlowLayout());
    outer.setBackground(Color.white);
    inner.setBackground(Color.black);

    inner.setOpaque(opaque);
    inner.setBorder(BorderFactory.createLineBorder(Color.gray));

    inner.add(new JButton("Button"));
    outer.add(inner);

    return outer;
  }
}