package com.pj.java.algorithms.general;

import java.util.Arrays;
import java.util.TreeSet;

/*
 * Find the smallest positive integer that does not occur in a given sequence.
 */
public class MissingInteger {

	public static void main(String[] args) {
		
		int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1, 2, 3};
		//int[] A = {-1, -3};
		System.out.println(getMissingInteger(A));
		System.out.println(getMissingInt(A));

	}

	private static int getMissingInt(int[] A) {
		int missing = 1;
		if(A.length > 0) {
			Arrays.sort(A);
			TreeSet<Integer> set = new TreeSet<>();
			for(int num : A) {
				set.add((Integer) num);
			}
			for(Integer integer : set) {
				if((int) integer > 0) {
					if((int) integer == missing) {
						missing++;
					} else {
						return missing;
					}
				}
			}
		}
		return missing;
	}
	
	private static int getMissingInteger(int[] A) {
		int result = 1;
		int counter = 0;
		if(A.length > 0) {
			Arrays.sort(A);
			boolean isLast = true;
			for(int i = 0; i < A.length; i++) {
				if(A[i] > 0) {
					if(A[i] != ++counter) {
						result = counter;
						isLast = false;
					}
				}
			}
			if(isLast) {
				result = counter + 1;
			}
		}
		return result;
	}
}
