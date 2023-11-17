Implemented Features

- Command Line Interface: The program provides a simple command-line interface to interact with users.
- Conversion: You can convert a source file from one format to another using the convert command. For example: convert source.csv to destination.txt
- Normalization: The normalize command reads the content of a file, normalizes the content of each cell, and writes the normalized content back to the same file. For example: normalize source.csv
- Quit: The quit command ends the program.


Partially Implemented Features

Path Handling: The program handles file paths to some extent. If a file name is provided without an absolute path, it is resolved relative to the current working directory.


Unimplemented Features

Advanced File Format Conversion Logic: The program currently performs a simple copy during file conversion. More advanced conversion logic for .csv and .txt files could be implemented based on specific requirements.
Error Handling: While basic error handling is in place, further refinement for edge cases and unexpected input is recommended.
User Guidance for Input: The program expects specific input formats. Providing more guidance to the user for correct input would enhance the user experience.