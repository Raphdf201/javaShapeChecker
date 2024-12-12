package net.raphdf201.javashapechecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static net.raphdf201.javashapechecker.Constants.*;

/**
 * The main class contains most of the logic to // TODO
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
                case help:
                    System.out.println("""
                    Welcome to the javaShapeChecker
                    Possible arguments :
                    lookup : Check if a shape is present in a .bin file
                    Usage : ./javaShapeChecker lookup 5 CuRrcb--:P-P-P-Sy
                                 app name     command layer  shape
                    
                    search : List all the possible shapes by bruteforce and write them to a .bin file
                    Usage : ./javaShapeChecker search 5
                                 app name     command   nb of layers
                    
                    help : Show this help menu
                    Usage : ./javaShapeChecker help
                                 app name     command
                    """);
                    break;
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
                        lookup(new File(shapeFile4));
                    } else if (args[1] == "5") {
                        lookup(new File(shapeFile5));
                    } else {
                        System.out.println("Enter 4 or 5");
                    }
                    break;
                default:
                    System.out.println("Incorrect argument, please enter search, lookup or help");
                    break;
            }
        }
    }

    /**
     * Reads a binary file to an array of bytes
     * 
     * @param fileName the name of the file or relativ epath to it
     * @return byte array of file.lenght length
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

    public static void lookup(File inputFile) {
    }

    public static void search(File outputFile) {
    }

    public static void tab() {
        System.out.print(Constants.tab);
    }

    public static void enter() {
        System.out.println();
    }
}
