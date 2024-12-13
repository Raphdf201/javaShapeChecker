package net.raphdf201.javashapechecker;

import static net.raphdf201.javashapechecker.Enums.Type;

/**
 * A shape object, used for lookups
 */
public class Shape {
    private final String shapeCode;
    private final byte nbLayers;
    private byte nbParts;

    public boolean check() {
        return nbLayers * nbLayers * 2 <= 64;
    }

    /**
     * Constructor for a shape object
     *
     * @param shapeCode a shapez shape code like {CuRbWcSu:CuP-cb--}
     */
    public Shape(String shapeCode) {    // TODO : This format : https://discordapp.com/channels/1000343719314198548/1295099125016301608/1300226163251216405
        String[] layers = shapeCode.split(String.valueOf(Constants.layer));
        this.shapeCode = shapeCode;
        this.nbLayers = (byte) layers.length;
    }

    /**
     * Transforms a quarter enum value to its character
     *
     * @param type A quarter
     * @return The character representing the quarter
     */
    public static char typeToChar(Type type) {
        return switch (type) {
            case Type.EMPTY -> Constants.empty;
            case Type.PIN -> Constants.pin;
            case Type.SHAPE -> Constants.shape;
            case Type.CRYSTAL -> Constants.crystal;
        };
    }

    /**
     * Transforms a quarter character to its enum value
     *
     * @param c A quarter character
     * @return The type of the quarter
     */
    public static Type charToType(char c) {
        return switch (c) {
            case Constants.pin -> Type.PIN;
            case Constants.shape -> Type.SHAPE;
            case Constants.crystal -> Type.CRYSTAL;
            default -> Type.EMPTY;
        };
    }

    /**
     * Unstacks a shape (separates the layers)
     *
     * @return an array of strings, each one being a 1 layer shape
     */
    public String[] unStackAllToString() {
        return shapeCode.split(String.valueOf(Constants.layer));
    }

    /**
     * Unstacks a shape using {@link Shape#unStackAllToString()}. Then creates shape objects
     *
     * @return an array of shapes, each one being a 1 layer shape
     */
    public Shape[] unStackAllToShape() {
        String[] layers = unStackAllToString();
        Shape[] shapes = new Shape[layers.length];
        for (int i = 0; i < layers.length; i++) {
            shapes[i] = new Shape(layers[i]);
        }
        return shapes;
    }
}
