package kr.or.dgit.erp_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.EmployeeService;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp_Content.erp_Employee;
import kr.or.dgit.erp_table.erp_empTable;

public class erp_empView extends JPanel {

	private erp_Employee pContent;
	private JButton btnSave;
	private JButton btnCancel;
	private erp_empTable pTable;
	private JPopupMenu popupMenu;
	
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
		pTable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(pTable.getTable(), e.getX(), e.getY());
				}
			}
			
		});
		createPopupMenu();
		add(pTable);
	}
	
	private void createPopupMenu() {
		popupMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")){
					Employee emp = pTable.getSelectObject();
					if(emp==null){
						JOptionPane.showMessageDialog(null, "데이터를 선택해주세요");
						return;
					}
					pContent.setObject(emp);
					btnSave.setText("수정");
				}
				
			}
		});
		popupMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("삭제")){
					Employee emp = pTable.getSelectObject();
					if(emp==null){
						JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
						return;
					}try{
						EmployeeService.getInstance().deleteEmp(emp);
						pTable.loadDate();
						init();
						JOptionPane.showMessageDialog(null, "삭제되었습니다");
					}catch(PersistenceException exception){
						JOptionPane.showMessageDialog(null, "데이터사용중 뺄수 없슴니다");
					}
				}
				
			}
		});
		popupMenu.add(deleteItem);
		
	}

	public void loadDate(){
		pTable.loadDate();
	}
	
	protected void actionPerformedBtnSave(ActionEvent e) {
		if(pContent.checkItem()){
			if(e.getActionCommand().equals("추가")){
				Employee erp = pContent.getObject();
				EmployeeService.getInstance().insertEmp(erp);
				JOptionPane.showMessageDialog(null, "추가되었습니다");
			}else{
				Employee erp = pContent.getObject();
				EmployeeService.getInstance().updateEmp(erp);
				JOptionPane.showMessageDialog(null, "수정되었습니다");
				btnSave.setText("추가");
			}
			pContent.clear();
			pTable.loadDate();
			init();
		}
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
