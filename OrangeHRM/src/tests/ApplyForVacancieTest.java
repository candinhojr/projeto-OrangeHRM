package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.ActiveJobVacanciesPage;
import pages.HomePage;
import pages.ListUsersPage;
import pages.LoginPage;
import pages.MainMenuPage;

public class ApplyForVacancieTest extends BaseTest {

	private HomePage homePage;
	private LoginPage loginPage;
	private MainMenuPage mainMenuPage;
	private ListUsersPage listUsersPage;
	private ActiveJobVacanciesPage jobVacanciesPage;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();

	    this.homePage = new HomePage(driver, wait);
	    this.loginPage = new LoginPage(driver, wait);
	    this.mainMenuPage = new MainMenuPage(driver, wait);
	    this.listUsersPage = new ListUsersPage(driver, wait);
	    jobVacanciesPage = new ActiveJobVacanciesPage(driver, wait);
	    
	    this.homePage.goToOrangePageLogin();
	    this.loginPage.loginToOrangeHRM("Admin", "admin123");
	    this.mainMenuPage.goToViewSystemUsers();
	    this.listUsersPage.goToAddUserPage();
	}

	@After
	public void after() throws Exception {
		driver.quit();
	}
	  
	@Test
	public void goToApplyForVacancie() throws InterruptedException {
		// Instanciação dos pages
		HomePage homePage = new HomePage(driver,wait);
		ActiveJobVacanciesPage jobVacanciesPage = new ActiveJobVacanciesPage(driver, wait);

		// Métodos do page
		homePage.goToOrangePageLogin();
		homePage.goToActiveJobVacancies();
		jobVacanciesPage.goToJobVacanciePage();
		jobVacanciesPage.fillFullName("", "Luiz Dalla Brida", "Junior");
		jobVacanciesPage.fillEmail("candinholuiz@gmail.com");
		jobVacanciesPage.fillContactNo("(48) 9 9657-9797");
		jobVacanciesPage.addResume("/home/candinho/Downloads/instrucoes.pdf");
		jobVacanciesPage.fillKeyWords("palavras de, teste");
		jobVacanciesPage.fillNotes("Vai dar boa negão");
		jobVacanciesPage.clickSubmit();
		
		this.jobVacanciesPage.firstNameRequired();
	}

}
