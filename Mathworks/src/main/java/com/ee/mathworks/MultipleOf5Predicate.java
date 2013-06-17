package com.ee.mathworks;

public class MultipleOf5Predicate implements Predicate {

	@Override
	public boolean filter(int number) {
		return number % 5 == 0;
	}

}
