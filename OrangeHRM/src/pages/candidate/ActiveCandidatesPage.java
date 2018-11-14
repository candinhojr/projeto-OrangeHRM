package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ActiveCandidatesPage extends BasePage {

	public ActiveCandidatesPage() {
		super();
	}

	public ActiveCandidatesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elements Web
	// Page with all candidates
	@FindBy(linkText="Teste Testiniano Testando")
	WebElement candidate;
	
	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	WebElement addCandidateButtonXpath;
	 
	// Page of the specific job
	@FindBy(id = "addCandidateHeading")
	WebElement vacancieTitleId;
	@FindBy(id = "addCandidate_firstName")
	WebElement firstNameInputId;
	@FindBy(id = "addCandidate_middleName")
	WebElement middleNameInputId;
	@FindBy(id = "addCandidate_lastName")
	WebElement lastNameInputId;
	@FindBy(id = "addCandidate_email")
	WebElement emailInputId;
	@FindBy(id = "addCandidate_contactNo")
	WebElement contactNoInputId;
	@FindBy(id = "addCandidate_resume")
	WebElement resumeInputFileId;
	@FindBy(id = "addCandidate_keyWords")
	WebElement keyWordsInputId;
	@FindBy(id = "notes")
	WebElement notesInputId;
	@FindBy(id = "btnSave")
	WebElement submitButtonId;
	@FindBy(id = "backLink")
	WebElement backToListId;

	// Methods of Page
	public AddCandidatePage goToAddCandidatePage() {
		click(addCandidateButtonXpath);

		return PageFactory.initElements(driver, AddCandidatePage.class);
	}
	
	public AddCandidatePage goToCandidatePage() {
		click(candidate);
		
		return PageFactory.initElements(driver, AddCandidatePage.class);
	}
	
}
