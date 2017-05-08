package ua.kpi.calc.commands;

import ua.kpi.calc.Calculator;

public class AddCommand implements Command {
	
	private Calculator calculator = Calculator.getInstance();

	
	void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}


	@Override
	public Integer execute(String firstParameter, String secondParameter) {
		Integer firstInt = Integer.valueOf(firstParameter);
		Integer secondInt = Integer.valueOf(secondParameter);
		
		return calculator.add(firstInt, secondInt);
	}

}
