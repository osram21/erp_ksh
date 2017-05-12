package kr.or.dgit.erp_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.service.DepartmentService;
import kr.or.dgit.erp_Content.erp_Department;
import kr.or.dgit.erp_table.erp_deptTable;

public class erp_deptView extends JPanel {

	private JButton btnSave;
	private JButton btnCancel;
	private erp_Department pContent;
	private erp_deptTable pTable;

	/**
	 * Create the panel.
	 */
	public erp_deptView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pContent = new erp_Department();
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
		
		pTable = new erp_deptTable();
		add(pTable);

	}
	public void loadDate(){
		pTable.loadDate();
	}
	
	protected void actionPerformedBtnSave(ActionEvent e) {
		Department department = pContent.getObject();
		DepartmentService.getInstance().insertDept(department);
		JOptionPane.showMessageDialog(null, "추가되었습니다");
		pContent.clear();
		pTable.loadDate();
		init();
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clear();
	}
	
	public void init(){
		String value = String.format("D%03d", DepartmentService.getInstance().selectDept().size()+1);
		pContent.getpNo().setTfValue(value);
		pContent.getpNo().gettF().setEditable(false);
		pContent.getpName().gettF().requestFocus();
	}
}
