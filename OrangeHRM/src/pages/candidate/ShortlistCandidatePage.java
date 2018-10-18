package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ShortlistCandidatePage extends BasePage {

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

}
