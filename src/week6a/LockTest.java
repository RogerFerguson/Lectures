package week6a;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LockTest {

	@Test (expected = IllegalArgumentException.class)
	public void constructorError () {
		Lock l = new Lock("abc");
	}
	
	@Test
	public void equalTesting () {
		Lock l1 = new Lock("345");
		Lock l2 = new Lock("345");
		Assert.assertEquals(l1, l2);
	}
	
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
