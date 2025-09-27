
import controller.GUIController;
import controller.ImageManipulatorController;
import controller.ManipulatorController;
import view.ImageManipulatorView;
import view.ManipulatorView;

/**
 * The main entry point for the Image Manipulator application.
 * This class handles the initialization of the application based on command-line arguments:
 * - Launching the GUI
 * - Executing a script file
 * - Starting interactive text mode
 */
public class ImageManipulatorMain {

  /**
   * The main method that processes the command-line arguments and launches the appropriate mode.
   * It can launch the GUI, execute a script file, or start an interactive text
   * mode based on the arguments passed.
   */
  public static void main(String[] args) {

    if (args.length == 0) {

      // No arguments: Launch GUI

      launchGUI();

    } else if (args.length == 2 && args[0].equalsIgnoreCase("-file")) {

      // Script file mode

      executeScriptFile(args[1]);

    } else if (args.length == 1 && args[0].equalsIgnoreCase("-text")) {

      // Interactive text mode

      startInteractiveTextMode();

    } else {

      // Invalid arguments

      System.err.println("Invalid command-line arguments. Usage:");

      System.err.println("java -jar Program.jar -file <path-of-script-file>");

      System.err.println("java -jar Program.jar -text");

      System.err.println("java -jar Program.jar");

      System.exit(1);

    }

  }

  private static void launchGUI() {

    System.out.println("Launching GUI...");

    // Initialize your GUI controller and start the GUI

    ManipulatorController controller = new GUIController();

    controller.start();

  }

  private static void executeScriptFile(String scriptPath) {

    System.out.println("Executing script file: " + scriptPath);

    try {

      ManipulatorView view = new ImageManipulatorView();

      // Create a controller with the view to handle user commands
      ManipulatorController controller = new ImageManipulatorController(view);

      controller.processCommand("run " + scriptPath);

    } catch (Exception e) {

      System.err.println("Error reading or executing script file: " + e.getMessage());

      System.exit(1);

    }

  }

  private static void startInteractiveTextMode() {

    System.out.println("Starting interactive text mode...");

    ManipulatorView view = new ImageManipulatorView();

    // Create a controller with the view to handle user commands
    ManipulatorController controller = new ImageManipulatorController(view);

    // Start the image manipulation process
    controller.start();

  }
}

