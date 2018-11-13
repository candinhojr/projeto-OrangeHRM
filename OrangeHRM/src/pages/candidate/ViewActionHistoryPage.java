package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ViewActionHistoryPage extends BasePage{

	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[1]/label[2]")
	private WebElement candidadeNameXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[2]/label[2]")
	private WebElement vacancyXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[3]/label[2]")
	private WebElement hiringManagerXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[4]/label[2]")
	private WebElement currentStatusXpath;
	@FindBy(xpath = "//*[@id=\"frmCandidateVacancyStatus\"]/fieldset/ol/li[5]/label[2]")
	private WebElement performedActionXpath;
	
	@FindBy(id = "btnSave")
	private WebElement editButtonId;
	@FindBy(id = "cancelBtn")
	private WebElement backButtonId;
	@FindBy(css = ".message")
	private WebElement message;
	
	public ViewActionHistoryPage() {
		super();
	}

	public ViewActionHistoryPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void clickEditAction() {
		click(this.editButtonId);
	}
	
	public void clickBack() {
		click(this.backButtonId);
	}
	
	public boolean checkCandidateName(String name) {
		return readText(this.candidadeNameXpath).contains(name);
	}

	public boolean isSuccessMessagePresent() {
		ExpectedConditions.visibilityOf(message);

    	return this.message.getText().contains("Successfully Updated");
	}

	public boolean checkCurrentStatus(String status) {
		return readText(this.currentStatusXpath).contains(status);		
	}

	public boolean checkPerformedAction(String action) {
		return readText(this.performedActionXpath).contains(action);		
	}

	public boolean checkVacancyName(String vacancyName) {
		return readText(this.vacancyXpath).contains(vacancyName);
	}

	public boolean checkHiringManager(String hiringManager) {
		return readText(this.hiringManagerXpath).contains(hiringManager);
	}

}
