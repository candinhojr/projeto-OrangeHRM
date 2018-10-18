package tests.candidate;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import pages.candidate.*;
import tests.BaseTest;
import utils.Success;

// TODO Temp pra testar metodos da AddCandidatePage, testa "caminho feliz"
public class ShortlistCandidateTest extends BaseTest {

	private AddCandidatePage addCandidatePage;
	private ShortlistCandidatePage shortlistCandidatePage;
	private ViewActionHistoryPage viewActionHistoryPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);

		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToCandidatePage();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();

		this.home.logOut();
	}
	
	@Category(Success.class)
	@Test
	public void shortlistCandidate() throws NoSuchElementException {	
		addCandidatePage.clickActionShortlist();
		shortlistCandidatePage.clickShortlist();
		assertTrue(this.viewActionHistoryPage.isSuccessMessagePresent());
		viewActionHistoryPage.clickBack();
	}

}
