package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage extends BasePage {

  private String userRoleComboBoxId = "systemUser_userType";
  private String employeeInputId = "systemUser_employeeName_empName";
  private String usernameInputId = "systemUser_userName";
  private String statusComboBoxId = "systemUser_status";
  private String passwordInputId = "systemUser_password";
  private String confirmPasswordInputId = "systemUser_confirmPassword";
  private String saveButtonId = "btnSave";
  private String employeeNameMessage = "";

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
    // TODO: see a manner to switch between values on the combobox
  }
  
  public void selectStatus(String status) {
    // TODO: see a manner to switch between values on the combobox
  }

  public void clickSave() {
    click(By.id(this.saveButtonId));
  }

  public boolean verifyEmployeeRequired() {
    return readText(By.id(this.employeeNameMessage)).equalsIgnoreCase("required");
  }
}