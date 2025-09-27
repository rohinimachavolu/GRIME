package view;

/**
 * This interface defines the methods for a view that displays
 * image manipulation options and interacts with the user.
 */
public interface ManipulatorView {

  /**
   * Displays the menu options to the user.
   */
  void displayMenu();

  /**
   * Gets input from the user.
   *
   * @return The user's input as a String.
   */
  String getUserInput();

  /**
   * Shows a message to the user.
   *
   * @param message The message to display.
   */
  void showMessage(String message);

  /**
   * Displays an error message to the user.
   *
   * @param errorMessage The error message to display.
   */
  void showError(String errorMessage);
}
