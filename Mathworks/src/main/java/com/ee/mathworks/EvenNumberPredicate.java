package com.ee.mathworks;

public class EvenNumberPredicate implements Predicate {

	@Override
	public boolean filter(int number) {
		return number % 2 == 0;
	}

}
