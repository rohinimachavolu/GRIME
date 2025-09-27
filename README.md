# GRIME: Graphical Image Manipulation and Enhancement

## Overview
**GRIME** is a powerful image manipulation tool developed using the Model-View-Controller (MVC) architecture. It provides both a command-line interface (CLI) and a graphical user interface (GUI) for performing advanced image processing tasks. GRIME supports loading, editing, and saving images in various formats (PPM, JPG, PNG), with features ranging from basic transformations to complex adjustments and effects.

---

## Features
### Core Features
- **Image Formats**: Load and save images in PPM, JPG, and PNG formats.
- **Basic Operations**:
  - Brighten/Darken images.
  - Flip images vertically or horizontally.
- **Color Transformations**:
  - Grayscale conversion.
  - Sepia tone effect.
- **Filters**:
  - Blur and sharpen images.
- **Component Visualization**:
  - Visualize red, green, and blue components of an image.

### Advanced Features
- **Image Compression Visualization**: Explore the impact of compression using a Haar Wavelet Transform.
- **Color Correction**: Fine-tune colors for more accurate representation.
- **Level Adjustment**: Adjust black, mid, and white levels for contrast control.
- **Split View**: Preview before-and-after effects with an adjustable split line.
- **Real-Time Histogram**: Display color intensity distribution with optional grid patterns.
- **Batch Processing**: Execute commands from script files.
- **Interactive GUI**:
  - Image preview with scrolling.
  - On-screen operation buttons for all manipulations.

---

## Quick Start

