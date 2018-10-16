package tests.vacancy;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.vacancy.*;
import tests.BaseTest;
import pages.home.*;
import pages.login.*;
import pages.mainMenu.*;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddVacancyTest extends BaseTest {

	private AddVacancyPage addVacancyPage;

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();

		this.home.logOut();
	}
	
	@Test
	public void CreateVacancyTest() throws InterruptedException {
		// Instanciação dos pages
		AddVacancyPage addVacancyPage = PageFactory.initElements(driver, AddVacancyPage.class);
		
		// Metodos do page
		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewJobVacancy().goToAddJobVacanciePage();
		
		addVacancyPage.selectJobTitle("IT Executive");
		addVacancyPage.fillVacancyName("Teste");
		addVacancyPage.fillHiringManager("Thomas Fleming");
		addVacancyPage.fillNoPositions("3");
		addVacancyPage.fillDescription("Testando criar vaga");
		
		Thread.sleep(2000);
		addVacancyPage.save();
	}

}
