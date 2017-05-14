package kr.or.dgit.erp_main;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.erp_view.erp_deptView;
import kr.or.dgit.erp_view.erp_empView;
import kr.or.dgit.erp_view.erp_titleView;

public class ERP_Application extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ERP_Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		JButton btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnEmployee(arg0);
			}
		});
		contentPane.add(btnEmployee);
		
		JButton btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDepartment(e);
			}
		});
		contentPane.add(btnDepartment);
		
		JButton btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnTitle(e);
			}
		});
		contentPane.add(btnTitle);
	}

	protected void actionPerformedBtnEmployee(ActionEvent arg0) {
		erp_empView empview = new erp_empView();
		empview.getpContent().setCombodate();
		empview.loadDate();
		empview.init();
		JFrame jf = new JFrame();
		jf.add(empview);
		jf.setBounds(300, 400, 500, 600);
		jf.setVisible(true);
	}
	protected void actionPerformedBtnDepartment(ActionEvent e) {
		erp_deptView deptview = new erp_deptView();
		deptview.loadDate();
		deptview.init();
		JFrame jf = new JFrame();
		jf.add(deptview);
		jf.setBounds(300, 400, 500, 600);
		jf.setVisible(true);
	}
	
	protected void actionPerformedBtnTitle(ActionEvent e) {
		erp_titleView titleview = new erp_titleView();
		titleview.loadData();
		titleview.init();
		JFrame jf = new JFrame();
		jf.add(titleview);
		jf.setBounds(300, 400, 500, 600);
		jf.setVisible(true);
	}
}
