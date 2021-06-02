package Exercicio_loginPagina;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Douglas_Silva
 */
public class SeleniumTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public SeleniumTest() {
    }
    
    @BeforeClass
    public static void setUp() {
         System.setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win32\\chromedriver.exe");
	        
        
         driver = new ChromeDriver();
         

        driver.get("C:\\login.html");
    
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPaginaLogin(){
      // TODO alterar para seu caminho da sua maquina
    	driver.get("C:\\login.html");
      String tituloExperado ="Pagina de Login"; 
        
      Assert.assertEquals(tituloExperado,driver.getTitle());
    }
    
     @Test
    public void testLogin(){
         // TODO alterar para seu caminho da sua maquina
    	 driver.get("C:\\login.html");
        
        WebElement campoNome = driver.findElement(By.id("nome"));
         WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("teste");
         campoSenha.sendKeys("123");
         submit.click();
         String codigProximaPagina =  driver.getPageSource();
         Assert.assertTrue(codigProximaPagina.contains("Bem vindo usuario teste"));
    }
    
    @Test
    public void testAlert(){
        // TODO alterar para seu caminho da sua maquina
    	driver.get("C:\\login.html");

        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("sdklsdklsdklsd");
         campoSenha.sendKeys("");
         submit.click();

         Alert alert = driver.switchTo().alert();
         Assert.assertTrue(alert.getText().equals("usuario ou senha invalida"));
         alert.accept();
         
        
        
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    
}