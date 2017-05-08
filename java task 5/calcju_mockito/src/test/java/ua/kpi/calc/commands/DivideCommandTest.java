package ua.kpi.calc.commands;

import org.junit.Test;
import ua.kpi.calc.Calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Yelyzaveta_Horbachen on 08.05.17.
 */
public class DivideCommandTest {
    @Test
    public void testExecuteDivideSixAndThree() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.divide(6, 3)).thenReturn(2);
        DivideCommand divideCommand = new DivideCommand(calculator);
        Integer expectedResult = 2;
        Integer actualResult;
        actualResult = divideCommand.execute("6", "3");
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NumberFormatException.class)
    public void testExecuteDivideSixAndFake() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.divide(6, 3)).thenReturn(2);
        DivideCommand divideCommand = new DivideCommand(calculator);
        Integer expectedResult = 2;
        Integer actualResult;
        actualResult = divideCommand.execute("6", "fake");
        assertEquals(expectedResult, actualResult);
    }
}
