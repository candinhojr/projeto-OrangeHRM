package tests.candidate;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import pages.candidate.AddCandidatePage;
import pages.candidate.MarkInterviewPassedPage;
import pages.candidate.ViewActionHistoryPage;
import tests.BaseTest;
import utils.Success;

public class MarkInterviewPassedTest extends BaseTest{
	
	private AddCandidatePage addCandidatePage;
	private MarkInterviewPassedPage markInterviewPassedPage;
	private ViewActionHistoryPage viewActionHistoryPage;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);
		
		this.markInterviewPassedPage = PageFactory.initElements(driver, MarkInterviewPassedPage.class);
		
		this.viewActionHistoryPage = PageFactory.initElements(driver, ViewActionHistoryPage.class);
		
		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToCandidatePage();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();

		this.home.logOut();
	}
	
	@Category({Success.class})
	@Test
	public void markInterviewPassed() throws NoSuchElementException {	
		addCandidatePage.clickActionMarkInterviewPassed();
		markInterviewPassedPage.clickMarkInterviewPassed();
		assertTrue(this.viewActionHistoryPage.isSuccessMessagePresent());
		viewActionHistoryPage.clickBack();
	}
}
