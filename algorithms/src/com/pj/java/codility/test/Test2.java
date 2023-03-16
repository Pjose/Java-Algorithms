package com.pj.java.codility.test;

import java.util.Arrays;
import java.util.Collections;

public class Test2 {

	public static void main(String[] args) {
		
		int[] P = {1,4,1};
		int[] S = {1,5,1};
		//int[] P = {4,4,2,4};
		//int[] S = {5,5,2,5};
		//int[] P = {2,3,4,2};
		//int[] S = {2,5,7,2};
		System.out.println(redistributePeopleToCars(P, S));

	}
	
	private static int redistributePeopleToCars(int[] P, int[] S) {
		int result = 0;
		int pLength = P.length;
		int sLength = S.length;
		if(pLength != 0 || sLength != 0 || pLength <= sLength) {

			//Calculate number of people
			int[] pTotal = new int[pLength + 1];
			int availPeople = 0;
			pTotal[0] = 0; 
			for(int p = 0; p < pLength; p++) {
				pTotal[p+1] = pTotal[p] + P[p];
			}
			availPeople = pTotal[pLength];
			
			//Reverse Sort available seats in decreasing order
			int[] copyS = Arrays.stream(S).boxed()
					.sorted(Collections.reverseOrder())
					.mapToInt(Integer::intValue)
					.toArray();
			
			for(int i = 0; i < sLength; i++) {
				availPeople -= copyS[i];
				result++;
				if(availPeople <= 0) {
					return result;
				}
			}
		}
		return result;
	}

}

/*
A group of friends is going on holiday together. They have come to a meeting point (the 
start of the journey) using N cars. There are P[K] people and S[K] seats in the K-th car 
in range [0..N-1]. Some of the seats in the cars may be free, so it it possible for some 
of the friends to change the car they are in. The friends have decided that, in order to 
be ecological, they will leaves some cars parked at the meeting point and travel with as 
few cars as possible.

Write a function:
	class Solution { public int solution(int[] P, int[] S); }
	
that, given two arrays P and S, consisting of N integers each, returns the minimum number 
of cars needed to take all of the friends on holiday.

Examples:

1. Given P = [1,4,1] and S = [1,5,1], the function should return 2. A person from car 
numbger 0 can travel in car number 1 instead. This way, car number 0 can be left parked 
at the meeting point.

2. Given P = [4,4,2,4] and S = [5,5,2,5], the function should return 3. One person from 
car number 2 can travel in car number 0 and the other person from car number 2 can travel 
in car number 3.

3. Given P = [2,3,4,2] and S = [2,5,7,2], the function should return 2. Passengers from 
car number 0 can travel in car number 1 and passengers from car number 3 can travel in 
car number 2.

Write an efficient algorithm for the following assumptions:
a) N is an integer within the range [1..100,000];
b) each element of arrays P and S is an integer within the range [1..9];
c) every friend had a seat in the car they came in; that is, P[K] <= S[K] for each K within 
the range [0..N-1].
*/