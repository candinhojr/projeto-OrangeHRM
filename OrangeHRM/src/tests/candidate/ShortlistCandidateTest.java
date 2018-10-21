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
		super.tearDown();

		this.home.logOut();
	}
	
	@Category({Success.class})
	@Test
	public void shortlistCandidate() throws NoSuchElementException {	
		assertTrue(this.addCandidatePage.checkStatusMessage(new Candidate().getCandidateInitiatedStatus()));
		
		this.addCandidatePage.clickActionShortlist();
		
		assertTrue(this.shortlistCandidatePage.checkCandidateName(new Candidate().getCandidateFullName()));
		assertTrue(this.shortlistCandidatePage.checkVacancyName(new Vacancy().getVacancyName()));
		assertTrue(this.shortlistCandidatePage.checkHiringManager(new Vacancy().getHiringManager()));
		assertTrue(this.shortlistCandidatePage.checkCurrentStatus(new Candidate().getCandidateShortlistedStatus()));
		
		this.shortlistCandidatePage.clickShortlist();
		
		assertTrue(this.viewActionHistoryPage.isSuccessMessagePresent());
		assertTrue(this.viewActionHistoryPage.checkCandidateName(new Candidate().getCandidateFullName()));
		assertTrue(this.viewActionHistoryPage.checkVacancyName(new Vacancy().getVacancyName()));
		assertTrue(this.viewActionHistoryPage.checkHiringManager(new Vacancy().getHiringManager()));
		assertTrue(this.viewActionHistoryPage.checkCurrentStatus(new Candidate().getCandidateShortlistedStatus()));
		assertTrue(this.viewActionHistoryPage.checkPerformedAction(new Candidate().getCandidateShortlist()));
		
		this.viewActionHistoryPage.clickBack();
	}
	
	// TODO: Dividir testes
	// TODO: Checar dados da inscrição do candidato para a vaga;
	// TODO: Rejeitar inscrição do candidato; 
	
//	@Category({OthersTests.class})
//	@Test
//	public void verifyCandidateName() {
//		viewActionHistoryPage.checkCandidateName(new Candidate().getCandidateFullName());
//	}

}
