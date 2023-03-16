package com.pj.java.algorithms.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OddOccurancesInArray {

	public static void main(String[] args) {
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		//int[] A = {};
		System.out.println(getOddOccurance(A));

	}
	
	private static int getOddOccurance(int[] A) {
		int oddOccurrance = 0;
		if(A.length > 0) {
			Map<Integer, Integer> occurance = new HashMap<>();
			for(int i = 0; i < A.length; i++) {
				if(occurance.containsKey(A[i])) {
					occurance.put(A[i], occurance.get(A[i]) + 1);
				} else {
					occurance.put(A[i], 1);
				}
			}
			for(Entry<Integer, Integer> entry : occurance.entrySet()) {
				if(entry.getValue() % 2 != 0) {
					oddOccurrance = entry.getKey();
				}
			}
		}
		return oddOccurrance;
	}

}
