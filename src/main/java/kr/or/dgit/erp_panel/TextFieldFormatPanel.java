package kr.or.dgit.erp_panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TextFieldFormatPanel extends CompPanel {
	private JFormattedTextField tf;
	private MaskFormatter maskFormatter;
	
	public TextFieldFormatPanel() {
		pValue.setLayout(new GridLayout(1, 0, 0, 0));
		maskFormatter = new MaskFormatter();
		tf = new JFormattedTextField(maskFormatter);
		pValue.add(tf);
		
	}
	
	public void setMaskPattern(String pattern, char PlaceHolder){
		try {
			maskFormatter.setMask(pattern);
			maskFormatter.setPlaceholderCharacter(PlaceHolder);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	public String getTfValue(){
		return tf.getText();
	}
	
	public void setTfValue(String value){
		tf.setValue(value);
	}
	public boolean isEmpty(){
		if(tf.getText().equals("")){
			return true;
		}
		return false;
	}
	
	

}
