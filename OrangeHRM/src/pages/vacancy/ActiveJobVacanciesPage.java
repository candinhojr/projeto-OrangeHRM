package pages.vacancy;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ActiveJobVacanciesPage extends BasePage {

	public ActiveJobVacanciesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elementos Web
	// Pagina com todas as vagas em aberto
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[1]/h1/font/font")
	WebElement titleActiveJobVacanciesXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/span/font/font")
	WebElement messageNoActiveJobVacanciesXpath;
	
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/div")
	WebElement vacancyTitleXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/pre[1]")
	WebElement vacancyJobDescriptionXpath;
	@FindBy(xpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/p/input")
	WebElement applyButtonXpath;
	
	@FindBy(xpath = "//*[@id=\"frmAddCandidate\"]/fieldset/ol[1]/li[2]/ol/li[1]/span")
	WebElement firstNameRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_lastName\"]")
	WebElement lastNameRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_email\"]")
	WebElement emailRequiredXpath;
	@FindBy(xpath = "//*[@id=\"addCandidate_resume\"]")
	WebElement resumeRequiredXpath;

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
	public void goToJobVacanciePage() {
		click(applyButtonXpath);
	}
	
	public void fillFullName(String firstName, String middleName, String lastName) {
        writeText(firstNameInputId, firstName);
        writeText(middleNameInputId, middleName);
        writeText(lastNameInputId, lastName);
	}
	
	public void fillEmail(String email) {
		writeText(emailInputId, email);
	}
	
	public void fillContactNo(String contactNo) {
		writeText(contactNoInputId, contactNo);
	}
	
	public void addResume(String pathOfResume) {
		click(resumeInputFileId);
		File file = new File(pathOfResume);
		findElement(resumeInputFileId).sendKeys(file.getAbsolutePath());
	}	
	
	public void fillKeyWords(String keyWords) {
		String[] separateText = keyWords.split("\\s|,\\s|;\\s");
		for (String keyWord : separateText) {
			writeText(keyWordsInputId, keyWord + " ");
		}
	}
	
	public void fillNotes(String notes) {
		writeText(notesInputId, notes);
	}
	
	public void clickSubmit() {
		click(submitButtonId);
	}
	
	public void backToListOfJobVacancies() {
		click(backToListId);
	}
	
	public boolean checkForVacancies() {
		return readText(messageNoActiveJobVacanciesXpath).equalsIgnoreCase("No active job vacancies to display");
	}
	
	public void requiredFields() {
		this.firstNameRequired();
		this.lastNameRequired();
		this.emailRequired();
		this.resumeRequired();
	}
	
	public void requiredFieldsOK() {
		this.firstNameRequired();
		this.lastNameRequired();
		this.emailRequired();
		this.resumeRequired();
	}

	public void firstNameRequired() {
		String color = findElement(firstNameInputId).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
//		System.out.println("HEX Color of header: " + actual_hex);
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(firstNameRequiredXpath).equalsIgnoreCase("required");
//		Assert.assertEquals("Required", findElement(firstNameRequiredXpath).getText()); 
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(firstNameRequiredXpath));
	}
	
	public void lastNameRequired() {
		String color = findElement(lastNameInputId).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(lastNameRequiredXpath).equalsIgnoreCase("required");
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(lastNameRequiredXpath));
	}
	
	public void emailRequired() {
		String color = findElement(emailInputId).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(emailRequiredXpath).equalsIgnoreCase("required");
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(emailRequiredXpath));
	}
	
	private void resumeRequired() {
		String color = findElement(resumeInputFileId).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(resumeRequiredXpath).equalsIgnoreCase("required");		
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(resumeRequiredXpath));
	}
	
	private void emailIncorrect() {
		String color = findElement(emailInputId).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(emailRequiredXpath).equalsIgnoreCase("Expected format: admin@example.com");
//		return "#aa4935".equals(actual_hex) && "Expected format: admin@example.com".equals(readText(emailRequiredXpath));
	}
	
}
