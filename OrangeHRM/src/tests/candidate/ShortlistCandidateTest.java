package tests.candidate;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import domain.Candidate;
import domain.Vacancy;
import pages.candidate.*;
import tests.BaseTest;
import utils.OthersTests;
import utils.Success;

public class ShortlistCandidateTest extends BaseTest {

	private AddCandidatePage addCandidatePage;
	private ShortlistCandidatePage shortlistCandidatePage;
	private ViewActionHistoryPage viewActionHistoryPage;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		this.addCandidatePage = PageFactory.initElements(driver, AddCandidatePage.class);
		
		this.shortlistCandidatePage = PageFactory.initElements(driver, ShortlistCandidatePage.class);
		
		this.viewActionHistoryPage = PageFactory.initElements(driver, ViewActionHistoryPage.class);

		this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewCandidates().goToCandidatePage();
	}

	@After
	public void tearDown() throws Exception {
		this.viewActionHistoryPage.clickBack();
		this.home.logOut();
	}
	
	/**
	 * Shortlist the candidate, and check the candidate's data
	 * @throws NoSuchElementException
	 */
	@Category({Success.class})
	@Test
	public void shortlistCandidate() throws NoSuchElementException {	
		/**
		 * Check initial status message
		 */
		this.checkInitiatedStatusMessage();
		
		/**
		 * Select the 'shortlist' action in the candidate's actions, and check the candidate's and vacancy data
		 */
		this.actionShortlistCandidate();
		
		/**
		 * Confirm the 'shortlist' action in the candidate's actions, and check the candidate's and vacancy data
		 */
		this.confirmTheShortlistAction();
	}
	
	/**
	 * Check initial status message
	 * @throws NoSuchElementException
	 */
	@Category({OthersTests.class})
	@Test
	public void checkInitiatedStatusMessage() throws NoSuchElementException {
		/**
		 * Check initial status message
		 */
		assertTrue(this.addCandidatePage.checkStatusMessage(new Candidate().getCandidateInitiatedStatus()));
	}
	
	/**
	 * Select the 'shortlist' action in the candidate's actions, and check the candidate's and vacancy data
	 * @throws NoSuchElementException
	 */
	@Category({OthersTests.class})
	@Test
	public void actionShortlistCandidate() throws NoSuchElementException {
		this.addCandidatePage.clickActionShortlist();
		
		/**
		 * Check the candidate's and vacancy data:
		 * Candidate Name, Vacancy Name, HiringManager
		 */
		assertTrue(this.shortlistCandidatePage.checkCandidateName(new Candidate().getCandidateFullName()));
		assertTrue(this.shortlistCandidatePage.checkVacancyName(new Vacancy().getVacancyName()));
		assertTrue(this.shortlistCandidatePage.checkHiringManager(new Vacancy().getHiringManager()));
		/**
		 * Check the current status of process
		 */
		assertTrue(this.shortlistCandidatePage.checkCurrentStatus(new Candidate().getCandidateInitiatedStatus()));
	}
	
	/**
	 * Confirm the 'shortlist' action in the candidate's actions, and check the candidate's and vacancy data
	 * @throws NoSuchElementException
	 */
	@Test
	public void confirmTheShortlistAction() throws NoSuchElementException {
		/**
		 * Confirm the action of 'shortlist' candidate, and check the candidate's and vacancy data
		 */
		this.shortlistCandidatePage.clickShortlist();
		/**
		 * Checks whether the success message is displayed
		 */
		assertTrue(this.viewActionHistoryPage.isSuccessMessagePresent());
		/**
		 * Check the candidate's and vacancy data:
		 * Candidate Name, Vacancy Name, HiringManager
		 */
		assertTrue(this.viewActionHistoryPage.checkCandidateName(new Candidate().getCandidateFullName()));
		assertTrue(this.viewActionHistoryPage.checkVacancyName(new Vacancy().getVacancyName()));
		assertTrue(this.viewActionHistoryPage.checkHiringManager(new Vacancy().getHiringManager()));
		/**
		 * Check the current status of process
		 */
		assertTrue(this.viewActionHistoryPage.checkCurrentStatus(new Candidate().getCandidateShortlistedStatus()));
		/**
		 * Check the performed action of process
		 */
		assertTrue(this.viewActionHistoryPage.checkPerformedAction(new Candidate().getCandidateShortlist()));
	}
	
	// TODO: Rejeitar inscrição do candidato; 

}
