package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class AddVacancyPage extends BasePage {

	// Construtor
	public AddVacancyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
	
	// TODO Elementos web
	
	// TODO Metodos de acesso
	public void selectJobTitle(String choice) {
		Select jobTitleList = new Select(driver.findElement(By.name("addJobVacancy[jobTitle]")));
		jobTitleList.selectByVisibleText(choice);
	}
}
