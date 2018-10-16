package tests.user;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.user.AddUserPage;
import tests.BaseTest;

public class AddUsersTest extends BaseTest {

  private AddUserPage addUserPage;

  @Before
  public void setUp() throws Exception {
    super.setUp();

    this.addUserPage = PageFactory.initElements(driver, AddUserPage.class);

    this.addUserPage.goToAddUserPage();
    
    // this.getHomePage().loginToOrangeHRM("Admin", "admin123").goToViewSystemUsers().goToAddUserPage();
  }

  @After
  public void after() throws Exception {
    driver.quit();
  }

  @Test
  public void invalidTest_InvalidEmployeeName() {
    this.addUserPage.fillEmployeeName("adwad");

    this.addUserPage.clickSave();

    // assertTrue(this.addUserPage.verifyEmployeeInvalid());
  }

  @Test
  public void invalidTest_InvalidUsername() {
    this.addUserPage.fillUsername("awd");

    this.addUserPage.clickSave();

    // assertTrue(this.addUserPage.get());
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
