package model;

public class Rover {

    private static Direction direction;
    private Position position;
    private Plateau plateau;
    private String name;

    public Rover(String name) {
        this.name = name;
    }

    public boolean hasPosition(Position position) {
        return true;
    }

    public void turnLeft() {
        switch (direction) {
            case EAST -> direction = direction.NORTH;
            case NORTH -> direction = direction.WEST;
            case WEST -> direction = direction.SOUTH;
            case SOUTH -> direction = direction.EAST;
            default -> throw new RuntimeException("Rover shouldn't expected to be here!");
        }

    }

    public void turnRight(){
        switch (direction) {
            case EAST -> direction = direction.NORTH;
            case NORTH -> direction = direction.WEST;
            case WEST -> direction = direction.SOUTH;
            case SOUTH -> direction = direction.EAST;
            default -> throw new RuntimeException("Rover shouldn't expected to be here!");
        }
    }

    public void move(){
        Position newPosition= position.move(direction);
        position = newPosition;
    }

    public void command(Instruction[] instructions) {
        for (Instruction instruction : instructions) {
            processCommand(instruction);
        }
    }

    public void processCommand(Instruction instruction){
        if (position ==null || direction == null){
            throw new NotLandedException();
        }
        switch (instruction){
            case LEFT: turnLeft(); break;
            case RIGHT: turnRight(); break;
            case MOVE: move(); break;

            default:throw new RuntimeException("Invalid Instruction!");
        }
    }

    public void landRover(Plateau plateau, String args) {
        String[] axis = args.split(" ");
        int x = Integer.parseInt(axis[0]);
        int y = Integer.parseInt(axis[1]);
        Direction direction = headingTo(axis[2].toCharArray()[0]);
        landRover(plateau, new Position(x, y), direction);
    }

    public void landRover(Plateau plateau, Position position, Direction direction){
        if(!position.onPlateau(plateau)){
            throw new PositionNotFoundException(plateau, position);
        }
        if(plateau.positionTaken(position)){
            throw new RuntimeException("Position already taken!");
        }

        this.plateau = plateau;
        this.position = position;
        this.direction = direction;

        plateau.addRover(this);
    }

    public void landRover(Plateau plateau, int posX, int posY, char direction){
        landRover(plateau, new Position(posX, posY), headingTo(direction));

    }

    private static Direction headingTo(char direction){
        switch (direction){
            case 'N' : return Direction.NORTH;
            case 'S' : return Direction.SOUTH;
            case 'E' : return Direction.EAST;
            case 'W' : return Direction.WEST;
            default:throw new RuntimeException("Unsupported " + direction + "!");
        }
    }

    private static char headingFrom(Direction direction){
        switch (direction){
            case NORTH: return 'N';
            case SOUTH: return 'S';
            case WEST: return 'W';
            case EAST: return 'E';
            default:throw new RuntimeException("Unsupported direction " + direction + "!");
        }
    }

    public String reportStatus() {
        StringBuilder strB = new StringBuilder(name);
        strB.append(" ");
        strB.append(reportPosition());
        return strB.toString();
    }

    public String reportPosition() {
        if (position == null || direction == null){
            return "Rover not landed!";
        }
        return position.toString() + " " + headingFrom(direction);
    }
}

