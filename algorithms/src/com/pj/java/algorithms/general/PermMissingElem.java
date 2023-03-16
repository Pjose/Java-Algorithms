package com.pj.java.algorithms.general;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {
		//int[] A = {2, 3, 1, 5};
		int[] A = {};
		System.out.println(getMissingElem(A));

	}
	
	private static int getMissingElem(int[] A) {
		int missingElem = 1;
		if(A.length > 0) {
			Arrays.sort(A);
			for(int i : A) {
				if(i != missingElem) {
					return missingElem;
				} else {
					missingElem++;
				}
			}
			
		} 
		return missingElem;
	}

}
