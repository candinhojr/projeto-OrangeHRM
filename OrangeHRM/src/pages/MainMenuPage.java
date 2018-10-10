package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuPage extends BasePage {
	
	// Construtor
	public MainMenuPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
	
	// Elementos Web
	
	// Menu e sub menu
	String menuDashboardId = "menu_dashboard_index";
	String menuPerformanceId = "menu__Performance";
	String menuDirectoryId = "menu_directory_viewDirectory";
	String menuRecruitmentId = "menu_recruitment_viewRecruitmentModule";
		String menuRecruitment_ViewCandidatesId = "menu_recruitment_viewCandidates";
		String menuRecruitment_ViewVacanciesId = "menu_recruitment_viewJobVacancy";
	String menuTimeId = "menu_time_viewTimeModule";
	String menuLeaveId = "menu_leave_viewLeaveModule";
	String menuPimId = "menu_pim_viewPimModule";
	String menuAdminId = "menu_admin_viewAdminModule";	
		String menuAdmin_UserManagementId = "menu_admin_UserManagement";
			String menuAdmin_UserManagement_ViewUsersId = "menu_admin_viewSystemUsers";
	
	// Logout
	String menuWelcomeXpath = "//*[@id=\"welcome\"]";
		String logoutXpath = "//*[@id='welcome-menu']/ul/li[2]/a";
	
		
	// Métodos do Page
	public void goToViewJobVacancy() {
		click(By.id(menuRecruitmentId));
		click(By.id(menuRecruitment_ViewVacanciesId));
	}
	
	public void goToViewCandidates() {
		click(By.id(menuRecruitmentId));
		click(By.id(menuRecruitment_ViewCandidatesId));
	}
	
	public void goToViewSystemUsers() {
		click(By.id(menuAdminId));
		click(By.id(menuAdmin_UserManagementId));
		click(By.id(menuAdmin_UserManagement_ViewUsersId));
	}
	
	public void logOut() {
		click(By.xpath(menuWelcomeXpath));
		click(By.xpath(logoutXpath));
	}
}
