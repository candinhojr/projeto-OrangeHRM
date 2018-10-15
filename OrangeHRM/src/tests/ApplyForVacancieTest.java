package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.ActiveJobVacanciesPage;
import pages.HomePage;

public class ApplyForVacancieTest extends BaseTest {

	private HomePage homePage;
	private ActiveJobVacanciesPage jobVacanciesPage;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();

	    this.homePage = new HomePage(driver, wait);
	    this.jobVacanciesPage = new ActiveJobVacanciesPage(driver, wait);
	    
//	    this.homePage.goToOrangePageLogin();
//	    this.loginPage.loginToOrangeHRM("Admin", "admin123");
	    
	    this.homePage.goToActiveJobVacancies();
	}

	@After
	public void after() throws Exception {
		driver.quit();
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
		
//		this.jobVacanciesPage.requiredFields();
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
	public void invalidTest_NoActiveJobVacancies() throws InterruptedException {
		assertTrue(this.jobVacanciesPage.checkForVacancies());
	}

}
