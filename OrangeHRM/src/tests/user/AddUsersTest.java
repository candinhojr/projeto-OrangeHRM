package tests.user;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import domain.User;
import pages.user.AddUserPage;
import pages.user.ListUsersPage;
import tests.BaseTest;
import utils.OthersTests;
import utils.Success;

public class AddUsersTest extends BaseTest {

  private AddUserPage addUserPage;

  private ListUsersPage listUserPage;

  @Before
  public void setUp() throws Exception {
    super.setUp();

    this.addUserPage = PageFactory.initElements(driver, AddUserPage.class);

    this.listUserPage = PageFactory.initElements(driver, ListUsersPage.class);

    this.home.goToLoginPage().loginToOrangeHRM("Admin", "admin123").goToViewSystemUsers().goToAddUserPage();
  }

  @After
  public void after() throws Exception {
    this.home.logOut();
  }

  @Category({OthersTests.class})
  @Test
  public void invalidTest_InvalidEmployeeName() {
    this.addUserPage.fillEmployeeName("adwad");

    this.addUserPage.clickSave();

     assertTrue(this.addUserPage.verifyEmployeeInvalid());
  }

  @Category({OthersTests.class})
  @Test
  public void invalidTest_InvalidUsername() {
    this.addUserPage.fillUsername("awd");

    this.addUserPage.clickSave();

     assertTrue(this.addUserPage.verifyUsernameInvalid());
  }

  @Category({Success.class})
  @Test
  public void successTest_addUser() {
    User user = new User();

    this.addUserPage.createUser(user);

    this.addUserPage.clickSave();

    assertTrue(this.listUserPage.isSuccessMessagePresent());
  }

}
