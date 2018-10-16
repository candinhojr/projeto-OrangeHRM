package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.home.HomePage;
import pages.login.LoginPage;
import pages.mainMenu.MainMenuPage;
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
        this.waitTime(1000);
        elementLocation.click();
    }

    // Método writeText
    public void writeText(WebElement elementLocation, String text) {
        this.waitTime(1000);
        // driver.findElement(elementLocation).sendKeys(text);
        elementLocation.sendKeys(text);
    }

    // Método readText
    public String readText(WebElement elementLocation) {
        this.waitTime(1000);
        return elementLocation.getText();
    }

    // Método findElement
    public WebElement findElement(WebElement elementLocation) {
        this.waitTime(1000);
        return elementLocation;
    }

    // Método selectElement pra seleção de dropdowns
    public Select selectElement(WebElement elementLocation) {
        this.waitTime(1000);
        return new Select(elementLocation);
    }

    public LoginPage goToLoginPage() {
        driver.get(this.BASE_PAGE_URL);

        return PageFactory.initElements(driver, LoginPage.class);
    }

    public HomePage logOut() {

        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);

        this.waitTime(1000);

        mainMenuPage.logOut();

        return PageFactory.initElements(driver, HomePage.class);
    }

    private void waitTime(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
    }

}
