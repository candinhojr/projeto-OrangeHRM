package pages;

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
	
	public void addResume() {
		// TODO: see a manner of add document
	}
	
	public void fillKeyWords(String keyWords) {
		// TODO: see a manner of add one or more than one word
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
	
}
