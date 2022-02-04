package model;

public class PositionNotFoundException extends RuntimeException {

    public PositionNotFoundException() {
        super("Position is not on the plateau!");
    }

}
