package kr.or.dgit.erp_Content;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.DepartmentService;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp_panel.ComboPanel;
import kr.or.dgit.erp_panel.RadioPanel;
import kr.or.dgit.erp_panel.SpinnerPanel;
import kr.or.dgit.erp_panel.TextFiledPanel;

public class erp_Employee extends JPanel {

	private TextFiledPanel pNo;
	private TextFiledPanel pName;
	private ComboPanel<Title> pTitle;
	private SpinnerPanel pSalary;
	private RadioPanel pSex;
	private ComboPanel<Department> pDepartment;
	private TextFiledPanel pJoindate;

	public erp_Employee() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pNo = new TextFiledPanel();
		pNo.setTitle("번호");
		add(pNo);
		
		pName = new TextFiledPanel();
		pName.setTitle("사원명");
		add(pName);
		
		pTitle = new ComboPanel();
		TitleService ts = new TitleService();
		List<Title> tslist = ts.selectTitle();
		pTitle.setComboDate(tslist);
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
		
		pDepartment = new ComboPanel();
		DepartmentService dts = new DepartmentService();
		List<Department> list = dts.selectDept();
		pDepartment.setComboDate(list);
		pDepartment.setTitle("부서");
		add(pDepartment);
		
		pJoindate = new TextFiledPanel();
		pJoindate.setTitle("입사일");
		add(pJoindate);
	}
	
	public Employee getObject(){
		int eno = Integer.parseInt(pNo.getTfValue().substring(1));
		String ename = pName.getTfValue();
		int salary = (int)pSalary.getValue();
		
		Department department = pDepartment.getCombItem();
		System.out.println(pDepartment.getCombItem());
		Boolean gender = pSex.getSelectedItem().equals("남")?true:false;
		String joinDate = pJoindate.getTfValue();
		
		/*System.out.println("title:"+title);
		Map<String, Object> param = new HashMap<>();
		param.put("Tcode", title.getTname());
		System.out.println("param:"+param);*/
		/*Title title = TitleService.getInstance().selectOne(param);*/
		Title title = pTitle.getCombItem();
		return new Employee(eno, ename, salary, department, gender, joinDate, title);
	}
	
	public void setObject(Employee employee){
		pNo.setTfValue(employee.getEno()+"");
		pName.setTfValue(employee.getEname());
		pSalary.setValue(employee.getSalary());
		pDepartment.setSelected(employee.getDepartment().getDcode());
		pSex.setSelectedItem(employee.getGender()?"남":"여");
		pJoindate.setTfValue(employee.getJoinDate());
		pTitle.setSelected(employee.getTitle().getTcode());
	}
	
	public void clear(){
		pName.setTfValue("");
		pSalary.setValue(1500000);
		pDepartment.setSelected(0);
		pSex.setSelectedItem(0);
		pJoindate.setTfValue("");
		pTitle.setSelected(0);
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

	public TextFiledPanel getpJoindate() {
		return pJoindate;
	}
	
	
}
