package kr.or.dgit.erp_view;

import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp_Content.erp_Title;
import kr.or.dgit.erp_table.erp_titleTable;

public class erp_titleView extends JPanel {

	private erp_titleTable pTable;
	private JButton btnSave;
	private JButton btnCancel;
	private erp_Title pContent;
	private JPopupMenu popupMenu;

	public erp_titleView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pContent = new erp_Title();
		add(pContent);
		
		JPanel pBtn = new JPanel();
		add(pBtn);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		pTable = new erp_titleTable();
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
					Title title = pTable.getSelectObject();
					if(title==null){
						JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
						return;
					}
					pContent.setObject(title);
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
					Title title = pTable.getSelectObject();
					if(title == null){
						JOptionPane.showMessageDialog(null, "데이터를 선택해주세요");
						return;
					}try{
						TitleService.getInstance().deleteTitle(title);
						pTable.loadDate();
						init();
						JOptionPane.showMessageDialog(null, "삭제되었습니다");
					}catch(PersistenceException exception){
						JOptionPane.showMessageDialog(null, "데이터사용중");
					}
				}
			}
		});
		popupMenu.add(deleteItem);
	}

	public void loadData(){
		pTable.loadDate();
	}
	
	//버튼 추가염~
	protected void actionPerformedBtnSave(ActionEvent e) {
		Title title = pContent.getObject();
		TitleService.getInstance().insertTitle(title);
		JOptionPane.showMessageDialog(null, "추가되었습니다");
		pContent.clear();
		pTable.loadDate();
		init();
	}
	//취소~
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clear();
	}
	
	public void init(){
		String value = String.format("T%03d", TitleService.getInstance().selectTitle().size()+1);
		pContent.getpNo().setTfValue(value);
		pContent.getpNo().gettF().setEditable(false);
		pContent.getpName().gettF().requestFocus();
	}
	
	
}
