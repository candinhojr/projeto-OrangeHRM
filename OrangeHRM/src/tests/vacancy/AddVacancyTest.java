package tests.vacancy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import domain.Vacancy;
import pages.vacancy.*;
import tests.BaseTest;
import utils.OthersTests;
import utils.Success;

public class AddVacancyTest extends BaseTest {

	private AddVacancyPage addVacancyPage;
	private JobVacanciesListPage jobVacanciesListPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		// Instanciação dos pages
		this.addVacancyPage = PageFactory.initElements(driver, AddVacancyPage.class);
		this.jobVacanciesListPage = PageFactory.initElements(driver, JobVacanciesListPage.class);
				
		// Metodos do page
		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewJobVacancy().goToAddJobVacanciePage();

	}
	@After
	public void tearDown() throws Exception {
		super.tearDown();

		this.home.logOut();
	}
	
	@Category({Success.class})
	@Test
	public void successTest_CreateVacancyWithAllFieldsCompleted() throws InterruptedException {
		this.addVacancyPage.createVacancy(new Vacancy());
		this.addVacancyPage.clickSave();
		
		this.addVacancyPage.isSuccessMessagePresent();
	}
	
	@Category({OthersTests.class})
	@Test
	public void validTest_CreateVacancyWithOnlyRequiredFieldsCompleted() throws InterruptedException {
		this.addVacancyPage.selectJobTitle("IT Manager");
		this.addVacancyPage.fillVacancyName("IT Manager Vacancy");
		this.addVacancyPage.fillHiringManager("Russel Hamilton");
		this.addVacancyPage.clickSave();
		
		this.addVacancyPage.isSuccessMessagePresent();
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_EmplyRequiredFields() throws InterruptedException {
		this.addVacancyPage.clickSave();

		this.addVacancyPage.requiredFields();
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_InvalidHiringManager() throws InterruptedException {
		this.addVacancyPage.selectJobTitle("CEO");
		this.addVacancyPage.fillVacancyName("CEO Vacancy");
		this.addVacancyPage.fillHiringManager("Nobody");
		this.addVacancyPage.clickSave();
		
		this.addVacancyPage.hiringManagerRequired();
	}
	
	@Category({OthersTests.class})
	@Test
	public void invalidTest_InvalidNoOfPositions() throws InterruptedException {
		this.addVacancyPage.selectJobTitle("CEO");
		this.addVacancyPage.fillVacancyName("CEO Vacancy");
		this.addVacancyPage.fillHiringManager("Robert Craig");
		this.addVacancyPage.fillNoPositions("Ae");
		this.addVacancyPage.clickSave();
		
		this.addVacancyPage.noOfPositionsInvalid();
	}

	@Category({OthersTests.class})
	@Test
	public void invalidTest_VacancyNameAlreadyExists() throws InterruptedException {
		this.addVacancyPage.selectJobTitle("Sales Executive");
		this.addVacancyPage.fillVacancyName("Sales Executive Vacancy");
		this.addVacancyPage.fillHiringManager("Robert Craig");
		this.addVacancyPage.clickSave();
		this.addVacancyPage.clickBack();
		this.jobVacanciesListPage.goToAddJobVacanciePage();
		this.addVacancyPage.selectJobTitle("CEO");
		this.addVacancyPage.fillVacancyName("Sales Executive Vacancy");
		this.addVacancyPage.fillHiringManager("Steven Edwards");
		this.addVacancyPage.clickSave();
		
		this.addVacancyPage.vacancyNameAlreadyExists();
	}
}
