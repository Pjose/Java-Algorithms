package com.pj.java.algorithms.general;

import java.util.TreeSet;

/*
 * Compute number of distinct values in an array.
 */
public class Distinct {

	public static void main(String[] args) {
		
		//int[] A = {2, 1, 1, 2, 3, 1};
		int[] A = {2};
		System.out.println(getDistinct(A));
		
	}
	
	private static int getDistinct(int[] A) {
		int distinct = 0;
		if(A.length > 0) {
			TreeSet<Integer> set = new TreeSet<>();
			for(int num : A) {
				set.add(num);
			}
			distinct = set.size();
		}
		
		return distinct;
	}

}
