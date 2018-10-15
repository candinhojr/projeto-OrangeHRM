package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage extends BasePage {

  private String userRoleDropdown = "systemUser_userType";
  private String employeeInputId = "systemUser_employeeName_empName";
  private String usernameInputId = "systemUser_userName";
  private String statusDropdownId = "systemUser_status";
  private String passwordInputId = "systemUser_password";
  private String confirmPasswordInputId = "systemUser_confirmPassword";
  private String saveButtonId = "btnSave";

  private String employeeNameMessage = "//form[@id='frmSystemUser']/fieldset/ol/li[2]/span";
  private String usernameMessage = "//form[@id='frmSystemUser']/fieldset/ol/li[3]/span";

  public AddUserPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void fillEmployeeName(String employeeName) {
    writeText(By.id(this.employeeInputId), employeeName);
  }

  public void fillUsername(String username) {
    writeText(By.id(this.usernameInputId), username);
  }

  public void fillPassword(String password) {
    writeText(By.id(this.passwordInputId), password);
  }

  public void fillConfirmPassword(String confirmPassword) {
    writeText(By.id(this.confirmPasswordInputId), confirmPassword);
  }

  public void selectUserRole(String userRole) {
    selectElement(By.id(this.userRoleDropdown)).selectByVisibleText(userRole);
  }

  public void selectStatus(String status) {
    selectElement(By.id(this.statusDropdownId)).selectByVisibleText(status);
  }

  public void clickSave() {
    click(By.id(this.saveButtonId));
  }

  public boolean verifyEmployeeInvalid() {
    return readText(By.xpath(this.employeeNameMessage)).equalsIgnoreCase("invalid");
  }

  public boolean verifyUsernameInvalid() {
    return readText(By.xpath(this.usernameMessage)).equalsIgnoreCase("should have at least 5 characters");
  }
}