package domain;

import java.util.Random;

import constants.domain.user.*;

public class User {

  private final int NEXT_INT = new Random().nextInt(1000);

  private String username = "user_test_" + NEXT_INT;

  private String password  = "password_test_123";

  private String employeeName = "John Smith";

  private String userStatus = UserStatus.ENABLED;

  private String userRoles = UserRoles.ESS;

  public User() {}

  public User(String username, String password, String employeeName, String userStatus, String userRoles) {
    this.setUsername(username);
    this.setPassword(password);
    this.setEmployeeName(employeeName);
    this.setUserStatus(userStatus);
    this.setUserRoles(userRoles);
  }

  /**
   * @return the userRoles
   */
  public String getUserRoles() {
    return userRoles;
  }

  /**
   * @param userRoles the userRoles to set
   */
  public void setUserRoles(String userRoles) {
    this.userRoles = userRoles;
  }

  /**
   * @return the userStatus
   */
  public String getUserStatus() {
    return userStatus;
  }

  /**
   * @param userStatus the userStatus to set
   */
  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  /**
   * @return the employeeName
   */
  public String getEmployeeName() {
    return employeeName;
  }

  /**
   * @param employeeName the employeeName to set
   */
  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

}