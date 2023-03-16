package com.pj.java.algorithms.general;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * N voracious fish are moving along a river. Calculate how many fish are alive.
 */
public class Fish {

	public static void main(String[] args) {
		
		int[] A = {4, 3, 2, 1, 5};
		int[] B = {0, 1, 0, 0, 0};
		System.out.println(howManyFishAlive(A, B));

	}
	
	private static int howManyFishAlive(int[] A, int[] B) {
		int N = A.length;
		int numOfFishes = N;
		if(N == 0)
			return 0;
		
		Deque<Integer> downStream = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			if(B[i] == 1) {
				downStream.push(A[i]);
			} else {
				while(!downStream.isEmpty()) {
					if(downStream.peek() > A[i]) {
						numOfFishes--;
						break;
					} else {
						numOfFishes--;
						downStream.pop();
					}
				}
			}
		}
		return numOfFishes;
	}

}

/*
 * 
 *
 */

