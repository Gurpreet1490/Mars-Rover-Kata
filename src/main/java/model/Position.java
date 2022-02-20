package model;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean isEqual(Position other){
        return x == other.x && y ==other.y;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }


    public boolean onPlateau(MissionControl missionControl){
        if(x < 0 || x > missionControl.MaxX){
            return false;
        }
        if(y < 0 || y > missionControl.MaxY){
            return false;
        }
        return true;
    }

    public Position move(Direction direction){
        switch (direction) {
            case EAST : return new Position(x + 1, y);
            case NORTH: return new Position(x, y + 1);
            case SOUTH: return new Position(x, y - 1);
            case WEST:  return new Position(x - 1, y);
            default:throw new RuntimeException("Invalid direction, please add valid values");
        }
    }
}
