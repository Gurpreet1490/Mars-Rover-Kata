package model;

public class Rover {

    private String name;
    private static Direction direction;
    private Position position;
    private Plateau plateau;

    public Rover(String name) {
        this.name = name;
    }


    public void turnLeft() {
        switch (direction) {
            case EAST -> direction = direction.NORTH;
            case NORTH -> direction = direction.WEST;
            case WEST -> direction = direction.SOUTH;
            case SOUTH -> direction = direction.EAST;
            default -> throw new RuntimeException("Invalid direction value!");
        }
    }

    public void turnRight(){
        switch (direction) {
            case EAST -> direction = direction.SOUTH;
            case NORTH -> direction = direction.EAST;
            case WEST -> direction = direction.NORTH;
            case SOUTH -> direction = direction.WEST;
            default -> throw new RuntimeException("Invalid direction value!");
        }
    }

    public void moveForward() {
        Position newPosition = position.move(direction);
        if (!newPosition.onPlateau(plateau)) {
            throw new PositionNotFoundException();
        }
        position = newPosition;
    }

    public boolean hasPosition(Position position) {
        return this.position.isEqual(position);
    }

    public void landRover(Plateau plateau, String args) {
        String[] axis = args.split(" ");
        int x = Integer.parseInt(axis[0]);
        int y = Integer.parseInt(axis[1]);
        Direction direction = approachingTo(axis[2].toCharArray()[0]);
        landRoverPlateau(plateau, new Position(x, y), direction);
    }

    public void landRoverPlateau(Plateau plateau, Position position, Direction direction){

        if(!position.onPlateau(plateau)){
            throw new PositionNotFoundException();
        }

        if(plateau.positionTaken(position)){
            throw new RuntimeException("Position already taken!");
        }

        this.plateau = plateau;
        this.position = position;
        this.direction = direction;

        plateau.addRover(this);
    }

    public void landRoverPosition(Plateau plateau, int posX, int posY, char direction)
    {
        landRoverPlateau(plateau, new Position(posX, posY), approachingTo(direction));
    }


    public void command(InstructionType[] instructions) {
        for (InstructionType i : instructions) {
            processCommand(i);
        }
    }

    public void processCommand(InstructionType instruction){
        if (position == null || direction == null){
            throw new NotLandedException();
        }
        switch (instruction){
            case LEFT: turnLeft(); break;
            case RIGHT: turnRight(); break;
            case MOVE: moveForward(); break;
            default:throw new RuntimeException("Invalid Instruction!");
        }
    }

    public static Direction approachingTo(char direction){
        switch (direction){
            case 'N' : return Direction.NORTH;
            case 'S' : return Direction.SOUTH;
            case 'E' : return Direction.EAST;
            case 'W' : return Direction.WEST;
            default:throw new RuntimeException("Unsupported " + direction + "!");
        }
    }

    private static char approachingFrom(Direction direction){
        switch (direction){
            case NORTH: return 'N';
            case SOUTH: return 'S';
            case WEST: return 'W';
            case EAST: return 'E';
            default:throw new RuntimeException("Unsupported direction " + direction + "!");
        }
    }

    public String roverStatus() {
        StringBuilder strB = new StringBuilder(name);
        strB.append(" ");
        strB.append(roverPosition());
        return strB.toString();
    }

    public String roverPosition() {
        if (position == null || direction == null){
            return "Rover not landed!";
        }
        return position.toString() + " " + approachingFrom(direction);
    }
}

