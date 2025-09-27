package view;

import java.util.Scanner;

/**
 * This class represents the view for the Image Manipulator.
 * It handles user input and displays information about available commands.
 */
public class ImageManipulatorView implements ManipulatorView {
  private final Scanner scanner;

  /**
   * Constructs an ImageManipulatorView object.
   * Initializes the scanner to read user input from the console.
   */
  public ImageManipulatorView() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Displays the menu of available commands to the user.
   * It shows what actions can be performed on images.
   */
  @Override
  public void displayMenu() {
    System.out.println("Welcome to the Image Editor. Enter commands to manipulate images.");
    System.out.println("Commands available: ");
    System.out.println("1. load [filepath] [imagename] - "
            + "Load an image from the given file (supports PPM, PNG, JPG)");
    System.out.println("2. save [filepath] [imagename] - "
            + "Save an image to the given file (supports PPM, PNG, JPG)");
    System.out.println("3. red-component [imagename] [newImageName] - "
            + "Create a red-filtered image");
    System.out.println("4. blue-component [imagename] [newImageName] - "
            + "Create a blue-filtered image");
    System.out.println("5. green-component [imagename] [newImageName] - "
            + "Create a green-filtered image");
    System.out.println("6. value-component [imagename] [newImageName] - "
            + "Create a value-filtered image");
    System.out.println("7. intensity-component [imagename] [newImageName] - "
            + "Create an intensity-filtered image");
    System.out.println("8. luma-component [imagename] [newImageName] [splitPercentage] - "
            + "Create a luma-filtered image, optionally specifying a split percentage " +
            "(0-100) to apply the filter to a portion of the image");
    System.out.println("9. rgb-split [imagename] [destImageNameRed] [destImageNameGreen] "
            + "[destImageNameBlue] - Split an image into red, green, and blue components");
    System.out.println("10. rgb-combine [imageName] [redImage] [greenImage] "
            + "[blueImage] - Combine red, green, and blue images into a single image");
    System.out.println("11. horizontal-flip [imagename] [newImageName] - "
            + "Flip the image horizontally");
    System.out.println("12. vertical-flip [imagename] [newImageName] - "
            + "Flip the image vertically");
    System.out.println("13. brighten [increment] [imagename] [newImageName] - "
            + "Brighten the image");
    System.out.println("14. blur [imagename] [newImageName] [splitPercentage] - "
            + "Blur the image (optional: specify split percentage 0-100)");
    System.out.println("16. sharpen [imagename] [newImageName] [splitPercentage] - "
            + "Create a sharpen-toned image (optional: specify split percentage 0-100)");
    System.out.println("16. sepia [imagename] [newImageName] [splitPercentage] - " +
            "Create a sepia-toned image (optional: specify split percentage 0-100)");
    System.out.println("17. histogram [imagename] [destImageName] - " +
            "Create a histogram image of the given image");
    System.out.println("18. color-correct [image-name] [dest-image-name] [split-percentage] - " +
            "Apply color correction by aligning histogram peaks. Split percentage " +
            "(0-100) is optional.");
    System.out.println("19. levels-adjust [image-name] [dest-image-name] [b] [m] [w] " +
            "[split-percentage] - " +
            "Adjust the levels of the image with specified black (b), mid (m), " +
            "and white (w) points. " +
            "Split percentage (0-100) is optional.");
    System.out.println("20. compress [percentage] [imagename] [newImageName] - " +
            "Compress the image by the specified percentage");
    System.out.println("21. run [scriptFilePath] - " +
            "Execute commands from a script file (all images saved in 'result' folder)");
    System.out.println("22. exit - Quit the program");
    System.out.println("---------------------------------------------------");
  }

  /**
   * Gets input from the user.
   * Prompts the user to enter a command and returns the command as a string.
   *
   * @return the command entered by the user
   */
  @Override
  public String getUserInput() {
    System.out.print("Enter command: ");
    return scanner.nextLine();
  }

  /**
   * Displays a message to the user.
   *
   * @param message the message to display
   */
  @Override
  public void showMessage(String message) {
    System.out.println(message);
  }

  /**
   * Displays an error message to the user.
   *
   * @param errorMessage the error message to display
   */
  @Override
  public void showError(String errorMessage) {
    System.out.println("Error: " + errorMessage);
  }
}
