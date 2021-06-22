package Trabalho_APS2;

import org.junit.AfterClass;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

/**
*
* @author Douglas.Silva
*/

public class APS_Selenium {
	static WebDriver driver = null;

	@SuppressWarnings("unused")
	private static String namePaginaPrincipal;

	public APS_Selenium() {
	}

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("C:\\trabalho2-1.html");

		namePaginaPrincipal = driver.getWindowHandle();
	}


	@Test
	public void testTituloPagina() {
		driver.get("C:\\trabalho2-1.html");
		String tituloExperado = "Trabalho 2-1";
		
		Assert.assertEquals(tituloExperado, driver.getTitle());
	}

	@Test
	public void testeFormCompleto() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Pessoa");
		campoEndereco.sendKeys("Gravatai");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("29");
		submit.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Cadastro realizado com sucesso"));
        alert.accept();
		
	}

	@Test
	public void testeNome_em_branco() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("");
		campoEndereco.sendKeys("Gravatai");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("29");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo nome"));
		
	}
	
	@Test
	public void testeEndereco_em_branco() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Pessoa");
		campoEndereco.sendKeys("");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("29");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo endereco"));
		
	}
	
	@Test
	public void testeTipoSexo_Not_selected() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Pessoa");
		campoEndereco.sendKeys("Gravatai");
		selectObjectSexo.selectByValue("...");
		campoIdade.sendKeys("29");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Selecione um valor para o campo sexo"));
		
	}
	
	@Test
	public void testeIdade_Invalida() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Pessoa");
		campoEndereco.sendKeys("Gravatai");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo idade, somente com numeros"));
		
	}
	
	@Test
	public void testeIdade_Negativa() {
		driver.get("C:\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Pessoa");
		campoEndereco.sendKeys("Gravatai");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("-29");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo idade com valores acima de 0"));
		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
