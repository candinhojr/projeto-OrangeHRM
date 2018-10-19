package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;
import pages.vacancy.ActiveJobVacanciesPage;

public class HomePage extends BasePage {

	String activeJobVacanciesURL = "https://opensource-demo.orangehrmlive.com/index.php/recruitmentApply/jobs";

	public HomePage() {
		super();
	}

	// Construtor
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public ActiveJobVacanciesPage goToActiveJobVacancies() {
		driver.get(activeJobVacanciesURL);

		return PageFactory.initElements(driver, ActiveJobVacanciesPage.class);
	}
}
