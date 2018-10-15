package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
    public WebDriverWait wait;
 
    //Construtor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
 
    // Método click
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
 
    // Método writeText
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
 
    // Método readText
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    
    // Método findElement
    public WebElement findElement(By elementLocation) {
    	return driver.findElement(elementLocation);
    }

    // Método selectElement pra seleção de dropdowns
    public Select selectElement(By elementLocation) {
        return new Select(driver.findElement(elementLocation));
    }

}
