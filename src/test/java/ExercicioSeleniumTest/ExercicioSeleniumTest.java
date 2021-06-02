package ExercicioSeleniumTest;

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
public class ExercicioSeleniumTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public ExercicioSeleniumTest() {
    }
    
    @BeforeClass
    public static void setUp() {
         System.setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win32\\chromedriver.exe");
         
         driver = new ChromeDriver();
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPagina(){

    	driver.get("C:\\exercicio_aula1.html");
      String tituloExperado ="Exercicio"; 
        
      Assert.assertEquals(tituloExperado,driver.getTitle());
      System.out.println(driver.getTitle());
    }
    
    @Test
    public void testValidaTextoPagina() {
    	driver.get("C:\\exercicio_aula1.html");
    	String codigProximaPagina =  driver.getPageSource();
    	String paginaExperada = "Este e um exercicio de Selenium";
    	Assert.assertTrue(codigProximaPagina.contains(paginaExperada));
    }
    
    @Test
    public void testConteudoBotao() {
    	driver.get("C:\\exercicio_aula1.html");
    	WebElement botao = driver.findElement(By.id("botao"));
    	String conteudoExperado = "botao teste";
    	Assert.assertEquals(conteudoExperado,botao.getAttribute("value"));
    	
    }
    
    
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    
}