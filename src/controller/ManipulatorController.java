package controller;

import java.io.IOException;


/**
 * This interface defines how to control an image manipulation program.
 * It includes methods to load, save, and change images.
 */
public interface ManipulatorController {

  /**
   * Starts the program for editing images. It shows a menu and handles what the user wants to do.
   */
  void start();

  /**
   * Processes a command entered by the user.
   *
   * @param command the command to process
   * @throws IOException if an error occurs while processing the command
   */
  public void processCommand(String command) throws IOException;
}
