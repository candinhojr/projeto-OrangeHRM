package pages.candidate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class OfferJobPage extends BasePage {
	@FindBy(id= "actionBtn")
	private WebElement offerJobButtonId;
	
	public OfferJobPage() {
		super();
	}

	public OfferJobPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void clickOfferJob() {
		click(this.offerJobButtonId);
	}
}
