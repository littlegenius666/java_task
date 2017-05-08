package ua.kpi.calc.commands;

import ua.kpi.calc.Calculator;

public class DivideCommand implements Command {

	private Calculator calculator = Calculator.getInstance();


	public DivideCommand(Calculator calculator) {
		this.calculator = calculator;
	}


	@Override
	public Integer execute(String firstParameter, String secondParameter) {
		Integer firstInt = Integer.valueOf(firstParameter);
		Integer secondInt = Integer.valueOf(secondParameter);

		return calculator.divide(firstInt, secondInt);
	}

}
