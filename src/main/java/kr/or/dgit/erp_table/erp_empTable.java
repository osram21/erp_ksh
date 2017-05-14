package kr.or.dgit.erp_table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.service.EmployeeService;
import kr.or.dgit.erp.service.TitleService;

public class erp_empTable extends JPanel {
	private JTable table;

	public erp_empTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumnDate()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CellAlign(SwingConstants.CENTER,0,1,2,3,4,5,6);
	}
	private void CellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}
	private Object[] getColumnDate() {
		return new String[]{"번호","사원명","직책","급여","성별","부서","입사일"};
	}
	private Object[][] getRowDate() {
		List<Employee> list = EmployeeService.getInstance().selectEmp();
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i < datas.length; i++){
			datas[i] = list.get(i).toArray();
		}
		return datas;
	}
}
