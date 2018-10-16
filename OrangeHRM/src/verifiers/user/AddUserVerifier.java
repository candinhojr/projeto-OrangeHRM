package verifiers.user;

public class AddUserVerifier {
  public static boolean verifyUsernameInvalidMessage(String usernameMessage) {
    return usernameMessage.equalsIgnoreCase("should have at least 5 characters");
  }

  public static boolean verifyEmployeeInvalidMessage(String employeeMessage) {
    return employeeMessage.equalsIgnoreCase("invalid");
  }
}