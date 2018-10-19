package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class MarkInterviewPassedPage extends BasePage{
	
	@FindBy(id= "actionBtn")
	private WebElement markInterviewPassedButtonId;
	
	public MarkInterviewPassedPage() {
		super();
	}

	public MarkInterviewPassedPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void clickMarkInterviewPassed() {
		click(this.markInterviewPassedButtonId);
	}
}
