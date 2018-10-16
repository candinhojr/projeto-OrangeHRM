package tests.vacancy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import pages.vacancy.*;
import tests.BaseTest;

public class ApplyForVacancieTest extends BaseTest {

	private ActiveJobVacanciesPage jobVacanciesPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.jobVacanciesPage = PageFactory.initElements(driver, ActiveJobVacanciesPage.class);

		// this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewJobVacancy();
		this.home.goToActiveJobVacancies();
	}

	@After
	public void after() throws Exception {
	}

	@Test
	public void validTest_ApplyForVacancie() throws InterruptedException {
		this.jobVacanciesPage.goToJobVacanciePage();
		this.jobVacanciesPage.fillFullName("Candinho", "Luiz Dalla Brida", "Junior");
		this.jobVacanciesPage.fillEmail("candinholuiz@gmail.com");
		this.jobVacanciesPage.fillContactNo("(48) 9 9657-9797");
		this.jobVacanciesPage.addResume("dependences/files/pdf_emply.pdf");
		this.jobVacanciesPage.fillKeyWords("palavras de, teste");
		this.jobVacanciesPage.fillNotes("Vai dar boa negão");
		this.jobVacanciesPage.clickSubmit();

		// this.jobVacanciesPage.requiredFields();
	}

	@Test
	public void invalidTest_EmplyRequiredFields() throws InterruptedException {
		this.jobVacanciesPage.goToJobVacanciePage();
		this.jobVacanciesPage.clickSubmit();

		this.jobVacanciesPage.requiredFields();
	}

	@Test
	public void invalidTest_InvalidEmail() throws InterruptedException {
		this.jobVacanciesPage.goToJobVacanciePage();
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/pdf_valido.pdf");
		this.jobVacanciesPage.clickSubmit();

		this.jobVacanciesPage.emailRequired();
	}

	@Test
	public void invalidTest_NoActiveJobVacancies() throws NoSuchElementException {
		assertTrue(this.jobVacanciesPage.checkForVacancies());
	}

}
