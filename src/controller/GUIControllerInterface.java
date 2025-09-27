package controller;

/**
 * Interface for the controller handling graphical user interface (GUI) operations.
 * Defines methods for controlling the GUI in an image manipulation application.
 *
 * <p>Implementing classes must provide functionality for interacting with the
 * graphical interface, such as loading images, applying image manipulation operations,
 * and saving images.</p>
 */
public interface GUIControllerInterface {

  /**
   * Starts the GUI.
   */
  void start();

  /**
   * Loads an image into the application.
   */
  void loadImage();

  /**
   * Restores the original loaded image.
   */
  void redoOriginalImage();

  /**
   * Saves the current image.
   */
  void saveImage();

  /**
   * Applies the red component filter.
   */
  void applyRedComponent();

  /**
   * Applies the green component filter.
   */
  void applyGreenComponent();

  /**
   * Applies the blue component filter.
   */
  void applyBlueComponent();

  /**
   * Applies the luma component filter.
   */
  void applyLuma();

  /**
   * Applies the blur effect.
   */
  void applyBlur();

  /**
   * Applies the sharpen effect.
   */
  void applySharpen();

  /**
   * Applies the sepia tone effect.
   */
  void applySepia();

  /**
   * Adjusts the brightness of the image.
   *
   * @param increment the amount to adjust brightness
   */
  void applyBrighten(int increment);

  /**
   * Applies a vertical flip to the image.
   */
  void applyVerticalFlip();

  /**
   * Applies a horizontal flip to the image.
   */
  void applyHorizontalFlip();

  /**
   * Applies image compression.
   *
   * @param factor the compression factor
   */
  void applyCompression(int factor);

  /**
   * Creates a histogram representation of the image.
   */
  void createHistogram();

  /**
   * Adjusts the levels of the image.
   */
  void adjustLevels();

  /**
   * Resets the split view mode.
   */
  void resetSplitView();

  /**
   * Applies color correction to the image.
   */
  void applyColorCorrection();

  /**
   * Downscales the image to new dimensions.
   */
  void downscaleImage();

  /**
   * Applies an operation in split-view mode.
   *
   * @param operation       the operation to apply
   * @param splitPercentage the percentage for the split view
   */
  void applySplitView(String operation, double splitPercentage);
}
