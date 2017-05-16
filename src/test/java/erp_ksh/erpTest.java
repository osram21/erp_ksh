package erp_ksh;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.EmployeeService;

public class erpTest {
	private static EmployeeService empService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empService = new EmployeeService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empService = null;
	}

	/*@Test
	public void atestInsertEmp() {
		Department dept = new Department();
		dept.setDcode(2);
		Title title = new Title();
		title.setTcode(2);
		
		Employee emp = new Employee(017013,"하하",1500000,dept,true,new Date(),title);
		int res = EmployeeService.getInstance().insertEmp(emp);
		Assert.assertSame(1, res);
	}*/
	
	@Test
	public void bTestUpdateEmp() {
		Department dept = new Department();
		dept.setDcode(4);
		
		Title title = new Title();
		title.setTcode(4);
		Employee emp = new Employee(017013, "호호", 2555000, dept, false, new Date(), title);
		int res = EmployeeService.getInstance().updateEmp(emp);
		Assert.assertSame(1, res);
	}
	
	@Test
	public void cTestselectOneEmp() {
		Map<String, Object> param = new HashMap<>();
		param.put("Eno", 17012);
		Employee emp = EmployeeService.getInstance().selectEmpOne(param);
		Assert.assertNotNull(emp);
	}
	
	@Test
	public void dTestDeleteEmp() {
		Employee emp = new Employee();
		emp.setEno(17012);
		int res = EmployeeService.getInstance().deleteEmp(emp);
		Assert.assertSame(1, res);
	}
	
	@Test
	public void eTestSelectByAll() {
		List<Employee> list = EmployeeService.getInstance().selectEmp();
		Assert.assertNotNull(list);
	}

}
