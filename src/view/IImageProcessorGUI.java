package view;

import model.IImage;

/**
 * Interface for the Image Processor GUI, providing methods for
 * updating the displayed image, showing messages, and managing previews.
 */
public interface IImageProcessorGUI {

  /**
   * Displays a general information message to the user.
   *
   * @param message the message to be displayed.
   */
  void showMessage(String message);

  /**
   * Displays an error message to the user.
   *
   * @param message the error message to be displayed.
   */
  void showErrorMessage(String message);

  /**
   * Updates the displayed image in the main panel.
   *
   * @param image the updated image to display.
   */
  void updateImage(IImage image);

  /**
   * Displays a histogram based on the provided image.
   *
   * @param histogramImage the image to generate the histogram from.
   */
  void showHistogram(IImage histogramImage);

  /**
   * Resets the split view by clearing any preview images.
   */
  void resetSplitView();

  /**
   * Applies the preview image to the main panel.
   */
  void applyPreview();

  /**
   * Sets the preview image with a specific operation and split percentage.
   *
   * @param previewImage the image to preview.
   * @param operation the operation name applied to the preview.
   * @param splitPercentage the percentage of the image to show in the preview.
   */
  void setPreviewImage(IImage previewImage, String operation, double splitPercentage);
}
