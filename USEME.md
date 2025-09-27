USEME - Image Manipulator Application
# Image Manipulation Application - User Manual

## Features

The application allows you to perform various image manipulation operations using an intuitive graphical user interface (GUI).

### 1. Load an Image:
- **Step 1**: Click the **"Load Image"** button.
- **Step 2**: In the file chooser window that opens, select the image file you want to load. Supported formats include:
    - PPM
    - JPG
    - PNG
- **Step 3**: The selected image will be displayed in the main window along with its histogram.

### 2. Apply Full Image Operations:
Click on any of the following buttons to apply the selected effect to the entire image. The image and its histogram will update automatically to reflect the changes:
- **Red Component**
- **Blue Component**
- **Green Component**
- **Luma Component**
- **Blur**
- **Sharpen**
- **Sepia**
- **Brighten**
- **Adjust Levels**
- **Color Correction**
- **Downscale**
- **Horizontal Flip**
- **Vertical Flip**
- **Compress**

### 3. Use Split View:
- **Step 1**: Click the **"Split View"** button.
- **Step 2**: In the dialog that appears:
    - Select the operation you want to apply.
    - Enter the split percentage when prompted.
- **Step 3**: The image will be displayed with the selected effect applied to the specified portion.

### 4. Revert to the Original Image:
- **Step 1**: Click the **"Revert"** button to undo all changes and return to the original loaded image.

### 5. Save the Image:
- **Step 1**: Click the **"Save Image"** button.
- **Step 2**: In the file chooser window that opens:
    - Select the location where you want to save the image.
    - Enter a file name and choose the desired format (PPM, JPG, or PNG) from the dropdown menu.
- **Step 3**: Click **"Save"** to save the current state of the image in the selected format.

---

### Important Notes:
- The image and histogram are always visible in the main window.
- They update in real-time as operations are applied.
- There are no separate menus; all operations are accessible via buttons in the main interface.

### Example Images:
For assistance and reference, you can check out the example images [here](https://docs.google.com/document/d/18gHyGLRPrDppZOTFAfIzPnR5e-74J3e-2bD67dOJ0yM/edit?usp=sharing).


This document outlines the script commands supported by the Image Manipulator application, along with examples and usage conditions.

Supported Commands:

1. load [filepath] [imagename]
   Loads an image from the specified file path and assigns it a name.
   Example: load images/example.jpg myImage

2. save [filepath] [imagename]
   Saves the specified image to the given file path.
   Example: save output/result.jpg myImage

3. red-component [imagename] [newImageName]
   Creates a new image with only the red component of the specified image.
   Example: red-component myImage redImage

4. green-component [imagename] [newImageName]
   Creates a new image with only the green component of the specified image.
   Example: green-component myImage greenImage

5. blue-component [imagename] [newImageName]
   Creates a new image with only the blue component of the specified image.
   Example: blue-component myImage blueImage

6. value-component [imagename] [newImageName]
   Creates a new image based on the value component of the specified image.
   Example: value-component myImage valueImage

7. intensity-component [imagename] [newImageName]
   Creates a new image based on the intensity component of the specified image.
   Example: intensity-component myImage intensityImage

8. luma-component [imagename] [newImageName] [splitPercentage]
   Creates a new image based on the luma component of the specified image.
   The split percentage is optional and applies the effect partially if specified.
   Example: luma-component myImage lumaImage 50

9. horizontal-flip [imagename] [newImageName]
   Flips the specified image horizontally.
   Example: horizontal-flip myImage flippedImage

10. vertical-flip [imagename] [newImageName]
    Flips the specified image vertically.
    Example: vertical-flip myImage flippedImage

11. brighten [increment] [imagename] [newImageName]
    Brightens the specified image by the given increment.
    Example: brighten 50 myImage brightenedImage

12. rgb-split [imagename] [redImageName] [greenImageName] [blueImageName]
    Splits the image into its red, green, and blue components.
    Example: rgb-split myImage redPart greenPart bluePart

13. rgb-combine [newImageName] [redImageName] [greenImageName] [blueImageName]
    Combines separate red, green, and blue images into a single color image.
    Example: rgb-combine combinedImage redPart greenPart bluePart

14. blur [imagename] [newImageName] [splitPercentage]
    Applies a blur effect to the image. Split percentage is optional.
    Example: blur myImage blurredImage 70

15. sharpen [imagename] [newImageName] [splitPercentage]
    Sharpens the image. Split percentage is optional.
    Example: sharpen myImage sharpenedImage 60

16. sepia [imagename] [newImageName] [splitPercentage]
    Applies a sepia tone to the image. Split percentage is optional.
    Example: sepia myImage sepiaImage 80

17. color-correct [imagename] [newImageName] [splitPercentage]
    Performs color correction on the image. Split percentage is optional.
    Example: color-correct myImage correctedImage 90

18. levels-adjust [imagename] [newImageName] [black] [mid] [white] [splitPercentage]
    Adjusts the levels of the image. Split percentage is optional.
    Example: levels-adjust myImage adjustedImage 20 128 235 75

19. compress [percentage] [imagename] [newImageName]
    Compresses the image by the specified percentage.
    Example: compress 30 myImage compressedImage

20. histogram [imagename] [newImageName]
    Generates a histogram for the specified image.
    Example: histogram myImage histogramImage

21. run [scriptFilePath]
    Executes a series of commands from a script file.
    Example: run scripts/enhance_image.txt

Usage Notes:
- The 'load' command must be used before any image manipulation commands.
- The 'save' command should be used after desired manipulations to store the result.
- For commands with split functionality (blur, sharpen, sepia, luma-component, color-correct, levels-adjust), 
  the split percentage is optional. If provided, it applies the effect to a portion of the image.
- The 'run' command can be used to execute a series of commands from a script file, which is useful for batch processing.

Example Script:
load images/photo.jpg original
brighten 30 original brightened
blur brightened blurred 60
sharpen blurred sharpened
color-correct sharpened corrected 80
save output/final_image.jpg corrected

This script loads an image, brightens it, applies a partial blur, sharpens the result, 
performs color correction on a portion of the image, and then saves the final result.



