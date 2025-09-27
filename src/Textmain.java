import controller.ImageManipulatorController;
import controller.ManipulatorController;
import view.ImageManipulatorView;
import view.ManipulatorView;

/**
 * The main entry point for starting the image manipulation application.
 * This class initializes the view and controller, and starts the image manipulation process.
 */
public class Textmain {

  /**
   * The main method that initializes the view and controller and starts the
   * image manipulation process.
   *
   * @param args command-line arguments (not used in this program).
   */
  public static void main(String[] args) {
    // Create a new view for the image manipulator
    ManipulatorView view = new ImageManipulatorView();

    // Create a controller with the view to handle user commands
    ManipulatorController controller = new ImageManipulatorController(view);

    // Start the image manipulation process
    controller.start();
  }
}
