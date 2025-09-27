package model;

/**
 * Interface for performing various image manipulation operations.
 * This includes loading, saving, and applying different filters or transformations
 * to images.
 */
public interface ManipulatorModel {

  /**
   * Returns a new image that shows only the red color component.
   *
   * @param image the original image.
   * @return the red-component Image.
   */
  IImage redComponent(IImage image);

  /**
   * Returns a new image that shows only the green color component.
   *
   * @param image the original image.
   * @return the green-component Image.
   */
  IImage greenComponent(IImage image);

  /**
   * Returns a new image that shows only the blue color component.
   *
   * @param image the original image.
   * @return the blue-component Image.
   */
  IImage blueComponent(IImage image);

  /**
   * Returns a new image that shows the value component,
   * which is the maximum of the red, green, and blue values.
   *
   * @param image the original image.
   * @return the value-component Image.
   */
  IImage valueComponent(IImage image);

  /**
   * Returns a new image that shows the intensity component,
   * which is the average of the red, green, and blue values.
   *
   * @param image the original image.
   * @return the intensity-component Image.
   */
  IImage intensityComponent(IImage image);

  /**
   * Returns a new image that shows the luma component,
   * which is a weighted sum of the red, green, and blue values.
   *
   * @param image the original image.
   * @return the luma-component Image.
   */
  IImage lumaComponent(IImage image, Double splitPercentage);

  /**
   * Combines three images (red, green, and blue components) into one RGB image.
   *
   * @param redImage the image containing red components.
   * @param greenImage the image containing green components.
   * @param blueImage the image containing blue components.
   * @return the combined RGB Image.
   * @throws IllegalArgumentException if the images do not have the same dimensions.
   */
  IImage combineRGB(IImage redImage, IImage greenImage, IImage blueImage);

  /**
   * Flips the image horizontally, creating a mirrored image from left to right.
   *
   * @param image the original image.
   * @return the horizontally flipped Image.
   */
  IImage horizontalFlip(IImage image);

  /**
   * downscale the image into required width and height.
   */
  IImage downscale(IImage image, int targetWidth, int targetHeight);

  /**
   * Flips the image vertically, creating a mirrored image from top to bottom.
   *
   * @param image the original image.
   * @return the vertically flipped Image.
   */
  IImage verticalFlip(IImage image);

  /**
   * Brightens the image by a given amount. A positive increment makes the image brighter,
   * and a negative increment makes it darker.
   *
   * @param image the original image.
   * @param increment the amount to increase or decrease the brightness.
   * @return the brightened Image.
   */
  IImage brighten(IImage image, int increment);

  /**
   * Applies a Gaussian blur effect to the image, making it appear smoother.
   *
   * @param image the original image.
   * @return the blurred Image.
   */
  IImage blur(IImage image, Double splitPercentage);

  /**
   * Applies a sepia tone to the image, giving it a warm, brownish look.
   *
   * @param image the original image.
   * @return the sepia-toned Image.
   */
  IImage sepia(IImage image, Double splitPercentage);

  /**
   * Sharpens the image, enhancing its details and edges.
   *
   * @param image the original image.
   * @return the sharpened Image.
   */
  IImage sharpen(IImage image, Double splitPercentage);

  /**
   * Generates a histogram image for the given original image, rotated 90 degrees to the left.
   * The histogram displays pixel distributions for red, green, and blue color channels,
   * with color intensity values on the y-axis and pixel counts on the x-axis.
   *
   * @param original the original image for which the histogram is created
   * @return a new {@code Image} object representing the histogram of the original image
   */
  IImage createHistogram(IImage original);

  /**
   * Adjusts the color balance of an image by aligning the peak positions of the red, green,
   * and blue
   * color channels to a common average peak. This color correction process helps to neutralize
   * color
   * tints by normalizing each channel's intensity, creating a balanced and visually accurate image.
   *
   * <p>The method operates by:
   * <ul>
   *   <li>Calculating histograms for the red, green, and blue channels</li>
   *   <li>Determining the peak (mode) of each channel's histogram, excluding extreme values</li>
   *   <li>Finding the average of these peaks and calculating the adjustments needed to align each
   *       channel's peak with this average</li>
   *   <li>Applying these adjustments to each pixel, ensuring values remain within the 0-255 range
   *   </li>
   * </ul>
   *
   * @param image the original image to be color-corrected
   * @return a new {@code Image} instance with adjusted color channels
   */
  IImage colorCorrect(IImage image, double splitPercentage);

  /**
   * Adjusts the tonal levels of an image by remapping pixel values based on the provided black,
   * midtone,
   * and white points. This process modifies the brightness and contrast by mapping the specified
   * black, midtone, and white points to new ranges, making dark areas darker, light areas lighter,
   * and adjusting midtones accordingly.
   *
   * <p>The method operates by:
   * <ul>
   *   <li>Iterating over each pixel in the image</li>
   *   <li>Applying a level adjustment to each color channel using the helper method</li>
   *   <li>Returning a new image with the adjusted pixel values</li>
   * </ul>
   *
   * @param image the original image to be level-adjusted
   * @param b the black point, defining the darkest levels in the image
   * @param m the midtone point, defining the mid-range levels
   * @param w the white point, defining the brightest levels in the image
   * @return a new {@code Image} instance with adjusted tonal levels
   */
  IImage levelsAdjust(IImage image, int b, int m, int w, double splitPercentage);

  /**
   * Compresses the given image by reducing its quality based on the specified
   * compression percentage.
   * The compression is achieved by converting the image to a BufferedImage, applying the specified
   * compression quality, and converting it back to an IImage object.
   *
   * @param image The original IImage object to be compressed.
   * @param compressionPercentage The percentage of compression to apply (0-100).
   *                              A higher value results in greater compression and
   *                              lower image quality.
   * @return A new IImage object representing the compressed version of the original image.
   *         If an error occurs during compression, the original image is returned.
   * @throws NullPointerException if the provided image is null.
   */
  IImage compressImage(IImage image, int compressionPercentage);
}
