import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Aluno: Candinho Luiz Dalla Brida Junior
 * Documentação utilizada: 
 * https://www.seleniumhq.org/docs/03_webdriver.jsp
 * https://docs.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern
 */

public class LoginWithPageObjectTest {

	// Definição do local onde o chromedriver se encontra
	private String driverPath = "/home/candinho/Documentos/2018-2/Teste de Software/chromedriver";
	// Declaração de variáveis
	private WebDriver driver;
	 
    @Before
    public void before() {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();    
	}
    
    // O teste apenas se preocupa com definir o teste e verificar o resultado do mesmo.
    @Test
    public void loginComSucesso() {
      LoginPage loginPage = new LoginPage(driver);
      loginPage.
      			visit("https://app.crowdtest.me/app/login").
                login("user_name","user_password");
    
      assertTrue(loginPage.loginWithSucess());
    }
    
    @After
    public void after() {
      driver.quit();
    }

}
