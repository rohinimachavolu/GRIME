package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.GUIControllerInterface;
import model.IImage;
import model.Image;




/**
 * A graphical user interface for the Image Processor application.
 * Provides functionality to load, process, and save images with a user-friendly interface.
 */
public class ImageProcessorGUI extends JFrame {
  private final ImagePanel imagePanel;
  private final HistogramPanel histogramPanel;
  private final GUIControllerInterface controller;
  private IImage previewImage;

  /**
   * Constructs an ImageProcessorGUI object with the given controller.
   *
   * @param controller the controller to handle user interactions.
   */
  public ImageProcessorGUI(GUIControllerInterface controller) {
    this.controller = controller;
    setTitle("Image Processor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Initialize components
    imagePanel = new ImagePanel();
    histogramPanel = new HistogramPanel();
    ControlPanel controlPanel = new ControlPanel(controller);
    FileOperationsPanel fileOperationsPanel = new FileOperationsPanel(controller);

    // Create a panel for the right side (histogram and file operations)
    JPanel rightPanel = new JPanel(new BorderLayout());
    rightPanel.add(histogramPanel, BorderLayout.CENTER);
    rightPanel.add(fileOperationsPanel, BorderLayout.SOUTH);

    // Add components to the frame
    add(new JScrollPane(imagePanel), BorderLayout.CENTER);
    add(rightPanel, BorderLayout.EAST);
    add(controlPanel, BorderLayout.SOUTH);

    // Create menu bar
    setJMenuBar(createMenuBar());

    pack();
    setLocationRelativeTo(null); // Center the frame
  }

  /**
   * Creates the menu bar with file, edit, and help menus.
   *
   * @return the created JMenuBar.
   */
  private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenuItem loadItem = new JMenuItem("Load Image");
    JMenuItem saveItem = new JMenuItem("Save Image");
    JMenuItem exitItem = new JMenuItem("Exit");

    loadItem.addActionListener(e -> controller.loadImage());
    saveItem.addActionListener(e -> controller.saveImage());
    exitItem.addActionListener(e -> System.exit(0));

    fileMenu.add(loadItem);
    fileMenu.add(saveItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);

    JMenu editMenu = new JMenu("Edit");
    // Add edit menu items here

    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Image Processor v1.0", "About", JOptionPane.INFORMATION_MESSAGE));
    helpMenu.add(aboutItem);

    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }

  /**
   * Displays an information message to the user.
   *
   * @param message the message to display.
   */
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Information",
            JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Displays an error message to the user.
   *
   * @param message the error message to display.
   */
  public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error",
            JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Displays a histogram of the provided image.
   *
   * @param histogramImage the image used to generate the histogram.
   */
  public void showHistogram(IImage histogramImage) {
    histogramPanel.setHistogramImage((Image) histogramImage);
  }

  /**
   * Resets the split view by clearing any preview images.
   */
  public void resetSplitView() {
    imagePanel.clearPreview();
    repaint();
  }

  /**
   * Applies the current preview image to the main panel.
   */
  public void applyPreview() {
    if (previewImage != null) {
      updateImage(previewImage);
      previewImage = null;
      imagePanel.clearPreview();
    }
  }

  /**
   * Sets a preview image to be displayed with a specific operation and split percentage.
   *
   * @param previewImage the preview image to display.
   * @param operation the operation name applied to the preview.
   * @param splitPercentage the percentage of the image to show in the preview.
   */
  public void setPreviewImage(Image previewImage, String operation, double splitPercentage) {
    imagePanel.setPreviewImage(previewImage, splitPercentage);
    repaint();
  }

  /**
   * Updates the displayed image in the main panel.
   * Also updates the histogram for the provided image.
   *
   * @param image the image to update in the display.
   */
  public void updateImage(IImage image) {
    imagePanel.setImage((Image) image);
    histogramPanel.updateHistogram((Image) image);
    repaint();
  }
}
