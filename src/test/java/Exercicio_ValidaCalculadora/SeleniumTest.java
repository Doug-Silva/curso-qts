package Exercicio_ValidaCalculadora;

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
         

        driver.get("C:\\exercicio1.html");
    
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPagina(){
      // TODO alterar para seu caminho da sua maquina
    	driver.get("C:\\exercicio1.html");
      String tituloExperado ="Calculadora"; 
        
      Assert.assertEquals(tituloExperado,driver.getTitle());
    }
    
     @Test
    public void testSoma(){
         // TODO alterar para seu caminho da sua maquina
    	 driver.get("C:\\exercicio1.html");
        
         WebElement valorA = driver.findElement(By.id("a"));
         WebElement valorB = driver.findElement(By.id("b"));
         WebElement somar = driver.findElement(By.id("botao_somar"));
         valorA.sendKeys("20");
         valorB.sendKeys("5");
         somar.click();
         String codigProximaPagina =  driver.getPageSource();
         Assert.assertTrue(codigProximaPagina.contains("25"));
    }
    
     @Test
     public void testMutiplicacao(){
          // TODO alterar para seu caminho da sua maquina
     	 driver.get("C:\\exercicio1.html");
         
         WebElement valorA = driver.findElement(By.id("a"));
          WebElement valorB = driver.findElement(By.id("b"));
          WebElement multiplicar = driver.findElement(By.id("botao_multiplicar"));
          valorA.sendKeys("3");
          valorB.sendKeys("20");
          multiplicar.click();
          String codigProximaPagina =  driver.getPageSource();
          Assert.assertTrue(codigProximaPagina.contains("60"));
     }
     
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    
}