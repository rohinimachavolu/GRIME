package view;

import java.awt.FlowLayout;

import controller.GUIControllerInterface;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;


/**
 * A panel for file operations in an image manipulation application.
 * Provides buttons for loading and saving images.
 */
public class FileOperationsPanel extends JPanel {

  /**
   * Constructs a FileOperationsPanel with buttons for loading and saving images.
   *
   * @param controller it's responsible for handling user actions related to file operations.
   */
  public FileOperationsPanel(GUIControllerInterface controller) {
    setLayout(new FlowLayout(FlowLayout.LEFT));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JButton loadButton = new JButton("Load Image");
    loadButton.addActionListener(e -> controller.loadImage());

    JButton saveButton = new JButton("Save Image");
    saveButton.addActionListener(e -> controller.saveImage());

    add(loadButton);
    add(saveButton);
  }
}
