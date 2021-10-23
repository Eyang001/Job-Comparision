package edu.gatech.seclass.jobcompare6300;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ControllerUnitTest {
    private Controller controller;
    @Before
    public void setup(){
        MainActivity main = new MainActivity();
        controller = new Controller(main.getApplicationContext());
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testEditCurrentJob(){
        //controller does not do input validation;
        String title = "test title";
        String company ="test company";
        String city = "Seattle";
        String state = "WA";
        int colIndex = 100;
        int salary = 200000;
        int bonus = 50000;
        int teleworkDays = 0;
        int leaveDays = 25;
        int gymAllowance = 500;
        Controller.editCurrentJob(title, company, city, state, colIndex, salary, bonus, teleworkDays, leaveDays, gymAllowance);
        assertNotNull(Controller.getCurrentJob());
        assertNotNull(Controller.getLocationByCityState(city,state));
        Location location = Controller.getLocationByCityState(city, state);
        assertEquals("Seattle", location.getCity());
        assertEquals("WA", location.getState());
        assertEquals(100, location.getCostOfLivingIndex());
    }
}