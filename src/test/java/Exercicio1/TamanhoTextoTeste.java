package Exercicio1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TamanhoTextoTeste {

	@Test
	public void testTamanhoTexto() {
		
		TamanhoTexto objcalc = new TamanhoTexto();
		String texto = "Douglas_Da_Silveira_Silva";
		int num = 25;
		int saida = objcalc.retornaTamanhoTexto(texto);
		Assert.assertEquals(saida, num);
		
	}

}
