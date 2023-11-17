import java.io.*;
import java.util.Scanner;

public class FileConverter {

    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to File Converter!");

        boolean shouldQuit = false;
        do {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts.length >= 2) {
                String operation = parts[0];
                String sourceFile = resolvePath(parts[1]);

                if (operation.equals("quit")) {
                    System.out.println("Goodbye!");
                    shouldQuit = true;
                } else if (operation.equals("convert") && parts.length == 4 && parts[2].equals("to")) {
                    String destinationFile = resolvePath(parts[3]);
                    convertFile(sourceFile, destinationFile);
                } else if (operation.equals("normalize")) {
                    normalizeFile(sourceFile);
                } else {
                    System.out.println("Invalid command. Please use 'convert source.xxx to destination.yyy', 'normalize', or 'quit'.");
                }
            } else if (parts.length == 1 && parts[0].equals("quit")) {
                System.out.println("Goodbye!");
                shouldQuit = true;
            } else {
                System.out.println("Invalid command. Please enter a valid command.");
            }

        } while (!shouldQuit);

        scanner.close();
    }

    private static String resolvePath(String filename) {

        if (!new File(filename).isAbsolute()) {
            return CURRENT_DIRECTORY + File.separator + filename;
        }
        return filename;
    }

    private static void convertFile(String sourceFile, String destinationFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Conversion completed successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred during the conversion: " + e.getMessage());
        }
    }

    private static void normalizeFile(String sourceFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");

                for (int i = 0; i < cells.length; i++) {
                    String cell = cells[i].trim();

                    if (cell.isEmpty()) {
                        cells[i] = "N/A";
                    } else if (isInteger(cell)) {
                        cells[i] = normalizeInteger(cell);
                    } else if (isDouble(cell)) {
                        cells[i] = normalizeDouble(cell);
                    } else if (cell.length() > 13) {
                        cells[i] = cell.substring(0, 10) + " . . . ";
                    }

                }

                String normalizedLine = String.join(",", cells);
                writer.write(normalizedLine);
                writer.newLine();
            }

            System.out.println("Normalization completed successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred during normalization: " + e.getMessage());
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String normalizeInteger(String s) {
        int intValue = Integer.parseInt(s);
        String sign = (intValue >= 0) ? "+" : "-";
        String normalizedValue = String.format("%s%010d", sign, Math.abs(intValue));
        return normalizedValue;
    }

    private static String normalizeDouble(String s) {
        double doubleValue = Double.parseDouble(s);
        if (doubleValue > 100 || doubleValue < 0.01) {
            return String.format("%.2e", doubleValue);
        } else {
            return String.format("%.2f", doubleValue);
        }
    }
}