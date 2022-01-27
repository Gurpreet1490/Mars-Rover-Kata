package model;

public class PositionNotFoundException extends RuntimeException {

    private Position position;
    private Plateau plateau;

    public PositionNotFoundException(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public Plateau getPlateau(){
        return plateau;
    }
}
