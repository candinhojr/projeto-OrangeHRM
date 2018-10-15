package pages;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiveJobVacanciesPage extends BasePage {

	public ActiveJobVacanciesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elementos Web
	// Pagina com todas as vagas em aberto
	String titleActiveJobVacanciesXpath = "//*[@id=\"jobPage\"]/div/div/div[1]/h1/font/font";
	String messageNoActiveJobVacanciesXpath = "//*[@id=\"jobPage\"]/div/div/div[2]/span/font/font";
	
	String vacancyTitleXpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/div";
	String vacancyJobDescriptionXpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/pre[1]";
	String applyButtonXpath = "//*[@id=\"jobPage\"]/div/div/div[2]/div[3]/p/input";
	
	String firstNameRequiredXpath = "//*[@id=\"frmAddCandidate\"]/fieldset/ol[1]/li[2]/ol/li[1]/span";
	String lastNameRequiredXpath = "//*[@id=\"addCandidate_lastName\"]";
	String emailRequiredXpath = "//*[@id=\"addCandidate_email\"]";
	String resumeRequiredXpath = "//*[@id=\"addCandidate_resume\"]";
	
	// TODO: To finish
	
	// Pagina de uma vaga em especifico
	String vacancieTitleId = "addCandidateHeading";
	String firstNameInputId = "addCandidate_firstName";
	String middleNameInputId = "addCandidate_middleName";
	String lastNameInputId = "addCandidate_lastName";
	String emailInputId = "addCandidate_email";
	String contactNoInputId = "addCandidate_contactNo";
	String resumeInputFileId = "addCandidate_resume";
	String keyWordsInputId = "addCandidate_keyWords";
	String notesInputId = "notes";
	String submitButtonId = "btnSave";
	String backToListId = "backLink";

	// Métodos do Page
	public void goToJobVacanciePage() {
		click(By.xpath(applyButtonXpath));
	}
	
	public void fillFullName(String firstName, String middleName, String lastName) {
        writeText(By.id(firstNameInputId), firstName);
        writeText(By.id(middleNameInputId), middleName);
        writeText(By.id(lastNameInputId), lastName);
	}
	
	public void fillEmail(String email) {
		writeText(By.id(emailInputId), email);
	}
	
	public void fillContactNo(String contactNo) {
		writeText(By.id(contactNoInputId), contactNo);
	}
	
	public void addResume(String pathOfResume) {
		click(By.id(resumeInputFileId));
		File file = new File(pathOfResume);
		findElement(By.id(resumeInputFileId)).sendKeys(file.getAbsolutePath());
	}	
	
	public void fillKeyWords(String keyWords) {
		String[] separateText = keyWords.split("\\s|,\\s|;\\s");
		for (String keyWord : separateText) {
			writeText(By.id(keyWordsInputId), keyWord + " ");
		}
	}
	
	public void fillNotes(String notes) {
		writeText(By.id(notesInputId), notes);
	}
	
	public void clickSubmit() {
		click(By.id(submitButtonId));
	}
	
	public void backToListOfJobVacancies() {
		click(By.id(backToListId));
	}
	
	public boolean checkForVacancies() {
		return readText(By.xpath(messageNoActiveJobVacanciesXpath)).equalsIgnoreCase("No active job vacancies to display");
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
		String color = findElement(By.id(firstNameInputId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
//		System.out.println("HEX Color of header: " + actual_hex);
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(By.xpath(firstNameRequiredXpath)).equalsIgnoreCase("required");
//		Assert.assertEquals("Required", findElement(By.xpath(firstNameRequiredXpath)).getText()); 
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(By.xpath(firstNameRequiredXpath)));
	}
	
	public void lastNameRequired() {
		String color = findElement(By.id(lastNameInputId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(By.xpath(lastNameRequiredXpath)).equalsIgnoreCase("required");
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(By.xpath(lastNameRequiredXpath)));
	}
	
	public void emailRequired() {
		String color = findElement(By.id(emailInputId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(By.xpath(emailRequiredXpath)).equalsIgnoreCase("required");
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(By.xpath(emailRequiredXpath)));
	}
	
	private void resumeRequired() {
		String color = findElement(By.id(resumeInputFileId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(By.xpath(resumeRequiredXpath)).equalsIgnoreCase("required");		
//		return "#aa4935".equals(actual_hex) && "Required".equals(readText(By.xpath(resumeRequiredXpath)));
	}
	
	private void emailIncorrect() {
		String color = findElement(By.id(emailInputId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		readText(By.xpath(emailRequiredXpath)).equalsIgnoreCase("Expected format: admin@example.com");
//		return "#aa4935".equals(actual_hex) && "Expected format: admin@example.com".equals(readText(By.xpath(emailRequiredXpath)));
	}
	
}
