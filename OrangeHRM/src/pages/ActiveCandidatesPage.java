package pages;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiveCandidatesPage extends BasePage {

	public ActiveCandidatesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	// Elementos Web
	// Pagina com todos os candidatos
	String addCandidateButtonXpath = "//*[@id=\"btnAdd\"]";
	
	
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
	public void goToAddCandidatePage() {
		click(By.xpath(addCandidateButtonXpath));
	}
	
	
	/*public void firstNameRequired() {
		String color = findElement(By.id(firstNameInputId)).getCssValue("border-color").trim();
		System.out.println("RGB Color of header: " + color);
		String color_hex[];  
		color_hex = color.replace("rgb(", "").replace(")", "").split(",|,\\s");
		String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		System.out.println("HEX Color of header: " + actual_hex);
		Assert.assertEquals("actual_hex should equal to: ", "#aa4935", actual_hex);
		Assert.assertEquals("Required", findElement(By.xpath(firstNameRequiredXpath)).getText()); //findElement(By.xpath(firstNameRequiredXpath)).getText().contains("Required");
	
	}*/
	
}
