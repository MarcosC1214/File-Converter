# File Converter

Welcome to the File Converter! This Java program allows you to convert and normalize files in different formats. The supported operations include converting between .csv and .txt files and normalizing the content of a file.

## Features

### Implemented Features

1. **Command Line Interface**: The program provides a simple command-line interface to interact with users.
2. **Conversion**: You can convert a source file from one format to another using the `convert` command. For example:
    ```bash
    convert source.csv to destination.txt
    ```
3. **Normalization**: The `normalize` command reads the content of a file, normalizes the content of each cell, and writes the normalized content back to the same file.
    ```bash
    normalize source.csv
    ```
4. **Quit**: The `quit` command ends the program.

### Partially Implemented Features

1. **Path Handling**: The program handles file paths to some extent. If a file name is provided without an absolute path, it is resolved relative to the current working directory.

### Unimplemented Features

1. **Advanced File Format Conversion Logic**: The program currently performs a simple copy during file conversion. More advanced conversion logic for .csv and .txt files could be implemented based on specific requirements.
2. **Error Handling**: While basic error handling is in place, further refinement for edge cases and unexpected input is recommended.
3. **User Guidance for Input**: The program expects specific input formats. Providing more guidance to the user for correct input would enhance the user experience.

## How to Use

1. Compile the Java program: `javac FileConverter.java`
2. Run the program: `java FileConverter`
3. Enter commands as instructed by the program.

Feel free to explore and modify the code to suit your specific needs. If you have any questions or encounter issues, please refer to the source code or contact the author for assistance.
