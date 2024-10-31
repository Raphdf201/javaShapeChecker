package net.raphdf201.javashapechecker;

/**
 * Class containing all the constant values that are used in multiple classes
 */
public class Constants {
    /**
     * Character representing any empty quarter<br>
     * Enum equivalent : {@link net.raphdf201.javashapechecker.Enums.quarterType#EMPTY}
     */
    public static final char empty = '-';
    /**
     * Character representing any shape<br>
     * Enum equivalent : {@link net.raphdf201.javashapechecker.Enums.quarterType#SHAPE}
     */
    public static final char shape = 'S';
    /**
     * Character representing a pin<br>
     * Enum equivalent : {@link net.raphdf201.javashapechecker.Enums.quarterType#PIN}
     */
    public static final char pin = 'P';
    /**
     * Character representing any crystal<br>
     * Enum equivalent : {@link net.raphdf201.javashapechecker.Enums.quarterType#CRYSTAL}
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
}
