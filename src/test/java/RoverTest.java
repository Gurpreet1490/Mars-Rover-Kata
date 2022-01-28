import model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoverTest {

    private  Plateau plateau = new Plateau(5,5);

    private static Instruction[] convertToArray(String instruction) {
        return new RoverInstruction(instruction).getInstruction();
    }

    @Test
    public void letDropRover(){
        Rover rover1 = new Rover("RoverX1");
        rover1.landRover(plateau, "3 5 E");
        String report = rover1.reportPosition();

        assertEquals("3 5 E", report);
    }


    @Test
    public void moveInstruction(){
        Rover rover1 = new Rover("RoverX1");
        rover1.landRover(plateau, 3, 3, 'E');
        //rover1.command("MMRMMRMRRM");
        rover1.command(convertToArray("MMRMMRMRRM"));
        String report = rover1.reportPosition();

        assertEquals("5 1 E", report);
    }

    @Test
    public void roverNotDroppedReport(){
        Rover rover1 = new Rover("RoverX1");
        String report = rover1.reportPosition();

        assertEquals("Rover not landed!", report);
    }


}
