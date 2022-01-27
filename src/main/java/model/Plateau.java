package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Plateau {

    int dimX;
    int dimY;

    private List<Rover> rovers = new ArrayList<Rover>();

    public Plateau(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
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
