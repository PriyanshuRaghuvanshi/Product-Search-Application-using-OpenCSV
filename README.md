# Product-Search-Application-using-OpenCSV

This is a Java program that searches for T-shirts in CSV files containing product data for different brands (Nike, Puma, Adidas). Users can specify their preferences such as color, size, gender, and output sorting preference to find matching T-shirts.

## Features

- Accepts the following input parameters:
  - Color
  - Size
  - Gender (M=Male, F=Female)
  - Output Preference (Price, Rating, or both)
- Searches for T-shirts in CSV files for Nike, Puma, and Adidas.
- Allows adding more CSV files for additional brands.
- Uses OpenCSV for reading and parsing CSV files.
- Dynamically loads new CSV files at a configurable location.
- User-friendly error message if no suitable T-shirt is found.
- Implemented as a Maven project.
- Utilizes Java 8 features wherever possible.


## Adding More CSV Files

You can add more CSV files for additional brands by placing them in the configurable location. The program will automatically load new CSV files at runtime.

## Building the JAR File

An Ant script is provided to build a JAR file for the program. Run the following command to build the JAR file:

```shell
ant build-jar
```

The JAR file will be created in the `target` directory.
