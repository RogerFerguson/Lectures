package week2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LockTest {

	@Test
	public void defaultLockTest() {
		Lock l = new Lock();
		l.enterCode("123");
		Assert.assertTrue(l.isUnlock());
	}
	
	@Test
	public void defaultLockTestWrongCode() {
		Lock l = new Lock();
		l.enterCode("124");
		Assert.assertFalse(l.isUnlock());
	}
	
	@Test
	public void MasterCodeTestWrongCode() {
		Lock l = new Lock();
		
		Lock.setMasterCode("888");
		l.enterCode("999");
		Assert.assertFalse(l.isUnlock());		
	}
	
	@Test
	public void MasterCodeTest() {
		Lock l = new Lock();
		
		Lock.setMasterCode("888");
		l.enterCode("888");
		Assert.assertTrue(l.isUnlock());		
	}
	
	@Test
	public void ConstructorTwoParaTest() {
		Lock l = new Lock("123", "888");
		
		Lock.setMasterCode("888");
		l.enterCode("888");
		Assert.assertTrue(l.isUnlock());	
		
		l.enterCode("123");
		Assert.assertTrue(l.isUnlock());
	}
	

}
