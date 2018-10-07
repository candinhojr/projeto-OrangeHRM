package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	// Construtor
	public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);   
    }
	
	// Variáveis do Page
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	
	// Métodos do Page
	
	// Vai para a página de login
    public void goToOrangePageLogin (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
	}
}
