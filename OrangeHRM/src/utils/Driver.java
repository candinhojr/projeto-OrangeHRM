package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
  private static Driver instance = new Driver();

  private WebDriver driver;
  private WebDriverWait wait;

	//  public String driverPath = "dependences/chromedriver";
	public String driverPath = "dependences/chromedriver.exe";

  private Driver() {

    System.setProperty("webdriver.chrome.driver", driverPath);

    this.driver = new ChromeDriver();

    this.wait = new WebDriverWait(driver, 3000, 1000);

    this.driver.manage().window().maximize();
  }


  public static Driver getInstance() {
    return Driver.instance;
  }

  public WebDriver getWebDriver() {
    return this.driver;
  }

  public WebDriverWait getWebDriverWait() {
    return this.wait;
  }
}