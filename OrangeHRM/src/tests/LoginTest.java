package tests;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	private HomePage homePage;
	private LoginPage loginPage;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();

	    this.homePage = new HomePage(driver, wait);
	    this.loginPage = new LoginPage(driver, wait);
	    
	    this.homePage.goToOrangePageLogin();
	}

	@After
	public void after() throws Exception {
		driver.quit();
	}
	
	@Test
    public void invalidTest_InvalidUserNameInvalidPassword () throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("username", "11223344");
		
		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Invalid credentials");
	}
	
	@Test
    public void invalidTest_EmptyUserName () throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("", "11223344");
		
		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Username cannot be empty");
	}
	
	@Test
    public void invalidTest_EmptyPassword () throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("username", "");
		
		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Password cannot be empty");
	}
	
	@Test
	public void validTest_ValidUserNameValidPassword () throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("Admin", "admin123");
				
		// Asserts
		Thread.sleep(500);
		assertTrue(loginPage.loginWithSucess());
	}

}
