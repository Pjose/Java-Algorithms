package com.pj.java.algorithms.general;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		//int[] A = {1, 2, 3, 4, 1, 2, 4, 5, 3};
		int X = 5;
		System.out.println(getEarliestTime(X, A));

	}
	
	private static int getEarliestTime(int X, int[] A) {
		int earliestTime = -1;
		if(A.length > 0 && X > 0) {
			int distance = (X - 1) + 1;
			Set<Integer> leafs = new HashSet<>();
			for(int i = 0; i < A.length; i++) {
				if(!leafs.contains(A[i])) {
					leafs.add(A[i]);
					distance--;
				}
				if(distance == 0) {
					earliestTime = i;
					return earliestTime;
				}
			}
		}
		return earliestTime;
	}

}
