package task1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() {
		
		UserDao us = new UserDaoImpl();
		
		assertEquals(1,us.insert());
	    //fail("Not yet implemented");
	}

}
