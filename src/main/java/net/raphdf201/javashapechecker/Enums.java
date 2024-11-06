package net.raphdf201.javashapechecker;

/**
 * Contains all the inner enums of the project
 */
public class Enums {
    /**
     * The type of shape quarter
     */
    public enum quarterType {
        /**
         * Shape code character : --
         */
        EMPTY,
        /**
         * Shape code character : P-
         */
        PIN,
        /**
         * Possible shapes in Regular scenario :<br>
         * C- R- S- W-
         */
        SHAPE,
        /**
         * Shape code character : -c
         */
        CRYSTAL
    }

    /**
     * The scenario the shape is used in
     */
    public enum scenario {
        /**
         * Each shape is composed of 4 quarters<br>
         * 4 layers are possible
         */
        REGULAR,
        /**
         * Same as {@link scenario#REGULAR} but 5 layers are possible
         */
        INSANE,
        /**
         * Each shape is composed of 6 quarters<br>
         * 4 layers are possible
         */
        HEX
    }

    /**
     * A list of buildings
     */
    public enum action {
        /**
         * Rotate the shape 90 degrees in {@link scenario#REGULAR}
         * Rotate the shape 60 degrees in {@link scenario#HEX}
         */
        ROTATE90,
        /**
         * Rotate the shape 180 degrees in {@link scenario#REGULAR}
         * Rotate the shape 120 degrees in {@link scenario#HEX}
         */
        ROTATE180,
        /**
         * Rotate the shape 270 degrees in {@link scenario#REGULAR}
         * Rotate the shape 300 degrees in {@link scenario#HEX}
         */
        ROTATE270,
        /**
         * Swap the east and west halves
         */
        SWAP,
        /**
         * Stack two shapes
         */
        STACK,
        /**
         * Remove the west half
         */
        CUT,
        /**
         * Separate the east and west halves
         */
        DIVIDE,
        /**
         * Create pin under every non-empty shape part of the shape's bottom layer
         */
        PINPUSH
    }

    /**
     * List of simulated buildings
     */
    public enum eAction {
        /**
         * Rotate the shape 90 degrees in {@link scenario#REGULAR}
         * Rotate the shape 60 degrees in {@link scenario#HEX}
         */
        ROTATE,
        /**
         * Swap the east and west halves
         */
        SWAP,
        /**
         * Stack two shapes
         */
        STACK,
        /**
         * Unstack two shapes
         */
        UNSTACK,
        /**
         * Remove the west half
         */
        CUT
    }
}
