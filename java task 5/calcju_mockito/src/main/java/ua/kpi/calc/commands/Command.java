package ua.kpi.calc.commands;

@FunctionalInterface
public interface Command {
	Integer execute(String firstParameter , String secondParameter);
}
