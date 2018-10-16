package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;

	public BaseTest() {
		this.driver = Driver.getInstance().getWebDriver();
		this.wait = Driver.getInstance().getWebDriverWait();
	}

	// Verificar o uso do BeforeClass
	@Before
	public void setUp() throws Exception {
		this.driver = Driver.getInstance().getWebDriver();
		this.wait = Driver.getInstance().getWebDriverWait();
	}

	// Verificar o uso do AfterClass
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
