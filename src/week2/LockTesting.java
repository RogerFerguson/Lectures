package week2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LockTesting {

	@Test
	public void testBadCode() {
		Lock d = new Lock("246");

		d.reset();
		d.enterCode("125");
		
		Assert.assertFalse(d.isUnlock());
	}
	
	@Test
	public void testCorrectCode() {
		Lock d = new Lock("246");

		d.reset();
		d.enterCode("246");
		
		Assert.assertTrue(d.isUnlock());
	}

	@Ignore @Test
	public void TestMasterPassword() {
		Lock d = new Lock("246");
		Lock.setMasterCode("987");

		d.reset();
		d.enterCode("987");
		
		Assert.assertTrue(d.isUnlock());
		
		d.reset();
		d.enterCode("234");
		Assert.assertFalse(d.isUnlock());

	}
	
	
	
}
