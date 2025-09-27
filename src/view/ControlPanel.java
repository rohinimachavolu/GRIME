package view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.GUIControllerInterface;

/**
 * The {@code ControlPanel} class represents a graphical user interface (GUI) panel that provides
 * various controls for image manipulation. It communicates with a {@link GUIControllerInterface}
 * to apply transformations, adjustments, and other operations to images.
 */
public class ControlPanel extends JPanel {
  private final GUIControllerInterface controller;
  private boolean isSplitViewMode = false;

  /**
   * Constructs a {@code ControlPanel} with the specified controller.
   *
   * @param controller the controller that manages image operations
   */
  public ControlPanel(GUIControllerInterface controller) {
    this.controller = controller;
    setLayout(new GridLayout(0, 3, 5, 5));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    addButton("Revert", e -> controller.redoOriginalImage());
    addButton("Red Component", e -> {
      controller.applyRedComponent();
      controller.resetSplitView();
    });

    addButton("Blue Component", e -> controller.applyBlueComponent());
    addButton("Green Component", e -> controller.applyGreenComponent());
    addButton("Luma Component", e -> controller.applyLuma());
    addButton("Blur", e -> controller.applyBlur());
    addButton("Sharpen", e -> controller.applySharpen());
    addButton("Sepia", e -> controller.applySepia());
    addButton("Brighten", e -> {
      String input = JOptionPane.showInputDialog("Enter brightness increment:");
      if (input != null) {
        try {
          int increment = Integer.parseInt(input);
          controller.applyBrighten(increment);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
      }
    });
    //addButton("Create Histogram", e -> controller.createHistogram());
    addButton("Adjust Levels", e -> controller.adjustLevels());
    addButton("Color Correction", e -> controller.applyColorCorrection());
    addButton("Downscale Image", e -> controller.downscaleImage());
    addButton("Horizontal Flip", e -> controller.applyHorizontalFlip());
    addButton("Vertical Flip", e -> controller.applyVerticalFlip());
    addButton("Compress", e -> {
      String input = JOptionPane.showInputDialog("Enter compression percentage (0-100):");
      if (input != null) {
        try {
          int percentage = Integer.parseInt(input);
          if (percentage >= 0 && percentage <= 100) {
            controller.applyCompression(percentage);
          } else {
            JOptionPane.showMessageDialog(this, "Invalid input. " +
                    "Please enter a number between 0 and 100.");
          }
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Invalid input. " +
                  "Please enter a valid number.");
        }
      }
    });
    addButton("Split View", e -> showSplitViewDialog());
  }

  /**
   * Adds a button to the panel with the specified text and action listener.
   *
   * @param text     the text to display on the button
   * @param listener the action listener to handle button clicks
   */
  private void addButton(String text, java.awt.event.ActionListener listener) {
    JButton button = new JButton(text);
    button.addActionListener(listener);
    add(button);
  }

  /**
   * Displays a dialog for configuring split view mode, allowing the user to select an operation
   * and specify a split percentage.
   */
  private void showSplitViewDialog() {
    String[] options = {"Blur", "Sharpen", "Sepia", "Luma", "Color Correction", "Adjust Levels"};
    JComboBox<String> operationCombo = new JComboBox<>(options);
    JTextField percentageField = new JTextField(5);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Select operation:"));
    panel.add(operationCombo);
    panel.add(new JLabel("Enter split percentage (0-100):"));
    panel.add(percentageField);

    int result = JOptionPane.showConfirmDialog(null, panel, "Split View",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
      String selectedOperation = (String) operationCombo.getSelectedItem();
      try {
        double splitPercentage = Double.parseDouble(percentageField.getText());
        if (splitPercentage < 0 || splitPercentage > 100) {
          throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        controller.applySplitView(selectedOperation, splitPercentage);
      } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Invalid input. " +
                "Please enter a number between 0 and 100.");
      }
    }
  }

  /**
   * Checks if split view mode is enabled.
   *
   * @return {@code true} if split view mode is enabled, {@code false} otherwise
   */
  public boolean isSplitViewMode() {
    return isSplitViewMode;
  }

  /**
   * Sets the state of split view mode.
   *
   * @param splitViewMode {@code true} to enable split view mode, {@code false} to disable it
   */
  public void setSplitViewMode(boolean splitViewMode) {
    isSplitViewMode = splitViewMode;
  }
}