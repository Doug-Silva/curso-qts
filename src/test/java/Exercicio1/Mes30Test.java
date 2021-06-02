package Exercicio1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Mes30Test {

	@Test
	public void testresultado() {
		
		Mes30 objcalc = new Mes30();
		boolean entrada1 = false;
		boolean valid;
		int mes = 31;
		valid = objcalc.validaMes30(mes);
		Assert.assertEquals(entrada1, valid);
		
	}

}
