package model;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

   public int MaxX;
   public int MaxY;

    private List<Rover> rovers = new ArrayList<Rover>();

    public Plateau(int maxX, int maxY) {
        this.MaxX = maxX;
        this.MaxY = maxY;
    }

    public void addRover(Rover rover){
        rovers.add(rover);
    }

    public boolean positionTaken(Position position){
        for (Rover rover : rovers){
            if(rover.hasPosition(position)){
                return true;
            }
        }
        return false;
    }
}
