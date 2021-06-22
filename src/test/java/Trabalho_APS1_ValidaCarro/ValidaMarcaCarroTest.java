package Trabalho_APS1_ValidaCarro;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_APS1_ValidaCarro.ValidaCarro;
import junit.framework.Assert;

public class ValidaMarcaCarroTest {

	@Test
	public void TesteGMTrue() {
		ValidaCarro objExerc = new ValidaCarro();		
		String entradaUser = "VW";
			boolean resultadoesperado = true;
			boolean resultadoPrograma = objExerc.validaMarcaCarro(entradaUser);
			Assert.assertEquals(resultadoesperado, resultadoPrograma);
		}
	@Test
	public void TesteVWtrue() {
		ValidaCarro objExerc = new ValidaCarro();		
		String entradaUser = "GM";
			boolean resultadoesperado = true;
			boolean resultadoPrograma = objExerc.validaMarcaCarro(entradaUser);
			Assert.assertEquals(resultadoesperado, resultadoPrograma);
		}

	@Test
	public void TesteFalse_Hyundai() {
		ValidaCarro objExerc = new ValidaCarro();		
		String entradaUser = "Hyundai";
			boolean resultadoesperado = false;
			boolean resultadoPrograma = objExerc.validaMarcaCarro(entradaUser);
			Assert.assertEquals(resultadoesperado, resultadoPrograma);
		}
}
