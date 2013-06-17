package com.ee.mathworks;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import static java.util.Arrays.*;

public class MathWorksSpec {

	private MathWorks mathWorks;
	private List<Integer> numbers; 
	private static final String EVEN = "even";
	private static final String PRIME = "prime";
	private static final String MULTIPLE_OF_5 = "multipleOf5";
	
	@Before
	public void setup(){
		mathWorks = new MathWorks();
		numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			numbers.add(i);
		}
	}

	@Test
	public void itFilterEvenNumbers() {
		// given
		List<Integer> expectedEvens = asList(2, 4, 6, 8, 12,10,14, 16, 18, 20);
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		predicates.put(EVEN, new EvenNumberPredicate());

		// when
		List<Integer> actualEvens = mathWorks.filter(numbers, predicates);

		// then
		for(Integer n : expectedEvens) {
			Assert.assertTrue(actualEvens.contains(n));
		}
	}
	
	@Test
	public void itFilterPrimeNumbers() {
		// given
		List<Integer> expectedPrimes = asList(2, 3, 5, 7, 11, 13, 17, 19);
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		predicates.put(PRIME, new PrimeNumberPredicate());

		// when
		List<Integer> actualPrimeOutput = mathWorks.filter(numbers, predicates);

		// then
		assertEquals(expectedPrimes, actualPrimeOutput);
	}

	@Test
	public void itFilterMultiplesOf5() {
		// given
		List<Integer> expectedMultiplesOf5 = asList(5, 10, 15, 20);
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		predicates.put(MULTIPLE_OF_5, new MultipleOf5Predicate());

		// when
		List<Integer> actualMultiplesOf5 = mathWorks.filter(numbers, predicates);

		// then
		Assert.assertEquals(expectedMultiplesOf5, actualMultiplesOf5);
	}

	@Test
	public void itFilterEvenPrimeNumbers() {
		// given
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		predicates.put("even", new EvenNumberPredicate());
		predicates.put("prime", new PrimeNumberPredicate());
		List<Integer> expectedEvenPrimes = Arrays.asList(2);

		// when
		List<Integer> actualEvenPrimes  = mathWorks.filter(numbers, predicates);

		// then
		assertEquals(expectedEvenPrimes, actualEvenPrimes);
	}
	
	@Test
	public void itFiltersNumbersBasedOnPredicates() {
		// given
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		predicates.put("even", new EvenNumberPredicate());
		predicates.put("prime", new PrimeNumberPredicate());
		List<Integer> expectedEvenPrimes = Arrays.asList(2);
		
		// when
		List<Integer> actualEvenPrimes = mathWorks.filter(numbers, predicates);
		
		// then
		assertEquals(expectedEvenPrimes, actualEvenPrimes);
		
	}

}
