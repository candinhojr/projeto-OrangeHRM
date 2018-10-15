package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListUsersPage extends BasePage {

  private String addUserBtnId = "btnAdd";

  public ListUsersPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void goToAddUserPage() {
    click(By.id(this.addUserBtnId));
  }
}