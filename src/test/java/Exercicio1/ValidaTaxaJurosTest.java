package Exercicio1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaTaxaJurosTest {

	@Test
	public void valida() {
		
		ValidaTaxaJuros objcalc = new ValidaTaxaJuros();
		boolean entrada1 = true;
		boolean valid;
		int taxa = 9;
		valid = objcalc.validataxa(taxa);
		Assert.assertEquals(entrada1, valid);
			
	}

}
