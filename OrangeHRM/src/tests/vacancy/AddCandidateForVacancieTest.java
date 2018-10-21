package tests.vacancy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import domain.Candidate;
import pages.vacancy.*;
import tests.BaseTest;
import utils.Success;
import utils.OthersTests;

public class AddCandidateForVacancieTest extends BaseTest {

	private ActiveJobVacanciesPage jobVacanciesPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.jobVacanciesPage = PageFactory.initElements(driver, ActiveJobVacanciesPage.class);

		this.home.goToActiveJobVacancies().goToJobVacanciePage();
	}

	@After
	public void after() throws Exception {
	}

	@Category({Success.class})
	@Test
	public void successTest_AddCandidateForVacancieWithAllFieldsCompleted() throws InterruptedException {
		this.jobVacanciesPage.createCandidate(new Candidate());
		this.jobVacanciesPage.clickSubmit();

		assertTrue(this.jobVacanciesPage.applyOk());
		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
		
	}

	@Category({OthersTests.class})
	@Test
	public void validTest_ApplyForVacancieWithOnlyRequiredFieldsCompleted() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Fevereiro", "", "Quaresma");
		this.jobVacanciesPage.fillEmail("teste@teste.com");
		this.jobVacanciesPage.addResume("dependences/files/pdf_valid.pdf");
		this.jobVacanciesPage.clickSubmit();
		
		assertTrue(this.jobVacanciesPage.applyOk());
		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_EmplyRequiredFields() throws InterruptedException {
		this.jobVacanciesPage.clickSubmit();

		this.jobVacanciesPage.requiredFields();
	}

	@Category({OthersTests.class})
	@Test
	public void invalidTest_InvalidEmail() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/pdf_valid.pdf");
		this.jobVacanciesPage.clickSubmit();

		this.jobVacanciesPage.emailIncorrect();
	}

	@Category({OthersTests.class})
	@Test
	public void invalidTest_CorrompedDocument() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/pdf_corrupted.pdf");
		this.jobVacanciesPage.clickSubmit();

		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_DocumentGreaterThan1M() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/pdf_2M.pdf");
		this.jobVacanciesPage.clickSubmit();

		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
	}
	
	@Category({OthersTests.class})
	@Test
	public void validTest_Document1M() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/pdf_1M.pdf");
		this.jobVacanciesPage.clickSubmit();

		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
	}
	
	@Category({OthersTests.class})
	@Test
	public void validTest_InvalidDocument() throws InterruptedException {
		this.jobVacanciesPage.fillFullName("Candinho", "", "Junior");
		this.jobVacanciesPage.fillEmail("teste");
		this.jobVacanciesPage.addResume("dependences/files/image.jpg");
		this.jobVacanciesPage.clickSubmit();

		assertTrue(this.jobVacanciesPage.isSuccessMessagePresent());
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_NoActiveJobVacancies() throws NoSuchElementException {
		assertTrue(this.jobVacanciesPage.checkForVacancies());
	}

}
