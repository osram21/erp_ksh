package kr.or.dgit.erp_panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CompPanel extends JPanel {
	private JLabel lblTitle;
	protected JPanel pValue;
	
	public CompPanel() {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTitle);
		
		pValue = new JPanel();
		add(pValue);
	}
	
	public void setTitle(String title){
		lblTitle.setText(title);
	}

	public JPanel getpValue() {
		return pValue;
	}
	
}