### Command-Line Interface (CLI)
Run individual commands interactively:
```bash
java -jar GRIME.jar -text
Execute a script file:
java -jar GRIME.jar -file path/to/script.txt
Graphical User Interface (GUI)
Launch the GUI:
java -jar GRIME.jar
project-root/
├── src/
│   ├── controller/               # Handles command processing and coordination
│   │   ├── AbstractManipulatorController.java
│   │   ├── ImageManipulatorController.java
│   │   ├── GUIController.java
│   │   ├── GUIControllerInterface.java
│   │   └── ManipulatorController.java
│   │
│   ├── model/                    # Core logic and image manipulation
│   │   ├── Color.java
│   │   ├── IImage.java
│   │   ├── Image.java
│   │   ├── ManipulatorModel.java
│   │   └── ImageManipulatorModel.java
│   │
│   ├── view/                     # User interface components (CLI and GUI)
│   │   ├── ControlPanel.java
│   │   ├── FileOperationsPanel.java
│   │   ├── HistogramPanel.java
│   │   ├── ImageManipulatorView.java
│   │   ├── ImagePanel.java
│   │   ├── ImageProcessorGUI.java
│   │   └── ManipulatorView.java
│   │
│   └── Main.java                 # Entry point for the application
│
├── test/                         # Unit tests for the application
│   ├── ImageManipulatorControllerTest.java
│   └── ImageManipulatorModelTest.java
│
├── res/                          # Resources like external files
│   └── GRIME.jar
│
├── images/                       # Sample images for testing
├── README.md                     # Project documentation
└── USEME.md                      # Project usage guide

Packages and Components
Model (src/model)
This component handles the core image manipulation logic.

Image: Represents image data.
Pixel: Represents individual pixels of the image.
IImage: Interface defining image operations.
ManipulatorModel: Interface defining operations for manipulating images (e.g., filters, resizing).
ImageManipulatorModel: Implements the ManipulatorModel interface, containing logic for various image operations like Red Component, Blur, Sepia, etc.
View (src/view)
This component manages user interaction and display.

ControlPanel: UI for controlling image manipulation operations.
FileOperationsPanel: UI for loading and saving images.
HistogramPanel: Displays the histogram of the image.
ImageManipulatorView: Interface for CLI-based image manipulation.
ImagePanel: Panel for displaying the image.
ImageProcessorGUI: Main graphical user interface (GUI) for image processing.
ManipulatorView: Interface for CLI-based views.
Controller (src/controller)
This component processes commands and coordinates between the model and view.

AbstractManipulatorController: Base class for all controllers.
ImageManipulatorController: Handles CLI-based operations.
GUIController: Manages GUI interactions.
GUIControllerInterface: Interface defining methods for GUI controllers.
ManipulatorController: Main controller for image manipulations, coordinating between model and view layers.
Main Application (Main.java)
The entry point for the application. Initializes and launches the appropriate controller and view based on user input (CLI or GUI).


Key Classes:

ImageController: Handles CLI-based operations.
GUIController: Manages GUI interactions.
Main Application (Main.java)
The entry point for the application. Initializes MVC components based on command-line arguments.

Key GUI Features

Image Preview: Interactive scrolling for large images.
Real-Time Histogram: Dynamic color intensity distribution.
Split View: Adjustable split to compare original and processed images.
Operation Buttons: Quick access to all supported manipulations.
File Menu: Load and save images easily.
Input Fields: Specify compression factors and level adjustments.
Command-Line Arguments

java -jar GRIME.jar -file <path-of-script-file>: Execute a script file.
java -jar GRIME.jar -text: Launch interactive text mode.
java -jar GRIME.jar: Launch the graphical user interface.
Invalid arguments will result in an error message and program termination.
Testing

Comprehensive unit tests cover both the model and controller components. These tests ensure:

Accuracy of image manipulations.
Proper processing of commands.
Image Attribution

Sample images used for testing are original photos or provided as part of the assignment starter code.

Note on Extra Credit

The following additional features were implemented as part of the project’s extra credit:

Image Downscaling: Available in the GUI with support for maintaining or changing the aspect ratio.
The two downscaled images can be found in result folder along with original duck image
Design Changes

Added a new GUIView class for managing the graphical interface.
Introduced a GUIController to handle GUI-specific logic.
Extended the ImageModel interface to support advanced operations like:
Compression visualization.
Color correction.
Real-time histogram generation.
## Changes Made

### **Main Method Adjustments**

The **`Main.java`** method was updated to accommodate handling user input in three distinct ways:

1. **Script Mode**: 
   - Command: `java -jar Program.jar -file path-of-script-file`
   - When invoked in this manner, the program will open the script file, execute its commands, and then shut down. This allows users to run a batch of commands stored in a file.

2. **Interactive Mode**: 
   - Command: `java -jar Program.jar -text`
   - In this mode, the program opens in an interactive text mode, allowing users to type commands one by one and execute them. This is how the program worked in previous iterations.

3. **GUI Mode**: 
   - Command: `java -jar Program.jar`
   - When invoked this way, the program opens the graphical user interface (GUI), providing a user-friendly interface to manipulate images.

Any command-line arguments outside of these three options are considered invalid. In such cases, the program will display an error message and terminate.

### **Reason for Changes**
- The changes were made to provide flexibility in how users can interact with the program, allowing them to run commands from a script, interactively via the command line, or through a graphical interface.
- The program was updated to handle these three modes of operation based on command-line arguments, improving the usability and accessibility of the application.

### **Refactor to Interfaces**
- Wherever concrete classes were previously used, these have been changed to interfaces to allow for greater flexibility and extendibility.
- This refactor ensures that various components (like controllers and views) can now be easily mocked for testing or extended in the future without directly modifying the underlying code.

### **Controller Changes**
- The controller has been restructured with the following changes:
  - **Abstract Class** for Image Load and Save: The logic for loading and saving images has been abstracted into an abstract class, which can be inherited and customized for different image formats.
  - **Image I/O Operations Shifted to Controller**: Previously, image I/O operations were in the model. They have now been moved to the controller to better separate concerns. This ensures that the model is not responsible for file I/O operations, which should be managed by the controller.
  - **New GUIController Class**: This class has been introduced to handle all GUI-related operations, separating it from the rest of the logic in the controller.
  - **GUIController Interface**: An interface was created to define the contract for any class that handles GUI operations, ensuring consistency and flexibility.

### **View Changes**
- The following components were updated in the view to improve the user interface:
  - **ControlPanel**: Handles the main controls for image manipulation.
  - **FileOperationsPanel**: Manages file operations like loading and saving images.
  - **HistogramPanel**: Displays the histogram of the image.
  - **ImagePanel**: Displays the manipulated image.
  - **ImageProcessorGUI**: The main GUI class that integrates all panels and handles user interactions.
  
These changes have improved the modularity of the application and made it easier to extend and maintain the user interface.

---

Known Limitations

The Split View feature may experience slight performance issues with very large images.
Extremely high compression factors may result in increased processing time.



## Image Citation
- **`duck.jpg, duck.ppm`**: The image used in this project (duck.jpg) is an original photograph taken by Shrivarshini Narayanan at Fenway Park. I am the owner of this image and authorize its use in this project.
- **Other images**: `manhattan-small.png`, `manhattan-small-sharper.png`, `manhattan-small-sepia.png`, and `manhattan-small-blur.png` were provided as part of the starter code.

