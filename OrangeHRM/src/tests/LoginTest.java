package tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {

		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		
		// Métodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("username", "11223344");
		
		// Asserts
		Thread.sleep(500);
		loginPage.verifyLogin("Invalid credentials");
	}
	
	@Test
    public void invalidLoginTest_EmptyUserName () throws InterruptedException {

		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		
		// Métodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("", "11223344");
		
		// Asserts
		Thread.sleep(500);
		loginPage.verifyLogin("Username cannot be empty");
	}
	
	@Test
    public void invalidLoginTest_EmptyPassword () throws InterruptedException {

		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		
		// Métodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("username", "");
		
		// Asserts
		Thread.sleep(500);
		loginPage.verifyLogin("Password cannot be empty");
	}
	
	@Test
	public void validLoginTest_ValidUserNameValidPassword () throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
				
		// Métodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("Admin", "admin123");
				
		// Asserts
		Thread.sleep(500);
		assertTrue(loginPage.loginWithSucess());
	}

}
