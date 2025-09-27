package model;

/**
 * Represents an image with a fixed width and height, using a grid of pixels.
 * Each pixel is represented by a {@link Color} object.
 */
public class Image implements IImage {
  private final int width;
  private final int height;
  private final Color[][] pixels;

  /**
   * Creates an image with the given width, height, and pixel colors.
   *
   * @param width the width of the image
   * @param height the height of the image
   * @param pixels a 2D array of {@link Color} representing the pixels in the image
   */
  public Image(int width, int height, Color[][] pixels) {
    this.width = width;
    this.height = height;
    this.pixels = pixels;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Color getPixel(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      throw new ArrayIndexOutOfBoundsException("Pixel index out of bounds: (" + x + ", " + y + ")");
    }
    return pixels[y][x]; // Assuming pixels is a 2D array of Color
  }

  @Override
  public void setPixel(int y, int x, Color color) {
    pixels[y][x] = color;
  }
}
