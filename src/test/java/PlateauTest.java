import model.MissionControl;
import model.Plateau;
import org.junit.Test;

public class PlateauTest {

    @Test(expected = RuntimeException.class)
    public void checkingInvalidDims(){
        Plateau plateau = new Plateau(-20,20);
        //assertThrows(RuntimeException.class, () -> new Plateau(-1, 2));
    }

}
