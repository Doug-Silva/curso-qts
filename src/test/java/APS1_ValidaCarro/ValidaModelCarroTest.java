package APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaModelCarroTest {

	@Test
	public void testModelos_Validos() {
		ValidaCarro modelo = new ValidaCarro();
		String entrada = "celta";
		boolean saidaExperada = true;
		boolean resultado = modelo.validaModelCarro(entrada);
		Assert.assertEquals(saidaExperada, resultado);
	}
	
	@Test
	public void testModelos_Invalidos() {
		ValidaCarro modelo = new ValidaCarro();
		String entrada = "chevrolet_montana_suv";
		boolean saidaExperada = false;
		boolean resultado = modelo.validaModelCarro(entrada);
		Assert.assertEquals(saidaExperada, resultado);
	}
}
