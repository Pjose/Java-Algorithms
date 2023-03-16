package com.pj.java.algorithms.general;

import java.util.Arrays;
import java.util.Stack;

public class Codility2 {

	public static void main(String[] args) {
		
		int[] P = {1, 4, 1};
		int[] S = {1, 5, 1};
		System.out.println(solution(P, S));

	}
	
	private static int solution(int[] P, int[] S) {
        int result = 0;
        if(P.length != 0 || S.length != 0) {
        	Arrays.sort(S);
        	Arrays.sort(P);
        	int seatTotal = 0;
        	int ppleTotal = 0;
        	int diff = 0;
        	for(int i = S.length-1; i > 0; i--) {
        		seatTotal += S[i];
        	}
        	for(int j = P.length-1; j > 0; j--) {
				ppleTotal += P[j];
        	}
        	if(seatTotal == ppleTotal) {
        		result = S.length;
        		return result;
        	} else {
        		diff = seatTotal - ppleTotal;
        	}
        	
        	int lessCars = 0;
        	if(diff > 0) {
        		for(int s : S) {
        			if(s == diff) {
        				lessCars++;
        				diff -= s;
        				if(diff == 0)
        					break;
        			} else {
        				lessCars++;
        				diff -= s;
        				if(diff == 0)
        					break;
        			}
        		}
        		result = S.length - lessCars;
        	}
        }
        	
        	return result;
        	
/*        	Stack<Integer> seats = new Stack<>();
        	for(int s : S)
        		seats.add(s);
        	Stack<Integer> people = new Stack<>();
        	for(int p : P)
        		people.add(p);
        	for(Integer noSeat : seats) {
        		int available = noSeat;
        		available
        	}
        	
        }
        
        return result; */
    }

}
