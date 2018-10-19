package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class HireCandidatePage extends BasePage{
	@FindBy(id= "actionBtn")
	private WebElement hireButtonId;
	
	public HireCandidatePage() {
		super();
	}

	public HireCandidatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void clickHire() {
		click(this.hireButtonId);
	}
}
