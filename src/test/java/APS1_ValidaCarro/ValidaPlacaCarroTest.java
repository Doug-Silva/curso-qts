package APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaPlacaCarroTest {

	@Test
	public void testPlacaVerdadeiro() {
		ValidaCarro placa = new ValidaCarro();
		String entrada = "IEV-7889";
		boolean saidaExperada = true;
		boolean resultado = placa.validaPlacaCarro(entrada);
		Assert.assertEquals(saidaExperada, resultado);
	}
	
	@Test
	public void testPlacafalse() {
		ValidaCarro placa = new ValidaCarro();
		String entrada = "IEV-7889999";
		boolean saidaExperada = false;
		boolean resultado = placa.validaPlacaCarro(entrada);
		Assert.assertEquals(saidaExperada, resultado);
	}

}
