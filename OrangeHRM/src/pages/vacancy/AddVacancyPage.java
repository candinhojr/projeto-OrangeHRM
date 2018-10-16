package pages.vacancy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddVacancyPage extends BasePage {

	
	@FindBy(name = "addJobVacancy[jobTitle]")
	private WebElement jobTitle;
	@FindBy(name = "addJobVacancy[name]")
	private WebElement name;
	@FindBy(name = "addJobVacancy[hiringManager]")
	private WebElement hiringManager;
	@FindBy(name = "addJobVacancy[noOfPositions]")
	private WebElement noOfPositions;
	@FindBy(name = "addJobVacancy[description]")
	private WebElement description;

	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	private WebElement btnSave;

	public AddVacancyPage() {
		super();
	}

	// Construtor
	public AddVacancyPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Metodos de acesso
	public void selectJobTitle(String choice) {
		Select jobTitleList = new Select(this.jobTitle);
		jobTitleList.selectByVisibleText(choice);
	}

	public void fillVacancyName(String name) {
		writeText(this.name, name);
	}

	public void fillHiringManager(String manager) {
		writeText(this.hiringManager, manager);
	}

	public void fillNoPositions(String positions) {
		writeText(this.noOfPositions, positions);
	}

	public void fillDescription(String description) {
		writeText(this.description, description);
	}

	public void save() {
		click(this.btnSave);
	}
}
