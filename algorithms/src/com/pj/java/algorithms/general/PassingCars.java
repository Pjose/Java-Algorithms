package com.pj.java.algorithms.general;

/*
 * Count the number of passing cars on the road.
 */
public class PassingCars {

	public static void main(String[] args) {
		
		int[] A = {0, 1, 0, 1, 1};
		System.out.println(getPassingCars(A));

	}
	
	private static int getPassingCars(int[] A) {
		int passingCars = 0;
		int eastBound = 0;
		for(int num : A) {
			if(num == 0) {
				eastBound++;
			} else {
				passingCars += eastBound;
				if(passingCars > 1000000000) {
					return -1;
				}
			}
		}
		return passingCars;
	}

}
