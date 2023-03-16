package com.pj.java.algorithms.general;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		
		int[] A = {4, 1, 3, 2};
		//int[] A = {4, 1, 3, 2, 1};
		System.out.println(getPermCheck(A));

	}
	
	private static int getPermCheck(int[] A) {
		int result = 1;
		if(A.length > 0) {
			Arrays.sort(A);
			for(int i = 0; i < A.length; i++) {
				if(A[i] != (i + 1)) {
					result = 0;
					return result;
				}
			}
		} else {
			result = 0;
		}
		return result;
	}

}
