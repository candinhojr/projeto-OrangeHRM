package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	// Construtor
	public LoginPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
	
	// Elementos Web
	String usernameId = "txtUsername";
	String passwordId = "txtPassword";
	String loginButtonId = "btnLogin";
	String invalidCredentialsId = "spanMessage";
	
	// Métodos do Page
	public void loginToOrangeHRM (String username, String password){
        // Entra com o username
        writeText(By.id(usernameId),username);
        // Entra com o password
        writeText(By.id(passwordId), password);
        // Clica no  botão de login
        click(By.id(loginButtonId));
    }
	
	public void verifyLogin (String expectedText) {
        Assert.assertEquals(readText(By.id(invalidCredentialsId)), expectedText);
	}
	
	public boolean loginWithSucess() {
		if (driver.getCurrentUrl().contains("dashboard")) {
			return true;
		}
		else
			return false;
	}
	
}
