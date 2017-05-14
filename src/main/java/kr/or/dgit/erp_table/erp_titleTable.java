package kr.or.dgit.erp_table;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.TitleService;

public class erp_titleTable extends JPanel {
	private JTable table;

	
	public erp_titleTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumnDate()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CellAlign(SwingConstants.CENTER,0,1);
		
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
		return new String[]{"번호","직책명"};
	}
	private Object[][] getRowDate() {
		List<Title> list = TitleService.getInstance().selectTitle();
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i < datas.length; i++){
			datas[i] = list.get(i).toArray();
		}
		return datas;
	}
	public JTable getTable() {
		return table;
	}
	
	public Title getSelectObject(){
		int selectedidx = table.getSelectedRow();
		if(selectedidx == -1)return null;
		String Tcode = (String) table.getValueAt(selectedidx, 0).toString().substring(1);
		String Tname =(String)table.getValueAt(selectedidx, 1);
		Map<String, Object> param = new HashMap<>();
		param.put("Tcode", Tcode);
		param.put("Tname", Tname);
		return TitleService.getInstance().selectByOne(param);
	}
}
