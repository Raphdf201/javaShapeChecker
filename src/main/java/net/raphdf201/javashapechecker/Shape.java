package net.raphdf201.javashapechecker;

import static net.raphdf201.javashapechecker.Enums.*;

public class Shape {    // TODO : docs
    private String shapeCode;
    private byte nbLayers;
    private Scenario scenario;

    public Shape(String shapeCode) {    // TODO : This format : https://discordapp.com/channels/1000343719314198548/1295099125016301608/1300226163251216405
        String[] layers = shapeCode.split(String.valueOf(Constants.layer));
        if (layers.length > 4) {
            this.scenario = Scenario.Hex;
        } else {
            this.scenario = Scenario.Regular;
        }
        this.shapeCode = shapeCode;
        this.nbLayers = (byte) layers.length;
    }

    public String[] unStackToString() {
        return shapeCode.split(String.valueOf(Constants.layer));
    }

    public Shape[] unStackToShape() {
        String[] layers = unStackToString();
        Shape[] shapes = new Shape[layers.length];
        for (int i = 0; i < layers.length; i++) {
            shapes[i] = new Shape(layers[i]);
        }
        return shapes;
    }

    public static char typeToChar(quarterType type) {
        return switch (type) {
            case quarterType.Empty -> Constants.empty;
            case quarterType.Pin -> Constants.pin;
            case quarterType.Shape -> Constants.shape;
            case quarterType.Crystal -> Constants.crystal;
        };
    }

    public static quarterType charToType(char c) {
        return switch (c) {
            case Constants.pin -> quarterType.Pin;
            case Constants.shape -> quarterType.Shape;
            case Constants.crystal -> quarterType.Crystal;
            default -> quarterType.Empty;
        };
    }
}
