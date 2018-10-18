package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ScheduleInterviewCandidatePage extends BasePage {
	
	@FindBy(id = "jobInterview_name")
	private WebElement interviewTitleId;
	@FindBy(id = "jobInterview_interviewer_1")
	private WebElement interviewerNameId;
	@FindBy(id = "jobInterview_date")
	private WebElement interviewDateId;
	@FindBy(id = "saveBtn")
	private WebElement saveButtonId;
	@FindBy(id = "cancelButton")
	private WebElement backButtonId;
	@FindBy(css = ".message")
	private WebElement message;
	
	public ScheduleInterviewCandidatePage() {
		super();
	}
	public ScheduleInterviewCandidatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void fillInterviewTitle(String interviewTitle) {
		writeText(this.interviewTitleId, interviewTitle);
	}
	
	public void fillInterviewerName(String interviewerName) {
		writeText(this.interviewerNameId, interviewerName);
	}
	
	public void fillInterviewDate(String interviewDate) {
		writeText(interviewDateId, interviewDate);
	}
	
	public void clickSave() {
		click(saveButtonId);
	}
	
	public void clickBack() {
		click(backButtonId);
	}
	
	public boolean isSuccessMessagePresent() {
		ExpectedConditions.visibilityOf(message);

    	return this.message.getText().contains("Successfully Scheduled");
	}

}
