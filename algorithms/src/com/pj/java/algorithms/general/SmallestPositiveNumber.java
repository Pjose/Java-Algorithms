package com.pj.java.algorithms.general;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SmallestPositiveNumber {

	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 100000;
	
	public static void main(String[] args) {
		
		int[] nums = { 1, 4, 2, -1, 6, 5 };
		int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int arr2[] = {1, 2, 3, 4};
		 
        System.out.println("The smallest missing positive number from the array is "
                + solution(nums));
        System.out.println("The smallest missing positive number from the array is "
                + solution(arr));
        System.out.println("The smallest missing positive number from the array is "
                + solution(arr2));

	}
	
	public static int solution(int[] A) {
		//int smallest = MIN_VALUE;
		int missing = 1;
		Set<Integer> treeSet = new TreeSet<>();
		for(int num : A) {
			treeSet.add((Integer) num);
		}
		
		Iterator<Integer> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			int x = (int) iterator.next();
			if(x > 0) {
				if(x == missing) {
					missing++;
				} else {
					return missing;
				}
			}
		}
		return missing;
	}

}
