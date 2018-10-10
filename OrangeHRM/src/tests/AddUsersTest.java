package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import pages.ListUsersPage;
import pages.LoginPage;
import pages.MainMenuPage;
import pages.AddUserPage;

public class AddUsersTest extends BaseTest {

  private HomePage homePage;
  private LoginPage loginPage;
  private MainMenuPage mainMenuPage;
  private AddUserPage addUserPage;
  private ListUsersPage listUsersPage;

  @Before
  public void setUp() throws Exception {
    super.setUp();

    this.homePage = new HomePage(driver, wait);
    this.loginPage = new LoginPage(driver, wait);
    this.mainMenuPage = new MainMenuPage(driver, wait);
    this.addUserPage = new AddUserPage(driver, wait);
    this.listUsersPage = new ListUsersPage(driver, wait);
    
    this.homePage.goToOrangePageLogin();
    this.loginPage.loginToOrangeHRM("Admin", "admin123");
    this.mainMenuPage.goToViewSystemUsers();
    this.listUsersPage.goToAddUserPage();
  }

  @After
  public void after() throws Exception {
    driver.quit();
  }

  @Test
  public void invalidTest_EmptyEmployeeName() {
    this.addUserPage.fillEmployeeName("");

    this.addUserPage.clickSave();

    assertTrue(this.addUserPage.verifyEmployeeRequired());
  }
  

}
