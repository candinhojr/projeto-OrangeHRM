package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.login.LoginPage;
import utils.Driver;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    private final String BASE_PAGE_URL = "https://opensource-demo.orangehrmlive.com/";

    public BasePage() {
        this.driver = Driver.getInstance().getWebDriver();
        this.wait = Driver.getInstance().getWebDriverWait();
    }

    // Construtor
    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Método click
    public void click(WebElement elementLocation) {
        elementLocation.click();
    }

    // Método writeText
    public void writeText(WebElement elementLocation, String text) {
        // driver.findElement(elementLocation).sendKeys(text);
        elementLocation.sendKeys(text);
    }

    // Método readText
    public String readText(WebElement elementLocation) {
        return elementLocation.getText();
    }

    // Método findElement
    public WebElement findElement(WebElement elementLocation) {
        return elementLocation;
    }

    // Método selectElement pra seleção de dropdowns
    public Select selectElement(WebElement elementLocation) {
        return new Select(elementLocation);
    }

    public LoginPage goToLoginPage() {
        driver.get(this.BASE_PAGE_URL);

        return PageFactory.initElements(driver, LoginPage.class);
    }

}
