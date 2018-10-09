package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MainMenuPage;

public class VacanciesTest extends BaseTest {

	@Test
	public void goToVancacies () throws InterruptedException {	
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		MainMenuPage mainMenuPage = new MainMenuPage(driver, wait);
		
		// Métodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("Admin", "admin123");
		mainMenuPage.goToViewJobVacancy();
	}
	
	
}
