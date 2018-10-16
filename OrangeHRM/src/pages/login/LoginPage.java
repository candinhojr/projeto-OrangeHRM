package pages.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;
import pages.mainMenu.MainMenuPage;

public class LoginPage extends BasePage {
	
	// Elementos Web
	@FindBy(id = "txtUsername")
	WebElement usernameId;
	@FindBy(id = "txtPassword")
	WebElement passwordId;
	@FindBy(id = "btnLogin")
	WebElement loginButtonId;
	@FindBy(id = "spanMessage")
	WebElement invalidCredentialsId;

	public LoginPage() {
		super();
	}

	// Construtor
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Métodos do Page
	public MainMenuPage loginToOrangeHRM(String username, String password) {
		// Entra com o username
		writeText(usernameId, username);
		// Entra com o password
		writeText(passwordId, password);
		// Clica no botão de login
		click(loginButtonId);

		return PageFactory.initElements(driver, MainMenuPage.class);
	}

	public void verifyLogin(String expectedText) {
		Assert.assertEquals(readText(invalidCredentialsId), expectedText);
	}

	public boolean loginWithSucess() {
		if (driver.getCurrentUrl().contains("dashboard")) {
			return true;
		} else
			return false;
	}

}
