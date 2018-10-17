package tests.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import pages.user.AddUserPage;
import tests.BaseTest;
import utils.Success;

public class AddUsersTest extends BaseTest {

  private AddUserPage addUserPage;

  @Before
  public void setUp() throws Exception {
    super.setUp();

    this.addUserPage = PageFactory.initElements(driver, AddUserPage.class);

    this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewSystemUsers().goToAddUserPage();
  }

  @After
  public void after() throws Exception {
    this.home.logOut();
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

  @Category(Success.class)
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
