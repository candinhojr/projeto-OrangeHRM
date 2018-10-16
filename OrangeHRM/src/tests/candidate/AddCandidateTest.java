package tests.candidate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.candidate.*;
import tests.BaseTest;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class AddCandidateTest extends BaseTest {

	private AddCandidatePage addCandidatePage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);

		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToAddCandidatePage();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();

		this.home.logOut();
	}
	
	@Test
	public void FullRun() throws InterruptedException {	
		addCandidatePage.fillFullName("First", "Middle", "Last");
		addCandidatePage.fillEmail("teste@mail.com");
	}

}
