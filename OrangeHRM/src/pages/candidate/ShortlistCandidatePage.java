package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ShortlistCandidatePage extends BasePage {

	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[1]/label[2]")
	private WebElement candidadeNameXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[2]/label[2]")
	private WebElement vacancyXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[3]/label[2]")
	private WebElement hiringManagerXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[4]/label[2]")
	private WebElement currentStatusXpath;
	@FindBy(id= "actionBtn")
	private WebElement shortlistButtonId;
	
	public ShortlistCandidatePage() {
		super();
	}

	public ShortlistCandidatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void clickShortlist() {
		click(this.shortlistButtonId);
	}
	
	public boolean checkCandidateName(String candidateFullName) {
		return readText(this.candidadeNameXpath).contains(candidateFullName);
	}

	public boolean checkVacancyName(String vacancyName) {
		return readText(this.vacancyXpath).contains(vacancyName);
	}

	public boolean checkHiringManager(String hiringManager) {
		return readText(this.hiringManagerXpath).contains(hiringManager);
	}
	
	public boolean checkCurrentStatus(String status) {
		return readText(this.currentStatusXpath).contains(status);		
	}

}
