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
  public void invalidTest_InvalidEmployeeName() {
    this.addUserPage.fillEmployeeName("adwad");

    this.addUserPage.clickSave();

    assertTrue(this.addUserPage.verifyEmployeeInvalid());
  }

  @Test
  public void invalidTest_InvalidUsername() {
    this.addUserPage.fillUsername("awd");

    this.addUserPage.clickSave();

    assertTrue(this.addUserPage.verifyUsernameInvalid());
  }

  @Test
  public void successTest_addUser() {
    this.addUserPage.fillEmployeeName("Teste 123");
    this.addUserPage.fillUsername("user_test_123");
    this.addUserPage.fillPassword("password_123");
    this.addUserPage.fillConfirmPassword("password_123");
    this.addUserPage.selectStatus("Enabled");
    this.addUserPage.selectUserRole("ESS");

    this.addUserPage.clickSave();
  }
  

}
