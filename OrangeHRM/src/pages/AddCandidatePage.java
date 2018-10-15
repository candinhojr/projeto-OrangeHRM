package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class AddCandidatePage extends BasePage {

	// Construtor
	public AddCandidatePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
	
	// Metodos de acesso
	public void fillFirstName(String name) {
		writeText(By.name("addCandidate[firstName]"), name);
	}
	
	public void fillMiddleName(String name) {
		writeText(By.name("addCandidate[middleName]"), name);
	}
	
	public void fillLastName(String name) {
		writeText(By.name("addCandidate[lastName]"), name);
	}
	
	public void fillFullName(String first, String middle, String last) {
		fillFirstName(first);
		fillMiddleName(middle);
		fillLastName(last);
	}
	
	public void fillEmail(String email) {
		writeText(By.name("addCandidate[email]"), email);
	}
	
	public void fillContactNo(String contactNo) {
		writeText(By.name("addCandidate[contactNo]"), contactNo);
	}
	
	public void selectJobVacancy(String vacancy) throws NoSuchElementException{
		Select vacancyList = new Select(driver.findElement(By.name("addCandidate[vacancy]")));
		vacancyList.selectByVisibleText(vacancy);
	}
}
