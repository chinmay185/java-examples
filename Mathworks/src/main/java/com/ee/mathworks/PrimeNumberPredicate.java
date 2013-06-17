package com.ee.mathworks;

import static java.lang.Math.sqrt;

public class PrimeNumberPredicate implements Predicate {

	@Override
	public boolean filter(int n) {
		boolean prime = false;
		if (n == 2)
			return true;
		if (n == 1)
			return false;

		for (int i = 2; i < sqrt(n) + 1; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			} else
				prime = true;
		}

		return prime;

	}

}
