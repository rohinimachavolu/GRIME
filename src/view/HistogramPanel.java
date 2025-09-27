package view;

import model.IImage;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

import java.awt.Color;

/**
 * A panel that displays a histogram representing the frequency of red, green, and blue
 * pixel intensities in an image. The histogram can be visualized as lines or as an image.
 */
public class HistogramPanel extends JPanel {
  private int[] redHistogram;
  private int[] greenHistogram;
  private int[] blueHistogram;
  private int maxCount;
  private IImage histogramImage;

  /**
   * Constructs a HistogramPanel with a default size and white background.
   */
  public HistogramPanel() {
    setPreferredSize(new Dimension(256, 200));
    setBackground(Color.WHITE);
  }

  /**
   * Updates the histogram data for the given image by calculating the frequency of
   * red, green, and blue pixel intensities.
   *
   * @param image the image from which the histogram is calculated
   */
  public void updateHistogram(IImage image) {
    redHistogram = new int[256];
    greenHistogram = new int[256];
    blueHistogram = new int[256];
    maxCount = 0;

    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        model.Color pixel = image.getPixel(x, y);
        redHistogram[pixel.getRed()]++;
        greenHistogram[pixel.getGreen()]++;
        blueHistogram[pixel.getBlue()]++;
        maxCount = Math.max(maxCount, Math.max(redHistogram[pixel.getRed()],
                Math.max(greenHistogram[pixel.getGreen()], blueHistogram[pixel.getBlue()])));
      }
    }
    repaint();
  }

  /**
   * Sets an image representation of the histogram for display.
   * This image will override the line-based histogram visualization when set.
   *
   * @param histogramImage the image representation of the histogram
   */
  public void setHistogramImage(IImage histogramImage) {
    this.histogramImage = histogramImage;
    repaint();
  }

  /**
   * Paints the component to display the histogram. Depending on the data, it displays
   * either the histogram as an image or as color-coded lines representing intensity frequencies.
   *
   * @param g the graphics object used for rendering
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (histogramImage != null) {
      drawHistogramImage(g);
    } else if (redHistogram != null && greenHistogram != null && blueHistogram != null) {
      drawHistogramLines(g);
    }
  }

  /**
   * Draws the histogram as an image using the pixel data in the histogram image.
   *
   * @param g the graphics object used for rendering
   */
  private void drawHistogramImage(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    for (int y = 0; y < histogramImage.getHeight(); y++) {
      for (int x = 0; x < histogramImage.getWidth(); x++) {
        model.Color color = histogramImage.getPixel(x, y);
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        g.drawLine(x, height - y - 1, x, height - y - 1);
      }
    }
  }

  /**
   * Draws the histogram as lines for red, green, and blue intensities.
   *
   * @param g the graphics object used for rendering
   */
  private void drawHistogramLines(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    double xScale = width / 256.0;
    double yScale = height / (double) maxCount;

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setStroke(new BasicStroke(2));

    drawHistogramLine(g2d, redHistogram, new Color(255, 0, 0, 128), xScale, yScale);
    drawHistogramLine(g2d, greenHistogram, new Color(0, 255, 0, 128), xScale, yScale);
    drawHistogramLine(g2d, blueHistogram, new Color(0, 0, 255, 128), xScale, yScale);
  }

  /**
   * Draws a single histogram line for a given color intensity.
   *
   * @param g2d       the graphics object used for rendering
   * @param histogram the histogram data to be drawn
   * @param color     the color of the line
   * @param xScale    the horizontal scaling factor
   * @param yScale    the vertical scaling factor
   */
  private void drawHistogramLine(Graphics2D g2d, int[] histogram, Color color,
                                 double xScale, double yScale) {
    g2d.setColor(color);
    for (int i = 0; i < histogram.length - 1; i++) {
      int x1 = (int) (i * xScale);
      int y1 = getHeight() - (int) (histogram[i] * yScale);
      int x2 = (int) ((i + 1) * xScale);
      int y2 = getHeight() - (int) (histogram[i + 1] * yScale);
      g2d.drawLine(x1, y1, x2, y2);
    }
  }
}
