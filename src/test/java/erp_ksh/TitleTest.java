package erp_ksh;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.TitleService;

public class TitleTest {
	private static TitleService titleService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		titleService = TitleService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		titleService = null;
	}

	/*@Test
	public void testInsertTitle() {
		Title title = new Title();
		title.setTcode(1);
		title.setTname("사장");
		int res = TitleService.getInstance().insertTitle(title);
		Assert.assertEquals(1, 0);
	}*/

}
