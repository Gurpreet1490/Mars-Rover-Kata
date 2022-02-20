package model;

public class Plateau {

   private int MaxX;
   private int MaxY;



    public Plateau(int maxX, int maxY) {
        if(maxX > 0 && maxY > 0) {
            this.MaxX = maxX;
            this.MaxY = maxY;
        } else {
            throw new RuntimeException("Invalid plateau dims");
        }
    }

}
