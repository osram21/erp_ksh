package kr.or.dgit.erp_panel;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.image.renderable.RenderableImageOp;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanel extends CompPanel {
	private ButtonGroup radioGrp = new ButtonGroup();
	
	public RadioPanel() {
		pValue.setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	public void setRadioItems(String...items){
		
		for(int i = 0; i< items.length; i++){
			JRadioButton rdBtn = new JRadioButton(items[i]);
			radioGrp.add(rdBtn);
			pValue.add(rdBtn);
		}
	}
	public void setSelectedItem(String item){
		JRadioButton btn =null;
		for(Component c : pValue.getComponents()){
			btn = (JRadioButton) c;
			if(btn.getText().equals(item)){
				btn.setSelected(true);
			}
		}
	}
	
	public void setSelectedItem(int idx){
		((JRadioButton)pValue.getComponent(idx)).setSelected(true);
	}
	
	public String getSelectedItem(){
		JRadioButton btn =null;
		String selectedStr = null;
		for(Component c : pValue.getComponents()){
			btn = (JRadioButton) c;
			if(btn.isSelected()){
				btn.setSelected(true);
				return btn.getText();
			}
		}
		return null;
	}
}
