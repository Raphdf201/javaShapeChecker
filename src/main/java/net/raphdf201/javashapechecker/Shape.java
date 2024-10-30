package net.raphdf201.javashapechecker;

public class Shape {
    public Shape() {

    }

    public char typeToChar(Type type) {
        return switch (type) {
            case Type.Empty -> Constants.empty;
            case Type.Pin -> Constants.pin;
            case Type.Shape -> Constants.shape;
            case Type.Crystal -> Constants.crystal;
        };
    }

    public Type charToType(char c) {
        return switch (c) {
            case Constants.pin -> Type.Pin;
            case Constants.shape -> Type.Shape;
            case Constants.crystal -> Type.Crystal;
            default -> Type.Empty;
        };
    }
}
