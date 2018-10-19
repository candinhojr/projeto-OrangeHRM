package tests.login;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import pages.home.*;
import pages.login.*;
import tests.BaseTest;
import utils.OthersTests;
import utils.Success;

public class LoginTest extends BaseTest {

	private HomePage home;
	private LoginPage loginPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.home = PageFactory.initElements(driver, HomePage.class);
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);

		this.home.goToLoginPage();
	}

	@After
	public void after() throws Exception {
		// driver.quit();
	}

	@Category(OthersTests.class)
	@Test
	public void invalidTest_InvalidUserNameInvalidPassword() throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("username", "11223344");

		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Invalid credentials");
	}

	@Category(OthersTests.class)
	@Test
	public void invalidTest_EmptyUserName() throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("", "11223344");

		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Username cannot be empty");
	}

	@Category(OthersTests.class)
	@Test
	public void invalidTest_EmptyPassword() throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("username", "");

		// Asserts
		Thread.sleep(500);
		this.loginPage.verifyLogin("Password cannot be empty");
	}

	@Category(Success.class)
	@Test
	public void validTest_ValidUserNameValidPassword() throws InterruptedException {
		// Métodos do page
		this.loginPage.loginToOrangeHRM("Admin", "admin123");

		// Asserts
		Thread.sleep(500);
		assertTrue(loginPage.loginWithSucess());

		this.home.logOut();
	}

}
