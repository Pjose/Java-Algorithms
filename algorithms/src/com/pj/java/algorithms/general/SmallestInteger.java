package com.pj.java.algorithms.general;

import java.util.TreeSet;

public class SmallestInteger {

	public static void main(String[] args) {
		
		//int[] A = {1, 3, 6, 4, 1, 2};
		int[] A = {1, 2, 3};
		//int[] A = {-1, -3};
		System.out.println(getSmallestInteger(A));

	}
	
	private static int getSmallestInteger(int[] A) {
		if(A.length == 0)
			return 1;
		TreeSet<Integer> set = new TreeSet<>();
		for(int a : A) {
			set.add(a);
		}
		int count = 1;
		for(Integer num : set) {
			if(num > 0) {
				if(num != count) {
					return count;
				}
				count++;
			}
		}
		return count;
	}

}
