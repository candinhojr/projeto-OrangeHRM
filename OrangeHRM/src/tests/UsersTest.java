package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MainMenuPage;

public class UsersTest extends BaseTest {

  @Test
  public void goToUsersPage() {
    // Instanciação dos pages
    HomePage homePage = new HomePage(driver, wait);
    LoginPage loginPage = new LoginPage(driver, wait);
    MainMenuPage mainMenuPage = new MainMenuPage(driver, wait);

    // Métodos do page
    homePage.goToOrangePageLogin();
    loginPage.loginToOrangeHRM("Admin", "admin123");
    mainMenuPage.goToViewSystemUsers();
  }

  @Test
  public void invalidTest_EmptyEmployeeName() {
    // Instanciação dos pages
    HomePage homePage = new HomePage(driver, wait);
    LoginPage loginPage = new LoginPage(driver, wait);
    MainMenuPage mainMenuPage = new MainMenuPage(driver, wait);

    // Métodos do page
    homePage.goToOrangePageLogin();
    loginPage.loginToOrangeHRM("Admin", "admin123");
    mainMenuPage.goToViewSystemUsers();

  }
}
