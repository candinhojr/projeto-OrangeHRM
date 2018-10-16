package tests.vacancy;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.vacancy.*;
import tests.BaseTest;
import pages.home.*;
import pages.login.*;
import pages.mainMenu.*;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddVacancyTest extends BaseTest {
	
	@Test
	public void CreateVacancyTest() throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		LoginPage loginPage = new LoginPage(driver, wait);
		MainMenuPage menu = new MainMenuPage(driver, wait);
		ActiveVacancyPage vacancyPage = new ActiveVacancyPage(driver, wait);
		AddVacancyPage addVacPage = new AddVacancyPage(driver, wait);
		
		// Metodos do page
		homePage.goToOrangePageLogin();
		loginPage.loginToOrangeHRM("admin", "admin123");
		menu.goToViewJobVacancy();
		vacancyPage.goToAddVacancyPage();
		
		addVacPage.selectJobTitle("IT Executive");
		addVacPage.fillVacancyName("Teste");
		addVacPage.fillHiringManager("Thomas Fleming");
		addVacPage.fillNoPositions("3");
		addVacPage.fillDescription("Testando criar vaga");
		
		Thread.sleep(2000);
		addVacPage.save();
	}

}
