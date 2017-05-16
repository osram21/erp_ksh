package kr.or.dgit.erp_Content;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.DepartmentService;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp_panel.ComboPanel;
import kr.or.dgit.erp_panel.RadioPanel;
import kr.or.dgit.erp_panel.SpinnerPanel;
import kr.or.dgit.erp_panel.TextFieldFormatPanel;
import kr.or.dgit.erp_panel.TextFiledPanel;

public class erp_Employee extends JPanel {
	private TextFiledPanel pNo;
	private TextFiledPanel pName;
	private ComboPanel<String> pTitle;
	private SpinnerPanel pSalary;
	private RadioPanel pSex;
	private ComboPanel<String> pDepartment;
	private TextFieldFormatPanel pJoindate;
	private List<Title> Tlist;
	private List<Department>Dlist;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public erp_Employee() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFiledPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pName = new TextFiledPanel();
		pName.setTitle("사원명");
		add(pName);
		
		pTitle = new ComboPanel<>();
		pTitle.setTitle("직책");
		add(pTitle);
		
		pSalary = new SpinnerPanel();
		pSalary.setTitle("급여");
		pSalary.setValues(1500000,1000000,5000000,100000);
		add(pSalary);
		
		pSex = new RadioPanel();
		pSex.setTitle("성별");
		pSex.setRadioItems("남","여");
		add(pSex);
		
		pDepartment = new ComboPanel<>();
		pDepartment.setTitle("부서");
		add(pDepartment);
		
		pJoindate = new TextFieldFormatPanel();
		pJoindate.setTitle("입사일");
		pJoindate.setMaskPattern("####-##-##", '#');
		pJoindate.setTfValue(Day());
		add(pJoindate);
	}
	
	public Employee getObject(){
		int eno = Integer.parseInt(pNo.getTfValue().substring(1));
		String ename = pName.getTfValue();
		int salary = (int)pSalary.getValue();
		String[] dept = (String[])pDepartment.getSelectItem().toString().trim().split("\\(");
		Department department = DepartmentService.getInstance().selectDeptbyName(new Department(dept[0]));
		Boolean gender = pSex.getSelectedItem().equals("남")?true:false;
		Date joinDate = null;
		try{
			if(pJoindate.getTfValue()!=null){
				joinDate = sdf.parse(pJoindate.getTfValue());
			}
		}catch(ParseException e){
			e.printStackTrace();
		}
		Title title = TitleService.getInstance().selectTitlebyName(new Title((String)pTitle.getSelectItem()));
		return new Employee(eno, ename, salary, department, gender, joinDate, title);
	}
	
	public void setObject(Employee employee){
		pNo.setTfValue(String.format("E%06d", employee.getEno()));
		pName.setTfValue(employee.getEname());
		pSalary.setValue(employee.getSalary());
		pDepartment.setSelectedItem(employee.getDepartment().getDcode());
		pSex.setSelectedItem(employee.getGender()?"남":"여");
		String s = sdf.format(employee.getJoinDate());
		pJoindate.setTfValue(s);
		pTitle.setSelectedItem(employee.getTitle().getTcode());
	}
	
	public void clear(){
		pName.setTfValue("");
		pSalary.setValue(1500000);
		pDepartment.setSelectedItem(0);
		pSex.setSelectedItem(0);
		pJoindate.setTfValue(Day());
		pTitle.setSelectedItem(0);
	}
	
	public void setCombodate(){
		Tlist = TitleService.getInstance().selectTitle();
		Dlist = DepartmentService.getInstance().selectDept();
		for(Title t : Tlist){
			pTitle.getCombobox().addItem(t.toString());
		}
		for(Department D : Dlist){
			pDepartment.getCombobox().addItem(D.toString());
		}
	}
	
	public boolean checkItem(){
		if(pName.getTfValue().equals("")){
			JOptionPane.showMessageDialog(null, "빈칸이 존재합니다");
			return false;
		}else{
			return true;
		}
		
	}
	
	private String Day(){
		String s = sdf.format(new Date());
		return s;
	}

	public TextFiledPanel getpNo() {
		return pNo;
	}

	public TextFiledPanel getpName() {
		return pName;
	}

	public ComboPanel getpTitle() {
		return pTitle;
	}

	public SpinnerPanel getpSalary() {
		return pSalary;
	}

	public RadioPanel getpSex() {
		return pSex;
	}

	public ComboPanel getpDepartment() {
		return pDepartment;
	}

	public TextFieldFormatPanel getpJoindate() {
		return pJoindate;
	}
}
