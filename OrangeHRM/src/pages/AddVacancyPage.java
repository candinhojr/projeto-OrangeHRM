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
	
	// Metodos de acesso
	public void selectJobTitle(String choice) {
		Select jobTitleList = new Select(driver.findElement(By.name("addJobVacancy[jobTitle]")));
		jobTitleList.selectByVisibleText(choice);
	}
	
	public void fillVacancyName(String name) {
		writeText(By.name("addJobVacancy[name]"), name);
	}
	
	public void fillHiringManager(String manager) {
		writeText(By.name("addJobVacancy[hiringManager]"), manager);
	}
	
	public void fillNoPositions(String positions) {
		writeText(By.name("addJobVacancy[noOfPositions]"), positions);
	}
	
	public void fillDescription(String description) {
		writeText(By.name("addJobVacancy[description]"), description);
	}
	
	public void save() {
		click(By.xpath("//*[@id=\"btnSave\"]"));
	}
}
