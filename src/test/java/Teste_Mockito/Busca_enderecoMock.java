package Teste_Mockito;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.Assert;
import main.CorreioService;

public class Busca_enderecoMock {
	
	@Test
	public void testCorreioMock() {
		
		CorreioService correioServiceMock = Mockito.mock(CorreioService.class);
		when(correioServiceMock.buscaEndereco("9000000")).thenReturn("Porto Alegre");
		Assert.assertEquals("Porto Alegre", correioServiceMock.buscaEndereco("9000000"));
	}

}