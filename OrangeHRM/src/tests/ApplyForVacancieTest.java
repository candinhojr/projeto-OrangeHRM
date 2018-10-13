package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pages.ActiveJobVacanciesPage;
import pages.HomePage;

public class ApplyForVacancieTest extends BaseTest {

	@Test
	public void goToApplyForVacancie() throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		ActiveJobVacanciesPage jobVacanciesPage = new ActiveJobVacanciesPage(driver, wait);

		// Métodos do page
		homePage.goToActiveJobVacancies();
		jobVacanciesPage.goToJobVacanciePage();
		jobVacanciesPage.fillFullName("", "Luiz Dalla Brida", "Junior");
		jobVacanciesPage.fillEmail("candinholuiz@gmail.com");
		jobVacanciesPage.fillContactNo("(48) 9 9657-9797");
		jobVacanciesPage.addResume("/home/candinho/Downloads/instrucoes.pdf");
		jobVacanciesPage.fillKeyWords("palavras de, teste");
		jobVacanciesPage.fillNotes("Vai dar boa negão");
		jobVacanciesPage.clickSubmit();
		
		jobVacanciesPage.firstNameRequired();
	}

}
