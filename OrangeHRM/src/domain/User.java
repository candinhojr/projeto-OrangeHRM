package domain;

import constants.domain.user.*;

public class User {

  private String username;

  private String password;

  private String employeeName;

  private UserStatus userStatus;

  private UserRoles userRoles;

  public User(String username, String password, String employeeName, UserStatus userStatus, UserRoles userRoles) {
    this.setUsername(username);
    this.setPassword(password);
    this.setEmployeeName(employeeName);
    this.setUserStatus(userStatus);
    this.setUserRoles(userRoles);
  }

  /**
   * @return the userRoles
   */
  public UserRoles getUserRoles() {
    return userRoles;
  }

  /**
   * @param userRoles the userRoles to set
   */
  public void setUserRoles(UserRoles userRoles) {
    this.userRoles = userRoles;
  }

  /**
   * @return the userStatus
   */
  public UserStatus getUserStatus() {
    return userStatus;
  }

  /**
   * @param userStatus the userStatus to set
   */
  public void setUserStatus(UserStatus userStatus) {
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