package kr.or.dgit.erp_panel;

import java.awt.GridLayout;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SpinnerPanel extends CompPanel {
	private JSpinner spinner;
	
	public SpinnerPanel() {
		pValue.setLayout(new GridLayout(1, 0, 0, 0));
		
		spinner = new JSpinner();
		pValue.add(spinner);
	}
	public void setValues(double value, double minValue, double maxValue, double stepsize){
		spinner.setModel(new SpinnerNumberModel(value, minValue, maxValue, stepsize));	
	}
	
	public void setValue(double value){
		spinner.setValue(value);
	}
	
	public double getValue(){
		return(double) spinner.getValue();
	}
}
