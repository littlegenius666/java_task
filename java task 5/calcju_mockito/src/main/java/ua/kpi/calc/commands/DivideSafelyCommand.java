package ua.kpi.calc.commands;

import ua.kpi.calc.Calculator;

import java.util.Optional;

public class DivideSafelyCommand {

    private Calculator calculator = Calculator.getInstance();


    public DivideSafelyCommand(Calculator calculator) {
        this.calculator = calculator;
    }

	public Optional<Integer> execute(String firstParameter, String secondParameter) {
        Integer firstInt = Integer.valueOf(firstParameter);
        Integer secondInt = Integer.valueOf(secondParameter);

        return calculator.divideSafely(firstInt, secondInt);
	}

}
