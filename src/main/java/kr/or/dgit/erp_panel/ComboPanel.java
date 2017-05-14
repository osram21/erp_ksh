package kr.or.dgit.erp_panel;

import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

public class ComboPanel<T> extends CompPanel {
	
	private JComboBox<T> tf;
	
	public ComboPanel() {
		pValue.setLayout(new GridLayout(1, 0, 0, 0));
		tf = new JComboBox<>();
		pValue.add(tf);
		
	}
	public void setComboData(List<T> items){
		for(T t :items){
			tf.addItem(t);
		}
	}
	public Object getSelectItem(){
		return tf.getSelectedItem();
	}
	public void setSelectedItem(T item){
		tf.setSelectedItem(item);
	}
	public void setSelectedItem(int idx){
		tf.setSelectedIndex(idx);
	}
	public JComboBox<T> getCombobox(){
		return tf;
	}
}