package pages.vacancy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.Vacancy;
import pages.BasePage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	@FindBy(xpath = "//*[@id=\"frmAddJobVacancy\"]/fieldset/ol/li[1]/span")
	private WebElement jobTitleRequiredXpath;
	@FindBy(xpath = "//*[@id=\"frmAddJobVacancy\"]/fieldset/ol/li[2]/span")
	private WebElement vacancyNameRequiredXpath;
	@FindBy(xpath = "//*[@id=\"frmAddJobVacancy\"]/fieldset/ol/li[3]/span")
	private WebElement hiringManagerRequiredXpath;
	@FindBy(xpath = "//*[@id=\"frmAddJobVacancy\"]/fieldset/ol/li[3]/span")
	private WebElement noOfPositionsMessageXpath;
	@FindBy(xpath = "//*[@id=\"btnBack\"]")
	private WebElement btnBack;
	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	private WebElement btnSave;
	@FindBy(css = ".message")
	private WebElement message;

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
		writeText(this.noOfPositions, positions );
	}

	public void fillDescription(String description) {
		writeText(this.description, description);
	}

	public void clickSave() {
		click(this.btnSave);
	}
	
	public void clickBack() {
		click(this.btnBack);
	}
	
	public void requiredFields() {
		this.jobTitleRequired();
		this.vacancyNameRequired();
		this.hiringManagerRequired();
	}
	public void jobTitleRequired() {
		String color = findElement(this.jobTitle).getCssValue(utils.Constants.borderColor).trim();
		String[] colorHex;  
		colorHex = color.replace("rgb(", "").replace(")", "").split(utils.Constants.regexCommaOrCommaSpace);
		String actualHex = String.format(utils.Constants.rgbFormat, Integer.parseInt(colorHex[0].trim()), Integer.parseInt(colorHex[1].trim()), Integer.parseInt(colorHex[2].trim()));  
		Assert.assertEquals(utils.Constants.hexColorAA4935, actualHex);
		Assert.assertTrue(readText(this.jobTitleRequiredXpath).equalsIgnoreCase(utils.Constants.required));
	}
	
	public void vacancyNameRequired() {
		String color = findElement(this.name).getCssValue(utils.Constants.borderColor).trim();
		String[] colorHex;  
		colorHex = color.replace("rgb(", "").replace(")", "").split(utils.Constants.regexCommaOrCommaSpace);
		String actualHex = String.format(utils.Constants.rgbFormat, Integer.parseInt(colorHex[0].trim()), Integer.parseInt(colorHex[1].trim()), Integer.parseInt(colorHex[2].trim()));  
		Assert.assertEquals(utils.Constants.hexColorAA4935, actualHex);
		Assert.assertTrue(readText(this.vacancyNameRequiredXpath).equalsIgnoreCase(utils.Constants.required));
	}
	
	public void vacancyNameAlreadyExists() {
		String color = findElement(this.name).getCssValue(utils.Constants.borderColor).trim();
		String[] colorHex;  
		colorHex = color.replace("rgb(", "").replace(")", "").split(utils.Constants.regexCommaOrCommaSpace);
		String actualHex = String.format(utils.Constants.rgbFormat, Integer.parseInt(colorHex[0].trim()), Integer.parseInt(colorHex[1].trim()), Integer.parseInt(colorHex[2].trim()));  
		Assert.assertEquals(utils.Constants.hexColorAA4935, actualHex);
		Assert.assertTrue(readText(this.vacancyNameRequiredXpath).equalsIgnoreCase("Already exists"));
	}
	
	public void hiringManagerRequired() {
		String color = findElement(this.hiringManager).getCssValue(utils.Constants.borderColor).trim();
		String[] colorHex;  
		colorHex = color.replace("rgb(", "").replace(")", "").split(utils.Constants.regexCommaOrCommaSpace);
		String actualHex = String.format(utils.Constants.rgbFormat, Integer.parseInt(colorHex[0].trim()), Integer.parseInt(colorHex[1].trim()), Integer.parseInt(colorHex[2].trim()));  
		Assert.assertEquals(utils.Constants.hexColorAA4935, actualHex);
		Assert.assertTrue(readText(this.hiringManagerRequiredXpath).equalsIgnoreCase(utils.Constants.required));
	}
	
	public void noOfPositionsInvalid() {
		String color = findElement(this.noOfPositions).getCssValue(utils.Constants.borderColor).trim();
		String[] colorHex;  
		colorHex = color.replace("rgb(", "").replace(")", "").split(utils.Constants.regexCommaOrCommaSpace);
		String actualHex = String.format(utils.Constants.rgbFormat, Integer.parseInt(colorHex[0].trim()), Integer.parseInt(colorHex[1].trim()), Integer.parseInt(colorHex[2].trim()));  
		Assert.assertEquals(utils.Constants.hexColorAA4935, actualHex);
		Assert.assertTrue(readText(this.noOfPositionsMessageXpath).equalsIgnoreCase("Should be a positive number"));
	}
	
	public boolean isSuccessMessagePresent() {
	    ExpectedConditions.visibilityOf(message);

	    return this.message.getText().contains("Successfully Saved");
	}

	public void createVacancy(Vacancy vacancy) {
		this.selectJobTitle(vacancy.getJobTitle());
		this.fillVacancyName(vacancy.getVacancyName());
		this.fillHiringManager(vacancy.getHiringManager());
		this.fillNoPositions(vacancy.getNumberOfPositions());
		this.fillDescription(vacancy.getDescription());
		
	}
	
}
