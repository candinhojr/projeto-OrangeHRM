package pages.candidate;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.Candidate;
import pages.BasePage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddCandidatePage extends BasePage {


	@FindBy(name = "addCandidate[firstName]")
	private WebElement firstName;
	@FindBy(name = "addCandidate[middleName]")
	private WebElement middleName;
	@FindBy(name = "addCandidate[lastName]")
	private WebElement lastName;

	@FindBy(name = "addCandidate[email]")
	private WebElement email;
	@FindBy(name = "addCandidate[contactNo]")
	private WebElement contactNo;
	@FindBy(name = "addCandidate[vacancy]")
	private WebElement vacancy;
	@FindBy(id = "viewCandidateAction_1")
	private WebElement selectAction;
	@FindBy(xpath = "//*[@id=\"0\"]/span")
	private WebElement statusMessage;
	
	public AddCandidatePage() {
		super();
	}

	// Construtor
	public AddCandidatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Metodos de acesso
	public void fillFirstName(String name) {
		writeText(this.firstName, name);
	}

	public void fillMiddleName(String name) {
		writeText(this.middleName, name);
	}

	public void fillLastName(String name) {
		writeText(this.lastName, name);
	}

	public void fillFullName(String first, String middle, String last) {
		this.fillFirstName(first);
		this.fillMiddleName(middle);
		this.fillLastName(last);
	}

	public void fillEmail(String email) {
		writeText(this.email, email);
	}

	public void fillContactNo(String contactNo) {
		writeText(this.contactNo, contactNo);
	}

	public void selectJobVacancy(String vacancy) throws NoSuchElementException {
		Select vacancyList = new Select(this.vacancy);
		vacancyList.selectByVisibleText(vacancy);
	}
	
	public void selectAction(String action) throws NoSuchElementException {
		selectElement(this.selectAction).selectByVisibleText(action);
	}
	
	public void clickActionShortlist() {
		Candidate candidate = new Candidate();
		this.selectAction(candidate.getCandidateShortlist());
	}
	
	public void clickActionScheduleInterview() {
		Candidate candidate = new Candidate();
		this.selectAction(candidate.getCandidateScheduleInterview());
	}
	
	public void clickActionMarkInterviewPassed() {
		Candidate candidate = new Candidate();
		this.selectAction(candidate.getCandidateMarkInterviewPassed());
	}
	
	public void clickActionOfferJob() {
		Candidate candidate = new Candidate();
		this.selectAction(candidate.getCandidateOfferJob());
	}
	
	public void clickActionHire() {
		Candidate candidate = new Candidate();
		this.selectAction(candidate.getCandidateHire());
	}
	
	public boolean checkStatusMessage(String status) {
		return readText(this.statusMessage).contains("Status: "+status);
	}

}
