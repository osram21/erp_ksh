package kr.or.dgit.erp_table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
}
