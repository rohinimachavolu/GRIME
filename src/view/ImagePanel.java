package view;

import model.IImage;


import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * A panel for displaying images in a graphical user interface.
 * This panel supports displaying a single main image or a split view to compare
 * a main image with a preview image.
 */
public class ImagePanel extends JPanel {
  private IImage previewImage;  // The preview image to display alongside the main image.
  private BufferedImage bufferedImage;  // The main image in BufferedImage format.
  private BufferedImage previewBufferedImage;  // The preview image in BufferedImage format.
  private double splitPercentage = 100.0;  // Percentage of the panel occupied by the main image.

  /**
   * Constructs an ImagePanel with a default preferred size of 400x400 pixels.
   */
  public ImagePanel() {
    setPreferredSize(new Dimension(400, 400));
  }

  /**
   * Sets the main image to be displayed in the panel.
   *
   * @param image the main image to display, represented as an {@code IImage}.
   */
  public void setImage(IImage image) {
    this.bufferedImage = createBufferedImage(image);
    repaint();
  }

  /**
   * Sets the preview image and specifies the split percentage for the split view.
   *
   * @param previewImage   the preview image to display.
   * @param splitPercentage the percentage of the panel to allocate to the main image.
   *                        The remaining space will show the preview image.
   */
  public void setPreviewImage(IImage previewImage, double splitPercentage) {
    this.previewImage = previewImage;
    this.previewBufferedImage = createBufferedImage(previewImage);
    this.splitPercentage = splitPercentage;
    repaint();
  }

  /**
   * Clears the preview image, returning to a single main image view.
   */
  public void clearPreview() {
    this.previewImage = null;
    this.previewBufferedImage = null;
    this.splitPercentage = 100.0;
    repaint();
  }

  /**
   * Converts an {@code IImage} into a {@code BufferedImage} for rendering.
   *
   * @param image the {@code IImage} to convert.
   * @return the converted {@code BufferedImage}, or {@code null} if the input is {@code null}.
   */
  private BufferedImage createBufferedImage(IImage image) {
    if (image == null) {
      return null;
    }
    BufferedImage buffImg = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        model.Color color = image.getPixel(x, y);
        buffImg.setRGB(x, y,
                (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue());
      }
    }
    return buffImg;
  }

  /**
   * Custom rendering logic to display the images within the panel.
   * If a preview image is set, displays a split view with the specified percentage.
   *
   * @param g the {@code Graphics} object used for drawing the component.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (bufferedImage != null) {
      int panelWidth = getWidth();
      int panelHeight = getHeight();
      int imageWidth = bufferedImage.getWidth();
      int imageHeight = bufferedImage.getHeight();

      // Calculate scaling factor to fit the image within the panel
      double scale = Math.min((double) panelWidth / imageWidth, (double) panelHeight / imageHeight);
      int scaledWidth = (int) (imageWidth * scale);
      int scaledHeight = (int) (imageHeight * scale);

      // Center the image in the panel
      int x = (panelWidth - scaledWidth) / 2;
      int y = (panelHeight - scaledHeight) / 2;

      // Draw the main image
      g.drawImage(bufferedImage, x, y, scaledWidth, scaledHeight, null);

      // Draw the preview image if it exists
      if (previewBufferedImage != null) {
        int splitX = x + (int) (scaledWidth * splitPercentage / 100.0);

        // Clip and draw the preview image
        g.setClip(x, y, splitX - x, scaledHeight);
        g.drawImage(previewBufferedImage, x, y, scaledWidth, scaledHeight, null);
        g.setClip(null);

        // Draw a red line to indicate the split
        g.setColor(Color.RED);
        g.drawLine(splitX, y, splitX, y + scaledHeight);
      }
    }
  }
}
