package net.raphdf201.javashapechecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static net.raphdf201.javashapechecker.Constants.lookup;
import static net.raphdf201.javashapechecker.Constants.search;
import static net.raphdf201.javashapechecker.Constants.help;

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
            switch (args[0]) {
                case help -> {
                    System.out.println("Welcome to the javaShapeChecker");
                    System.out.println("Possible arguments :");
                    System.out.print(lookup + " : ");
                    System.out.println("Check if a shape is present in a .bin file");
                    System.out.println("Usage : ./javaShapeChecker lookup file.bin CuRrcb--:P-P-P-Sy");
                    System.out.println("             app name      command   file     shape");
                    enter();
                    System.out.print(search + " : ");
                    System.out.println("List all the possible shapes by bruteforce and write them to a .bin file");
                    System.out.println("Usage : ./javaShapeChecker search file.bin 5");
                    System.out.println("             app name      command   file   nb of layers");
                    enter();
                    System.out.print(help + " : ");
                    System.out.println("Show this help menu");
                }
                case search -> search(new File(args[1]));
                case lookup -> lookup(readBinFile(args[1]), new Shape(args[2]));
                default -> System.out.println("Incorrect argument, please enter search, lookup or help");
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

    public static void lookup(byte[] data, Shape shape) {
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
