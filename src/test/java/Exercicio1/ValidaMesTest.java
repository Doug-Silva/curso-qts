package Exercicio1;

import static org.junit.Assert.*;

import org.junit.Test;


import junit.framework.Assert;

public class ValidaMesTest {

	@Test
	public void testResultFalse() {
		
		
		ValidaMes objcalc = new ValidaMes();
		boolean entrada1 = false;
		boolean valid;
		int mes = 14;
		valid = objcalc.validaMes(mes);
		Assert.assertEquals(entrada1, valid);
		
	}
	
	@Test
	public void testResultTrue() {
		
		
		ValidaMes objcalc = new ValidaMes();
		boolean entrada1 = true;
		boolean valid;
		int mes = 6;
		valid = objcalc.validaMes(mes);
		Assert.assertEquals(entrada1, valid);

	}

}
