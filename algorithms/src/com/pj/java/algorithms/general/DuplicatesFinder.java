package com.pj.java.algorithms.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Given an array of n elements containing elements from 0 to n-1,
 * with any of these numbers appearing any number of times, find 
 * these repeating numbers in O(n) and using only constant memory 
 * space.
 * 
 * Given an array of n elements that contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times.
 * 		Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
 *		Output: 1, 3, 6
 */
public class DuplicatesFinder {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 6, 3, 6, 1};
		int[] array2 = {1, 2, 3, 4 ,3};
		int[] arr = { 1, 6, 3, 1, 3, 6, 6 };
		int[] arr2 = {0, 3, 1, 3, 0};
		
		
		solution(array);
		System.out.println();
		
		solution(array2);
		System.out.println();
		
		//Considering O(n) time and Constant memory space O(1)
		System.out.println("Print repeating element in O(n) time "
				+ "and using O(1) memory space.");
		printRepeating(array, 7);
		System.out.println();
		
		printRepeating(array2, 5);
		System.out.println();
		
		printRepeating(arr, 7);
		System.out.println();
		
		printRepeating(arr2, 5);
		System.out.println();
		
		//Considering O(n) time and Constant memory space O(1)
		System.out.println("Print frequency of element in O(n) time "
				+ "and using O(1) memory space.");
		int[] arr3 = { 2, 3, 3, 2, 5 };
		int[] arr4 = {4, 4, 4, 4};
		
		getFrequencyAndMissing(arr3, arr3.length);
		System.out.println("******");
		
		getFrequencyAndMissing(arr4, arr4.length);
		System.out.println("******");
		
		System.out.println("Print frequency of elements in array.");
		int[] arr5 = {10, 20, 20, 10, 10, 20, 5, 20};
		getFrequency(arr5);
		System.out.println("******");
		
	}

	/* 
	 * Given an array of n elements that contains elements from 0 to n-1, 
	 * with any of these numbers appearing any number of times.
	 * 		Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
	 *		Output: 1, 3, 6
	 */
	private static void solution(int[] array) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> dup = new HashSet<>();
		for(int num : array) {
			if(!set.add((Integer) num)){
				dup.add((Integer) num);
			}
		}
		
		Iterator<Integer> iterator = dup.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
			if(iterator.hasNext())
				System.out.print(", ");
		}
	}
	
	/*
	 * Given an array of n elements containing elements from 0 to n-1,
	 * with any of these numbers appearing any number of times, find 
	 * these repeating numbers in O(n) and using only constant memory 
	 * space.
	 */
	private static void printRepeating(int[] array, int n) {
		for(int i = 0; i < n; i++) {
			int index = array[i] % n;
			array[index] += n;
		}
		
		for(int i = 0; i < n; i++) {
			if((array[i] / n) >= 2) {
				System.out.print(i + " ");
			}
		}
	}
	
	/*
	 * Given an unsorted array of n integers that can contain integers from 1 to n. 
 	 * elements can be repeated multiple times and some other elements can
 	 * be absent from the array. Count the frequency of all elements that are 
 	 * present and print the missing elements.
	 */
	private static void getFrequencyAndMissing(int[] array, int n) {
		int[] frequency = new int[n];
		Arrays.fill(frequency, 0);
		for(int i = 0; i < n; i++) {
			frequency[array[i] - 1]++ ;
		}
		for(int i = 0; i < n; i++) {
			System.out.println(i + 1 + " -> " + frequency[i]);
		}
	}
	
	/*
	 * Given an array which may contain duplicates, print all elements and 
	 * their frequencies.
	 */
	private static void getFrequency(int[] array) {
		Map<Integer, Integer> dup = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			if(dup.containsKey(array[i])) {
				dup.put(array[i], dup.get(array[i]) + 1);
			} else {
				dup.putIfAbsent(array[i], 1);
			}	
		}
		for(Integer num : dup.keySet()) {
			System.out.println(num + " -> " + dup.get(num));
		}
	}
}
