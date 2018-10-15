package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.ActiveCandidatesPage;
import pages.AddCandidatePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MainMenuPage;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddCandidateTest extends BaseTest {
	
	@Test
	public void FullRun() throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		MainMenuPage menu = new MainMenuPage(driver, wait);
		ActiveCandidatesPage candidatesPage = new ActiveCandidatesPage(driver, wait);
		AddCandidatePage addCandPage = new AddCandidatePage(driver, wait);
		
		// Metodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("admin", "admin123");
		menu.goToViewCandidates();
		candidatesPage.goToAddCandidatePage();
		
		addCandPage.fillFullName("First", "Middle", "Last");
		addCandPage.fillEmail("teste@mail.com");
		
		Thread.sleep(2000);
	}

}
