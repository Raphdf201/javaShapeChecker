package net.raphdf201.javashapechecker;

/**
 * A class containing all the enums I need for this project<br>
 * {@link quarterType}<br>
 * {@link net.raphdf201.javashapechecker.Enums.Scenario}
 */
public class Enums {
    /**
     * The type of shape quarter
     */
    public enum quarterType {
        /**
         * Shape code character : --
         */
        Empty,
        /**
         * Shape code character : P-
         */
        Pin,
        /**
         * Possible shapes in Regular scenario :<br>
         * C- R- S- W-
         */
        Shape,
        /**
         * Shape code character : -c
         */
        Crystal
    }

    /**
     * The scenario the shape is used in
     */
    public enum Scenario {
        /**
         * Each shape is composed of 4 quarters<br>
         * 4 layers are possible
         */
        Regular,
        /**
         * Same as {@link net.raphdf201.javashapechecker.Enums.Scenario#Regular} but 5 layers are possible
         */
        Insane,
        /**
         * Each shape is composed of 6 quarters<br>
         * 4 layers are possible
         */
        Hex
    }

    public enum action {    // TODO : docs
        ROTATE90,
        ROTATE180,
        ROTATE270,
        SWAP,
        STACK,
        CUT,
        DIVIDE
    }

    public enum eAction {   // TODO : docs
        ROTATE,
        SWAP,
        STACK,
        UNSTACK,
        CUT
    }
}
