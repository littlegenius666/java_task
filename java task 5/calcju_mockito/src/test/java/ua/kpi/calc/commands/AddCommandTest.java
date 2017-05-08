package ua.kpi.calc.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import ua.kpi.calc.Calculator;

public class AddCommandTest {

	@Test
	public void testExecuteAddTwoAndThree() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.add(2, 3)).thenReturn(5);
		AddCommand addCommand = new AddCommand();
		addCommand.setCalculator(calculator);
		Integer expectedResult = 5;
		Integer actualResult;
		
		actualResult = addCommand.execute("2", "3");
		
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testExecuteAddTwoAndFake() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.add(2, 3)).thenReturn(5);
		AddCommand addCommand = new AddCommand();
		addCommand.setCalculator(calculator);
		Integer expectedResult = 5;
		Integer actualResult;
		
		actualResult = addCommand.execute("2", "fake");
		
		assertEquals(expectedResult, actualResult);
		
	}


}
