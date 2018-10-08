package pages;

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
		String menuRecruitmentViewCandidatesId = "menu_recruitment_viewCandidates";
		String menuRecruitmentViewVacanciesId = "menu_recruitment_viewJobVacancy";
	String menuTimeId = "menu_time_viewTimeModule";
	String menuLeaveId = "menu_leave_viewLeaveModule";
	String menuPimId = "menu_pim_viewPimModule";
	String menuAdminId = "menu_admin_viewAdminModule";	
	
	// Logout
	String menuWelconeId = "welcome";
		String aboutId = "aboutDisplayLink";
		String logoutXpath = "//*[@id='welcome-menu']/ul/li[2]/a";
	
}
