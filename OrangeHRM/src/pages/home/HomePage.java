package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;
import pages.login.LoginPage;
import pages.vacancy.ActiveJobVacanciesPage;

public class HomePage extends BasePage {

	// Variáveis do Page
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	String activeJobVacanciesURL = "https://opensource-demo.orangehrmlive.com/index.php/recruitmentApply/jobs";

	public HomePage() {
		super();
	}

	// Construtor
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Métodos do Page

	// Vai para a página de login
	public LoginPage goToOrangePageLogin() {
		driver.get(baseURL);

		return PageFactory.initElements(driver, LoginPage.class);
	}

	public ActiveJobVacanciesPage goToActiveJobVacancies() {
		driver.get(activeJobVacanciesURL);

		return PageFactory.initElements(driver, ActiveJobVacanciesPage.class);
	}
}
