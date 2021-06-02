package APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaPrecoFabricacaoTest {

	@Test
	public void testPrecoFabricacao() {
		ValidaCarro valor = new ValidaCarro();
		float entrada = 5.09f;
		boolean resultadoExperado = true;
		boolean resutaldoPrograma = valor.validaPrecoFabricacao(entrada);
		Assert.assertEquals(resultadoExperado, resutaldoPrograma);
	}

}
