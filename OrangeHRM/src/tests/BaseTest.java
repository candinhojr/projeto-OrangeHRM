package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.home.HomePage;
import utils.Driver;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected HomePage home;

	public BaseTest() {
		this.driver = Driver.getInstance().getWebDriver();
		this.wait = Driver.getInstance().getWebDriverWait();

		this.home = PageFactory.initElements(driver, HomePage.class);
	}

	// Verificar o uso do BeforeClass
	@Before
	public void setUp() throws Exception {
		this.driver = Driver.getInstance().getWebDriver();
		this.wait = Driver.getInstance().getWebDriverWait();
	}

}
