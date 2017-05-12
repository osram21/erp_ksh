package kr.or.dgit.erp_Content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp_panel.TextFiledPanel;

public class erp_Title extends JPanel {

	
	private TextFiledPanel pNo;
	private TextFiledPanel pName;

	public erp_Title() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFiledPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pName = new TextFiledPanel();
		pName.setTitle("직책명");
		add(pName);
	}
	
	public Title getObject(){
		int tcode = Integer.parseInt(pNo.getTfValue().substring(1));
		String tname = pName.getTfValue();
		return new Title(tcode, tname);
	}
	
	public void setObject(Title title){
		pNo.setTfValue(title.getTcode()+"");
		pName.setTfValue(title.getTname());
	}
	
	public void clear(){
		pName.setTfValue("");
		pName.gettF().requestFocus();
	}

	public TextFiledPanel getpNo() {
		return pNo;
	}

	public TextFiledPanel getpName() {
		return pName;
	}
	
	
}
