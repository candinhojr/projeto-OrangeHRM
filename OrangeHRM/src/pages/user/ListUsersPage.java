package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ListUsersPage extends BasePage {

  @FindBy(id = "btnAdd")
  private WebElement addUserBtnId;

  @FindBy(css = ".message")
  private WebElement message;


  public ListUsersPage() {
    super();
  }

  public ListUsersPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void goToAddUserPage() {
    click(this.addUserBtnId);
  }

  public boolean isSuccessMessagePresent() {
    ExpectedConditions.visibilityOf(message);

    return this.message.getText().contains("Successfully Saved");
  }
}