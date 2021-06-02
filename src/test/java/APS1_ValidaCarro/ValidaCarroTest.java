package APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaCarroTest {

	@Test
	public void testIdValoresValidos() {
		ValidaCarro valida = new ValidaCarro();
		int entrada = 1;
		boolean resultadoExperado = true;
		boolean resutaldoPrograma = valida.validaIdCarro(entrada);
		Assert.assertEquals(resultadoExperado, resutaldoPrograma);
	}
	
	@Test
	public void testIdValoresInValidos() {
		ValidaCarro valida = new ValidaCarro();
		int entrada = 0;
		boolean resultadoExperado = false;
		boolean resutaldoPrograma = valida.validaIdCarro(entrada);
		Assert.assertEquals(resultadoExperado, resutaldoPrograma);
	}

}
