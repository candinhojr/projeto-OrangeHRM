import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Aluno: Candinho Luiz Dalla Brida Junior
 * Documentação utilizada: 
 * https://www.seleniumhq.org/docs/03_webdriver.jsp
 * https://docs.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern
 */

public class LoginWithoutPageObjectTest{

	// Definição do local onde o chromedriver se encontra
	private String driverPath = "/home/candinho/Documentos/2018-2/Teste de Software/chromedriver";
	// Declaração de variáveis
	private WebDriver driver;
	 
    @Before
    public void before() {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();    
	}
 
    @Test
    public void loginComSucesso() {
      // Acessa a página inicial que nos redireciona para a página de login
      driver.get("https://app.crowdtest.me/app/login");
 
      // Informa o usuário/senha e clica no botão de login
      driver.findElement(By.name("login")).sendKeys("user_name");
      driver.findElement(By.name("password")).sendKeys("user_password");
      driver.findElement(By.name("commit")).click();
 
      // Se a página inicial foi acessada: o titulo da página contém a palavra 'Projetos'
      String strPageTitle = driver.getTitle();
      assertTrue(strPageTitle.contains("Projetos"));
      
      // e na barra de navegação existe a opção 'Projetos'
      String headerProjetosOption = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[5]/a/span")).getText();
      assertEquals("Projetos", headerProjetosOption);
    }
 
    @After
    public void after() {
      driver.quit();
    }
}
