package com.pj.java.algorithms.general;

import java.util.Arrays;

/*
 * Find an index of an array such that its value occurs at more than half of indices 
 * in the array.
 */
public class Dominator {

	public static void main(String[] args) {
		
		//int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
		//int[] A = {1, 2, 2, 1};
		int[] A = {1, 2, 1};
		System.out.println(getLeader(A));
		System.out.println(solution(A));
		System.out.println(getDominator(A));

	}
	
	private static int solution(int A[]) {
		int N = A.length;
	    int candidate = 0;
	    int count = 0;
	    int i;
	    for(i = 0; i < N; i++){
	        if(count == 0) 
	        	candidate = i;

	        if(A[i] == A[candidate]) 
	        	count++;
	        else 
	        	count--;          
	    }
	    count = 0;
	    for(i = 0; i < N; i++) 
	    	if(A[i] == A[candidate]) 
	    		count++;

	    if (count <= N/2) 
	    	return -1;
	    return candidate;
	}

	
	private static int getLeader(int[] A) {
		int leader = -1;
		int N = A.length;
		if(N == 0) {
			return leader;
		}
		int count;
		int candidate;
		for(int i = 0; i < N; i++) {
			candidate = A[i];
			count = 0;
			for(int j = i ; j < N; j++) {
				if(A[j] == candidate) {
					count++;
				}
				if(count > N/2) {
					leader = i;
					return leader;
				}
			}
		}
		return leader;
	}
	
	private static int getDominator(int[] A) {
		int dominator = -1;
		int N = A.length;
		if(N == 0) {
			return dominator;
		}
		Arrays.sort(A);
		dominator = A[N/2];
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(A[i] == dominator) {
				count++;
			}
			if(count > N/2) {
				dominator = i;
				return dominator;
			}
		}
		return dominator;
	}
	
}
