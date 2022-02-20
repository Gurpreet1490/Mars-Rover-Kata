import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    private MissionControl missionControl = null;

    @Before
    public void setUp() {
       missionControl = new MissionControl(20, 20);
    }

    @Test (expected = RuntimeException.class)
    public void checkingInvalidDims(){
        MissionControl plateau = new MissionControl(-1,10);
        //assertThrows(RuntimeException.class, () -> new Plateau(-1, 2));
    }

    @Test
    public void landingAndMovingRoverShouldSucceedCase1(){
        Rover rover1 = new Rover("RoverX1");

        rover1.landRoverPlateau(missionControl, new Position(10, 10), Direction.NORTH);
        rover1.command(convertToArray("LMLMLMLMM"));
        String report = rover1.roverPosition();

        assertEquals("10 11 N", report);
    }

    @Test
    public void landingAndMovingRoverShouldSucceedCase2(){
        Rover rover1 = new Rover("RoverX1");

        rover1.landRoverPosition(missionControl, 3, 3, 'E');
        rover1.command(convertToArray("MMRMMMRRM"));

        String report = rover1.roverPosition();

        assertEquals("5 1 N", report);
    }

    @Test
    public void roverNotDroppedReport(){
        Rover rover1 = new Rover("RoverX1");
        String report = rover1.roverPosition();

        assertEquals("Rover not landed!", report);
    }

    @Test
    public void roverNotDroppedWithName(){
        Rover rover1 = new Rover("RoverX1");
        String report = rover1.roverStatus();

        assertEquals("RoverX1 Rover not landed!", report);
    }

    @Test(expected = RuntimeException.class)
    public void movingRoverOverAnotherRoverShouldThrowException(){
        Rover rover1 = new Rover("RoverX1");
        Rover rover2 = new Rover("RoverX2");

        rover1.landRover(missionControl, "3 5 E");
        rover2.landRover(missionControl, "3 5 N");
    }

    @Test(expected = PositionNotFoundException.class)
    public void movingRoverOutsidePlateauBoundaryShouldThrowException(){
        Rover rover1 = new Rover("RoverX1");

        rover1.landRover(missionControl, "0 0 S");
        rover1.command(convertToArray("M"));
    }

    @Test
    public void Rover2DroppedNextToAnotherShouldSucceed(){
        Rover rover1 = new Rover("RoverX1");
        Rover rover2 = new Rover("RoverX2");

        rover1.landRover(missionControl, "3 5 E");
        rover2.landRover(missionControl, "4 5 N");
    }

    @Test(expected = PositionNotFoundException.class)
    public void roverShouldFailToLandOutsidePlateau(){
        Rover rover1 = new Rover("RoverX1");

        rover1.landRover(missionControl, "25 25 E");
    }

    @Test
    public void landRoverOnEmptyLocationShouldSucceed(){
        Rover rover1 = new Rover("RoverX1");
        rover1.landRover(missionControl, "3 5 E");
        String report = rover1.roverPosition();

        assertEquals("3 5 E", report);
    }

    private static InstructionType[] convertToArray(String instructions) {
        return new Instructions(instructions).getInstruction();
    }

}
