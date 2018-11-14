package pages.vacancy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ActiveVacancyPage extends BasePage {

	public ActiveVacancyPage() {
		super();
	}

	public ActiveVacancyPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elementos Web
	// Pagina com todos os candidatos
	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	WebElement addVacancyButtonXpath;
	
	
	// Pagina de uma vaga em especifico
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

	// Métodos do Page
	public AddVacancyPage goToAddVacancyPage() {
		click(addVacancyButtonXpath);

		return PageFactory.initElements(driver, AddVacancyPage.class);
	}
	
}
