package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class AddUserPage extends BasePage {

  @FindBy(id = "systemUser_userType")
  private WebElement userRoleDropdown;

  @FindBy(id = "systemUser_employeeName_empName")
  private WebElement employeeInputId;

  @FindBy(id = "systemUser_userName")
  private WebElement usernameInputId;

  @FindBy(id = "systemUser_status")
  private WebElement statusDropdownId;

  @FindBy(id = "systemUser_password")
  private WebElement passwordInputId;

  @FindBy(id = "systemUser_confirmPassword")
  private WebElement confirmPasswordInputId;

  @FindBy(id = "btnSave")
  private WebElement saveButtonId;

  @FindBy(xpath = "//form[@id='frmSystemUser']/fieldset/ol/li[2]/span")
  private WebElement employeeNameMessage;
  @FindBy(xpath = "//form[@id='frmSystemUser']/fieldset/ol/li[3]/span")
  private WebElement usernameMessage;

  public AddUserPage() {
    super();
  }

  public AddUserPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void fillEmployeeName(String employeeName) {
    writeText(this.employeeInputId, employeeName);
  }

  public void fillUsername(String username) {
    writeText(this.usernameInputId, username);
  }

  public void fillPassword(String password) {
    writeText(this.passwordInputId, password);
  }

  public void fillConfirmPassword(String confirmPassword) {
    writeText(this.confirmPasswordInputId, confirmPassword);
  }

  public void selectUserRole(String userRole) {
    selectElement(this.userRoleDropdown).selectByVisibleText(userRole);
  }

  public void selectStatus(String status) {
    selectElement(this.statusDropdownId).selectByVisibleText(status);
  }

  public void clickSave() {
    click(this.saveButtonId);
  }

  public boolean verifyEmployeeInvalid() {
	  return readText(this.employeeNameMessage).equalsIgnoreCase("invalid");
  }

  public boolean verifyUsernameInvalid() {
	  return readText(this.usernameMessage).equalsIgnoreCase("invalid");
  }
}