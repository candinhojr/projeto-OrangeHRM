package pages.vacancy;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.Candidate;
import pages.BasePage;

public class ActiveJobVacanciesPage extends BasePage {

	public ActiveJobVacanciesPage() {
		super();
	}

	public ActiveJobVacanciesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elementos Web
	// Pagina com todas as vagas em aberto
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[1]/h1/font/font")
	private WebElement titleActiveJobVacanciesXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/span/font/font")
	private WebElement messageNoActiveJobVacanciesXpath;
	
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/div")
	private WebElement vacancyTitleXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/pre[1]")
	private WebElement vacancyJobDescriptionXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/p/input")
	private WebElement applyButtonXpath;
	
	@FindBy(xpath = "//*[@id=\"frmAddCandidate\"]/fieldset/ol[1]/li[2]/ol/li[1]/span")
	private WebElement firstNameRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_lastName\"]")
	private WebElement lastNameRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_email\"]")
	private WebElement emailRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_resume\"]")
	private WebElement resumeRequiredXpath;
	
	@FindBy(xpath = "//*[@id=\"frmAddCandidate\"]/fieldset/ol[2]/li[1]/span")
	private WebElement resumeUploaded;

	// Pagina de uma vaga em especifico
	@FindBy(id = "addCandidateHeading")
	private WebElement vacancieTitleId;
	@FindBy(id = "addCandidate_firstName")
	private WebElement firstNameInputId;
	@FindBy(id = "addCandidate_middleName")
	private WebElement middleNameInputId;
	@FindBy(id = "addCandidate_lastName")
	private WebElement lastNameInputId;
	@FindBy(id = "addCandidate_email")
	private WebElement emailInputId;
	@FindBy(id = "addCandidate_contactNo")
	private WebElement contactNoInputId;
	@FindBy(id = "addCandidate_resume")
	private WebElement resumeInputFileId;
	@FindBy(id = "addCandidate_keyWords")
	private WebElement keyWordsInputId;
	@FindBy(id = "notes")
	private WebElement notesInputId;
	@FindBy(id = "btnSave")
	private WebElement submitButtonId;
	@FindBy(id = "backLink")
	private WebElement backToListId;
	@FindBy(css = ".message")
	private WebElement message;

	// Métodos do Page
	public void goToJobVacanciePage() {
		click(this.applyButtonXpath);
	}
	
	public void createCandidate(Candidate candidate) {
		this.fillFullName(candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName());
		this.fillEmail(candidate.getEmail());
		this.fillContactNo(candidate.getContactNumber());
		this.addResume(candidate.getResume());
		this.fillKeyWords(candidate.getKeyWords());
		this.fillNotes(candidate.getNotes());
	}
	
	public void fillFullName(String firstName, String middleName, String lastName) {
        writeText(this.firstNameInputId, firstName);
        writeText(this.middleNameInputId, middleName);
        writeText(this.lastNameInputId, lastName);
	}
	
	public void fillEmail(String email) {
		writeText(this.emailInputId, email);
	}
	
	public void fillContactNo(String contactNo) {
		writeText(this.contactNoInputId, contactNo);
	}
	
	public void addResume(String pathOfResume) {
		click(this.resumeInputFileId);
		File file = new File(pathOfResume);
		findElement(this.resumeInputFileId).sendKeys(file.getAbsolutePath());
	}	
	
	public void fillKeyWords(String keyWords) {
		String[] separateText = keyWords.split("\\s|,\\s|;\\s");
		for (String keyWord : separateText) {
			writeText(this.keyWordsInputId, keyWord + " ");
		}
	}
	
	public void fillNotes(String notes) {
		writeText(this.notesInputId, notes);
	}
	
	public void clickSubmit() {
		click(this.submitButtonId);
	}
	
	public void backToListOfJobVacancies() {
		click(this.backToListId);
	}
	
	public boolean checkForVacancies() {
		return readText(this.messageNoActiveJobVacanciesXpath).equalsIgnoreCase("No active job vacancies to display");
	}
	
	public void requiredFields() {
		this.firstNameRequired();
		this.lastNameRequired();
		this.emailRequired();
		this.resumeRequired();
	}
	
	public boolean applyOk() {
		return readText(this.resumeUploaded).equalsIgnoreCase("Uploaded");
	}

	public void firstNameRequired() {
		String color = findElement(this.firstNameInputId).getCssValue("border-color").trim();
//		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
//		System.out.println("HEX Color of header: " + actual_hex);
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(this.firstNameRequiredXpath).equalsIgnoreCase("required");
//		Assert.assertEquals("Required", findElement(firstNameRequiredXpath).getText()); 
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(firstNameRequiredXpath));
	}
	
	public void lastNameRequired() {
		String color = findElement(this.lastNameInputId).getCssValue("border-color").trim();
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(this.lastNameRequiredXpath).equalsIgnoreCase("required");
	}
	
	public void emailRequired() {
		String color = findElement(emailInputId).getCssValue("border-color").trim();
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(this.emailRequiredXpath).equalsIgnoreCase("required");
	}
	
	public void resumeRequired() {
		String color = findElement(resumeInputFileId).getCssValue("border-color").trim();
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(this.resumeRequiredXpath).equalsIgnoreCase("required");		
	}
	
	public void emailIncorrect() {
		String color = findElement(this.emailInputId).getCssValue("border-color").trim();
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(this.emailRequiredXpath).equalsIgnoreCase("Expected format: admin@example.com");
	}
	
	public boolean isSuccessMessagePresent() {
	    ExpectedConditions.visibilityOf(message);

	    return this.message.getText().contains("Application Received");
	}
	
}
