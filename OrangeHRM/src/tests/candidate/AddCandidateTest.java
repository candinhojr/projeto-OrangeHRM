package tests.candidate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.candidate.*;
import pages.home.*;
import pages.login.*;
import pages.mainMenu.*;
import tests.BaseTest;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddCandidateTest extends BaseTest {

	private AddCandidatePage addCandidatePage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);
	}
	
	@Test
	public void FullRun() throws InterruptedException {
		AddCandidatePage addCandPage = PageFactory.initElements(driver, AddCandidatePage.class);
		
		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToAddCandidatePage();
		
		addCandPage.fillFullName("First", "Middle", "Last");
		addCandPage.fillEmail("teste@mail.com");
		
		Thread.sleep(2000);
	}

}
