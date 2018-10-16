package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	// Definição do local onde o chromedriver se encontra
	// public String driverPath = "dependences/chromedriver";
	public String driverPath = "dependences/chromedriver.exe";

	// Verificar o uso do BeforeClass
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		// Crio o Chrome driver. Todos as classes de teste e page usam esse driver.
		driver = new ChromeDriver();

		// Crio o wait. Todos as classes de teste e page usam esse wait.
		wait = new WebDriverWait(driver, 300);

		// Maximiza a janela
		driver.manage().window().maximize();
	}

	// Verificar o uso do AfterClass
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
