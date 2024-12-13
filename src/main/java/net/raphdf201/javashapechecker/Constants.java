package net.raphdf201.javashapechecker;

/**
 * Constant values that are used in multiple classes
 */
public class Constants {
    /**
     * Character representing any empty quarter<br>
     * Enum equivalent :
     * {@link net.raphdf201.javashapechecker.Enums.quarterType#EMPTY}
     */
    public static final char empty = '-';
    /**
     * Character representing any shape<br>
     * Enum equivalent :
     * {@link net.raphdf201.javashapechecker.Enums.quarterType#SHAPE}
     */
    public static final char shape = 'S';
    /**
     * Character representing a pin<br>
     * Enum equivalent :
     * {@link net.raphdf201.javashapechecker.Enums.quarterType#PIN}
     */
    public static final char pin = 'P';
    /**
     * Character representing any crystal<br>
     * Enum equivalent :
     * {@link net.raphdf201.javashapechecker.Enums.quarterType#CRYSTAL}
     */
    public static final char crystal = 'c';
    /**
     * Character used to separate the layers of a shape
     */
    public static final char layer = ':';
    /**
     * Uncolored character, to replace any other color
     */
    public static final char color = 'u';
    /**
     * The prefix for colors
     * Ex : color-r
     */
    public static final String colorPrefix = "color-";
    /**
     * The first letter of every color
     */
    public static final char[] colorIDs = {'r', 'g', 'b', 'y', 'm', 'c', 'w'};
    /**
     * The full name of every color
     */
    public static final String[] colorNames = {colorPrefix + 'r', colorPrefix + 'g', colorPrefix + 'b',
            colorPrefix + 'y', colorPrefix + 'm', colorPrefix + 'c', colorPrefix + 'w'};
    /**
     * A tab character (\t)
     */
    public static final String tab = "\t";
    /**
     * The search command keyword
     */
    public static final String search = "search";
    /**
     * The lookup command keyword
     */
    public static final String lookup = "lookup";
    /**
     * The help command keyword
     */
    public static final String help = "help";
    /**
     * The help message displayed when help or null argument entered
     */
    public static final String helpMessage = """
            Welcome to the javaShapeChecker
            Possible arguments :
            lookup : Check if a shape is present in a .bin file
            Usage : ./javaShapeChecker lookup 5 CuRrcb--:P-P-P-Sy
                         app name     command layer  shape
            
            search : List all the possible shapes by bruteforce and write them to a .bin file
            Usage : ./javaShapeChecker search 5
                         app name     command  nb of layers
            
            help : Show this help menu
            Usage : ./javaShapeChecker help
                         app name     command
            """;
    /**
     * The default filename for 4 layer search/lookup
     */
    public static final String shapeFile4 = "shapes4.bin";
    /**
     * The default filename for 5 layer search/lookup
     */
    public static final String shapeFile5 = "shapes5.bin";
}
