package pages.mainMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;
import pages.candidate.ActiveCandidatesPage;
import pages.home.HomePage;
import pages.user.ListUsersPage;
import pages.vacancy.JobVacanciesListPage;

public class MainMenuPage extends BasePage {

	// Elementos Web

	// Menu e sub menu
	@FindBy(id = "menu_dashboard_index")
	WebElement menuDashboardId;
	@FindBy(id = "menu__Performance")
	WebElement menuPerformanceId;
	@FindBy(id = "menu_directory_viewDirectory")
	WebElement menuDirectoryId;
	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	WebElement menuRecruitmentId;
	@FindBy(id = "menu_recruitment_viewCandidates")
	WebElement menuRecruitment_ViewCandidatesId;
	@FindBy(id = "menu_recruitment_viewJobVacancy")
	WebElement menuRecruitment_ViewVacanciesId;
	@FindBy(id = "menu_time_viewTimeModule")
	WebElement menuTimeId;
	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement menuLeaveId;
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement menuPimId;
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement menuAdminId;
	@FindBy(id = "menu_admin_UserManagement")
	WebElement menuAdmin_UserManagementId;
	@FindBy(id = "menu_admin_viewSystemUsers")
	WebElement menuAdmin_UserManagement_ViewUsersId;

	// Logout
	@FindBy(id = "welcome")
	WebElement menuWelcomeXpath;
	@FindBy(linkText = "Logout")
	WebElement logoutXpath;

	public MainMenuPage() {
		super();
	}

	// Construtor
	public MainMenuPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Métodos do Page
	public JobVacanciesListPage goToViewJobVacancy() {
		click(menuRecruitmentId);
		click(menuRecruitment_ViewVacanciesId);

		return PageFactory.initElements(driver, JobVacanciesListPage.class);
	}

	public ActiveCandidatesPage goToViewCandidates() {
		click(menuRecruitmentId);
		click(menuRecruitment_ViewCandidatesId);

		return PageFactory.initElements(driver, ActiveCandidatesPage.class);
	}

	public ListUsersPage goToViewSystemUsers() {
		click(menuAdminId);
		click(menuAdmin_UserManagementId);
		click(menuAdmin_UserManagement_ViewUsersId);

		return PageFactory.initElements(driver, ListUsersPage.class);
	}

	public HomePage logOut() {
		click(menuWelcomeXpath);
		click(logoutXpath);

		return PageFactory.initElements(driver, HomePage.class);
	}
}
