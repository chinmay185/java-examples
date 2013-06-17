package com.ee.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MathWorks {

	public List<Integer> filter(List<Integer> numbers, Map<String, Predicate> predicates) {
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> numbersToIterate = numbers;
		for (Map.Entry<String, Predicate> entry : predicates.entrySet()) {
			Predicate predicate = entry.getValue();
			
			for (Integer n : numbersToIterate) {
				if(predicate.filter(n)) {
					output.add(n);
				}
			}
			numbersToIterate = output;
			output = new ArrayList<Integer>();
		}

		return numbersToIterate;
	}
}
