package kr.or.dgit.erp_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.service.EmployeeService;
import kr.or.dgit.erp_Content.erp_Employee;
import kr.or.dgit.erp_table.erp_empTable;

public class erp_empView extends JPanel {

	private erp_Employee pContent;
	private JButton btnSave;
	private JButton btnCancel;
	private erp_empTable pTable;

	public erp_empView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pContent = new erp_Employee();
		add(pContent);
		
		JPanel pBtn = new JPanel();
		add(pBtn);
		
		btnSave = new JButton("추가");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSave(e);
			}
		});
		pBtn.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancel(e);
			}
		});
		pBtn.add(btnCancel);
		
		pTable = new erp_empTable();
		add(pTable);
	}
	
	public void loadDate(){
		pTable.loadDate();
	}
	
	protected void actionPerformedBtnSave(ActionEvent e) {
		Employee employee = pContent.getObject();
		EmployeeService.getInstance().insertEmp(employee);
		JOptionPane.showMessageDialog(null, "추가되었습니다");
		pContent.clear();
		pTable.loadDate();
		init();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clear();
		init();
	}
	
	public void init(){
		List<Employee> list = EmployeeService.getInstance().selectEmp();
		String value;
		if(list.size()==0){
			value = String.format("E%06d", 17001);
		}else{
			value = String.format("E%06d",list.get(list.size()-1).getEno()+1 );
		}
		pContent.getpNo().setTfValue(value);
		pContent.getpNo().gettF().setEditable(false);
		pContent.getpName().gettF().requestFocus();
	}

	public erp_Employee getpContent() {
		return pContent;
	}
}
