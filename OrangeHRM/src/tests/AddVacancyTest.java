package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MainMenuPage;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddVacancyTest extends BaseTest {
	
	@Test
	public void FullRun() throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		MainMenuPage menu = new MainMenuPage(driver, wait);
		
		// Metodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("admin", "admin123");
		menu.goToViewJobVacancy();
		
		Thread.sleep(2000);
	}

}
