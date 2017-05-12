package kr.or.dgit.erp_Content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp_panel.TextFiledPanel;

public class erp_Department extends JPanel {
	private TextFiledPanel pNo;
	private TextFiledPanel pName;
	private TextFiledPanel pFloor;

	public erp_Department() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFiledPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pName = new TextFiledPanel();
		pName.setTitle("부서명");
		add(pName);
		
		pFloor = new TextFiledPanel();
		pFloor.setTitle("위치");
		add(pFloor);
	}
	
	public Department getObject(){
		int dcode = Integer.parseInt(pNo.getTfValue().substring(1));
		String dname = pName.getTfValue();
		int floor = Integer.parseInt(pFloor.getTfValue());
		return new Department(dcode, dname, floor);
	}
	
	public void setObject(Department department){
		pNo.setTfValue( department.getDcode()+"");
		pName.setTfValue(department.getDname());
		pFloor.setTfValue(department.getFloor()+"");
	}
	
	public void clear(){
		pName.setTfValue("");
		pFloor.setTfValue("");
		pName.gettF().requestFocus();
	}

	public TextFiledPanel getpNo() {
		return pNo;
	}

	public TextFiledPanel getpName() {
		return pName;
	}

	public TextFiledPanel getpFloor() {
		return pFloor;
	}
	
	
}
