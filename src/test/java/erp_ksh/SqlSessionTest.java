package erp_ksh;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.erp.util.MybatisSqlSessionFactory;

public class SqlSessionTest {
	private static SqlSessionFactory sqlSessionFactory;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSessionFactory = null;
	}

	@Test
	public void testSql() {
		Assert.assertNotNull(sqlSessionFactory.openSession());
	}

}
