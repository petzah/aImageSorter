package sk.amokk.imagesorter.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;
import java.util.List;

public class PanelBottom extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSpinner jSpinner;
	private static List<PanelMover> panels = new ArrayList<PanelMover>();  //  @jve:decl-index=0:
	private static final int MAX_MOVERS = 5;

	/**
	 * This is the default constructor
	 */
	public PanelBottom() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new GridBagLayout());
		//this.setBorder(BorderFactory.createLineBorder(Color.red, 4));
		
		for (int i=0; i<MAX_MOVERS; i++ ) {
			panels.add(new PanelMover(i+1));
		}
		setMoversFields();
		
	}
	
	protected void setMoversFields() {
		Insets ins = new Insets(1, 1, 1, 1);
		this.removeAll();
//		for (int i=0; i<this.getComponentCount(); i++) {
//			if(this.getComponent(i).getClass() == PanelMover.class)
//				this.remove(i);
//		}
		

		int pom;
		for (pom = 0; pom<(Integer)getJSpinner().getValue(); pom++ ) {
			this.add(panels.get(pom), 		new GridBagConstraints(0,pom,1,1,1,0,GridBagConstraints.LINE_END,GridBagConstraints.HORIZONTAL,ins,0,0));
		}
		this.add(getJSpinner(),				new GridBagConstraints(1,pom-1,1,1,0,0,GridBagConstraints.LINE_END,GridBagConstraints.NONE,ins,0,0));
		this.revalidate();
		this.repaint();
	}

	private JSpinner getJSpinner() {
		if (jSpinner == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, MAX_MOVERS, 1);
			jSpinner = new JSpinner(model);
			JFormattedTextField ftf = ((JSpinner.DefaultEditor)jSpinner.getEditor()).getTextField();
			ftf.setEditable(false);
			ftf.setBackground(Color.WHITE);
			jSpinner.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					setMoversFields();
					
				}
			});
		}
		return jSpinner;
	}
	
	
	
	


}  //  @jve:decl-index=0:visual-constraint="10,10"
