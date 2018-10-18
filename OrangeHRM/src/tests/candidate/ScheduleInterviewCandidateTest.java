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

public class ScheduleInterviewCandidateTest extends BaseTest {

	private AddCandidatePage addCandidatePage;
	private ScheduleInterviewCandidatePage scheduleInterviewCandidatePage;

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
		addCandidatePage.clickActionScheduleInterview();
		scheduleInterviewCandidatePage.fillInterviewTitle("Entrevista");
		scheduleInterviewCandidatePage.fillInterviewerName("Linda Anderson");
		scheduleInterviewCandidatePage.fillInterviewDate("2018-10-31");
		scheduleInterviewCandidatePage.clickSave();
		assertTrue(this.scheduleInterviewCandidatePage.isSuccessMessagePresent());
		scheduleInterviewCandidatePage.clickBack();
	}

}
