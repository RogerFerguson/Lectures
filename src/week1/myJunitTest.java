package week1;

import static org.junit.Assert.*;

import org.junit.Test;

public class myJunitTest {

	@Test
	public void testBadCode() {
		Lock d = new Lock("246");
		d.enterCode("125");
		assertFalse(d.isUnlock());
	}


	@Test
	public void testValidCode() {
		Lock d1 = new Lock("246");
		Lock d2 = new Lock("246");
		
		assertEquals(d1,d2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInValidCode() {
		Lock d = new Lock("");
	}
	

}
