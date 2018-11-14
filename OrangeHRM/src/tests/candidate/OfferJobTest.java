package tests.candidate;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import pages.candidate.AddCandidatePage;
import pages.candidate.OfferJobPage;
import pages.candidate.ViewActionHistoryPage;
import tests.BaseTest;
import utils.Success;

public class OfferJobTest extends BaseTest{
	
	private AddCandidatePage addCandidatePage;
	private OfferJobPage offerJobPage;
	private ViewActionHistoryPage viewActionHistoryPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);
		
		this.offerJobPage = PageFactory.initElements(driver, OfferJobPage.class);
		
		this.viewActionHistoryPage = PageFactory.initElements(driver, ViewActionHistoryPage.class);
		
		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToCandidatePage();	
	}

	@After
	public void tearDown() throws Exception {
		this.home.logOut();
	}

	@Category({Success.class})
	@Test
	public void offerJob() throws NoSuchElementException {
		addCandidatePage.clickActionOfferJob();
		offerJobPage.clickOfferJob();
		assertTrue(this.viewActionHistoryPage.isSuccessMessagePresent());
		viewActionHistoryPage.clickBack();
	}

}
