package com.pj.java.algorithms.general;

import java.util.ArrayList;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3, 1, 2, 4, 3};
		//int[] A = {3, 1};
		//int[] A = {};
		System.out.println(getDifference(A));
		System.out.println(getDiff(A));

	}
	
	private static int getDiff(int[] A) {
		int N = A.length;

	    int sum1 = A[0];
	    int sum2 = 0;
	    int P = 1;
	    for (int i = P; i < N; i++) {
	        sum2 += A[i];
	    }
	    int difference = Math.abs(sum1 - sum2);

	    for (; P < N-1; P++) {
	        sum1 += A[P];
	        sum2 -= A[P];

	        int newDiff = Math.abs(sum1 - sum2);
	        if (newDiff < difference) {
	        	difference = newDiff;
	        }
	    }
	    return difference;
	}
	
	private static int getDifference(int[] A) {
		int difference = 0;
		int min = 0;
		ArrayList<Integer> pList = new ArrayList<>();
		int sum1 = 0;
		int sum2 = 0;
		if(A.length > 0) {
			for(int i = 0; i < (A.length -1); i++) {
				sum1 += A[i];
				for(int j = (A.length - 1); j > i; j--) {
					sum2 += A[j];
				}
				difference = Math.abs(sum1 - sum2);
				pList.add(difference);
				sum2 = 0;
			}
			min = pList.get(0);
			for(Integer p: pList) {
				System.out.println("P = " + p);
				if(p < min) {
					min = p;
				}
			}
		}
		return min;
	}

}
