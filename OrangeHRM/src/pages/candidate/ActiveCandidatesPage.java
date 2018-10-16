package pages.candidate;

import java.io.File;

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
	
	// Elementos Web
	// Pagina com todos os candidatos
	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	WebElement addCandidateButtonXpath;
	
	
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
	public AddCandidatePage goToAddCandidatePage() {
		click(addCandidateButtonXpath);

		return PageFactory.initElements(driver, AddCandidatePage.class);
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
