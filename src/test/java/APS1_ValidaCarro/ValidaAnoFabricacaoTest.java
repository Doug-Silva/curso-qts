package APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaAnoFabricacaoTest {

	@Test
	public void testAnoFabricacao() {
		ValidaCarro ano = new ValidaCarro();
		int entrada = 1982;
		boolean resultadoExperado = true;
		boolean resutaldoPrograma = ano.validaAnoFabricacao(entrada);
		Assert.assertEquals(resultadoExperado, resutaldoPrograma);
	}
}
