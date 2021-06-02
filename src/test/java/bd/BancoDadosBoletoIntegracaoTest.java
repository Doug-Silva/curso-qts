package bd;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import modelos.Boleto;


public class BancoDadosBoletoIntegracaoTest {

	static BancoDadosBoleto bancoDados = new BancoDadosBoleto();
	
	@Before
	public void executaAntesMetodo() {
		bancoDados.deletaTudo();
	}
	
	@AfterClass
	public static void limpaTudoDepoisAcabarTestes() {
		bancoDados.deletaTudo();
	}
	
	
	@Test
	public void testInsert() {
		Boleto f = new Boleto();
		f.valor = 150.98f;
		f.sacado = "Douglas";
		bancoDados.insertboleto(f);
		Boleto boletoSalvoBanco =  bancoDados.buscaboleto(f.id);
		Assert.assertNotNull(boletoSalvoBanco);
		
	}
	
	@Test
	public void testDelete() {
		Boleto f = new Boleto();
		f.valor = 2500.25f;
		f.sacado = "Aline";
		bancoDados.insertboleto(f);
		int idPessoa = f.id;
		bancoDados.deleteboleto(idPessoa);
		Boleto funcDoBanco = bancoDados.buscaboleto(idPessoa);
		Assert.assertNull(funcDoBanco);
		
	}
	
	@Test
	public void testSelect() {
		Boleto f = new Boleto();
		f.valor = 1200.02f;
		f.sacado = "Eduardo";
		bancoDados.insertboleto(f);
		int tamanhoLista = bancoDados.listboleto().size();
		Assert.assertTrue(tamanhoLista > 0);
		Assert.assertEquals(1, tamanhoLista);
	}
	
}