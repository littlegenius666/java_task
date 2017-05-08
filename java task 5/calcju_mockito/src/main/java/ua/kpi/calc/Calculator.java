package ua.kpi.calc;

import java.util.Objects;
import java.util.Optional;

public class Calculator {
	
	private static class Holder{
		private static final Calculator INSTANCE = new Calculator();
	}
	
	public static Calculator getInstance(){
		return Holder.INSTANCE;
	}

	public Integer add(Integer firstSummund, Integer secondSummund) {
		Objects.requireNonNull(firstSummund );
		Objects.requireNonNull(secondSummund);
		
		return firstSummund + secondSummund;
	}

	public Integer divide(Integer dividend, Integer divisor) {
		Objects.requireNonNull(dividend);
		Objects.requireNonNull(divisor);
		if( divisor == 0){
			throw new IllegalArgumentException();
		}
		
		return dividend / divisor;
	}

	public Optional<Integer> divideSafely(Integer dividend, Integer divisor) {
		Objects.requireNonNull(dividend);
		Objects.requireNonNull(divisor);
		
		Optional<Integer> result = Optional.empty();
		
		if( divisor != 0){
			result = Optional.of( dividend / divisor);
		}
		return result;
	}

}
