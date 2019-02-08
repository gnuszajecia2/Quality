package pl.edu.agh.qualitycalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculationsTest {
    Calculations calculationsUnderTest;


    //Test operacji matematycznych


    @Before
    public void setUp() {
        calculationsUnderTest = new Calculations();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(5, calculationsUnderTest.calculate(Operation.SUM, 2, 3), 0.01);
    }

    @Test
    public void testSUBTRACT() throws Exception {
        assertEquals(20, calculationsUnderTest.calculate(Operation.SUBTRACT, 25, 5), 0.01);
    }

    @Test
    public void testDIVIDE() throws Exception {
        assertEquals(4, calculationsUnderTest.calculate(Operation.DIVIDE, 20, 5), 0.01);
    }

    @Test
    public void testMULTIPLY() throws Exception {
        assertEquals(200, calculationsUnderTest.calculate(Operation.MULTIPLY, 40, 5), 0.01);
    }

    @Test
    public void testAverage() throws Exception {
        assertEquals(10, calculationsUnderTest.calculate(Operation.AVERAGE, 5, 10, 15), 0.01);
    }

    @After
    public void tearDown() {
    }


}
