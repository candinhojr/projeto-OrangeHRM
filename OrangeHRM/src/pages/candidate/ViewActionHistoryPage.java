package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ViewActionHistoryPage extends BasePage{

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

	public boolean isSuccessMessagePresent() {
		ExpectedConditions.visibilityOf(message);

    	return this.message.getText().contains("Successfully Updated");
	}

}
