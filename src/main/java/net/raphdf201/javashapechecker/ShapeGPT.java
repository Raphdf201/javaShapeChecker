package net.raphdf201.javashapechecker;

import java.util.*;

public class ShapeGPT {
    public static int LAYER;
    // Parts in each layer
    public static int PART;

    static {
        if (LAYER * LAYER * 2 > 64) {
            throw new AssertionError("LAYER * LAYER * 2 must be <= 64");
        }
    }

    public static final Class<?> T = (LAYER * PART * 2 <= 32) ? Integer.class : Long.class;

    private long value = 0;

    public enum Type {
        EMPTY(0),
        PIN(1),
        SHAPE(2),
        CRYSTAL(3);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Type fromValue(int value) {
            for (Type type : values()) {
                if (type.value == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid Type value: " + value);
        }
    }

    public Type get(int layer, int part) {
        int idx = layer * PART + part;
        return Type.fromValue((int) ((value >> (idx * 2)) & 3));
    }

    public void changeLayer(int layer) {
        LAYER = layer;
    }

    public void changePart(int part) {
        PART = part;
    }

    public void set(int layer, int part, Type type) {
        int idx = layer * PART + part;
        value &= ~(3L << (idx * 2));
        value |= (long) type.getValue() << (idx * 2);
    }

    public String toString(boolean withColor) {
        int len = LAYER * PART * (withColor ? 2 : 1) + LAYER - 1;
        StringBuilder repr = new StringBuilder(len);
        for (int layer = 0; layer < LAYER; layer++) {
            if (layer > 0) {
                repr.append(':');
            }
            for (int part = 0; part < PART; part++) {
                Type type = get(layer, part);
                repr.append(toChar(type));
                if (withColor) {
                    repr.append(type == Type.EMPTY || type == Type.PIN ? '-' : 'w');
                }
            }
        }
        return repr.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShapeGPT shape = (ShapeGPT) obj;
        return value == shape.value;
    }

    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isLessThan(ShapeGPT other) {
        return this.value < other.value;
    }

    public ShapeGPT() {}

    public ShapeGPT(long v) {
        this.value = v;
    }

    public ShapeGPT(String repr) {
        int shortLen = LAYER * PART + LAYER - 1;
        int fullLen = 2 * LAYER * PART + LAYER - 1;
        boolean isFull = repr.length() == fullLen;
        if (repr.length() != shortLen && repr.length() != fullLen) {
            throw new IllegalArgumentException("Incorrect length");
        }
        int p = 0;
        for (int layer = 0; layer < LAYER; layer++) {
            if (layer > 0) {
                if (repr.charAt(p++) != ':') {
                    throw new IllegalArgumentException("Missing colon");
                }
            }
            for (int part = 0; part < PART; part++) {
                set(layer, part, parseType(repr.charAt(p++)));
                if (isFull) p++;
            }
        }
    }

    private Type parseType(char c) {
        return switch (c) {
            case '-' -> Type.EMPTY;
            case 'P' -> Type.PIN;
            case 'S' -> Type.SHAPE;
            case 'C' -> Type.CRYSTAL;
            default -> throw new IllegalArgumentException("Unknown type character: " + c);
        };
    }

    private char toChar(Type type) {
        return switch (type) {
            case EMPTY -> '-';
            case PIN -> 'P';
            case SHAPE -> 'S';
            case CRYSTAL -> 'C';
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
