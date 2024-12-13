package net.raphdf201.javashapechecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static net.raphdf201.javashapechecker.Constants.*;

/**
 * The main class contains most of the logic of the commands, including
 * {@link net.raphdf201.javashapechecker.Main#lookup(File, Shape)} and
 * {@link net.raphdf201.javashapechecker.Main#search(File)}
 */
public class Main {
    /**
     * Main method, gets executed when you launch the program via your shell
     *
     * @param args the arguments you enter when launching the program
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter help to know what commands are available");
        } else {
            switch (args[0].toLowerCase()) {
                case search:
                    if (args[1] == "4") {
                        search(new File(shapeFile4));
                    } else if (args[1] == "5") {
                        search(new File(shapeFile5));
                    } else {
                        System.out.println("Enter 4 or 5");
                    }
                    break;
                case lookup:
                    if (args[1] == "4") {
                        lookup(new File(shapeFile4), new Shape(args[2]));
                    } else if (args[1] == "5") {
                        lookup(new File(shapeFile5), new Shape(args[2]));
                    } else {
                        System.out.println("Enter 4 or 5");
                    }
                    break;
                default:
                    System.out.println(helpMessage);
                    break;
            }
        }
    }

    /**
     * Reads a binary file to an array of bytes
     * 
     * @param fileName the name of the file or relative path to it
     * @return byte array
     */
    public static byte[] readBinFile(String fileName) {
        File file = new File(fileName);
        byte[] result = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Search for a shape code in a .bin file
     * @param inputFile the file to read the shapes
     * @param shape the shape to search for
     */
    public static void lookup(File inputFile, Shape shape) {
    }

    /**
     * List all the possible shapes by bruteforce and write them to a .bin file
     * @param outputFile the file to write the shapes to
     */
    public static void search(File outputFile) {
    }
}
