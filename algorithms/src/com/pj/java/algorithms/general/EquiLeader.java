package com.pj.java.algorithms.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and 
 * A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 */
public class EquiLeader {

	public static void main(String[] args) {
		
		//int[] A = {4, 3, 4, 4, 4, 2};
		int[] A = { 1, 5, 1, 5, 5, 5, 5, 5 };
		System.out.println(equiLeader(A));

	}
	
	private static int equiLeader(int[] A) {
		int equiLeaders = 0;
		int N = A.length;
		Stack<Integer> candidateStack = new Stack<>();
		for(int i = 0; i < N; i++) {
			if(candidateStack.isEmpty()) {
				candidateStack.push(A[i]);
			} else {
				if(candidateStack.peek().intValue() == A[i]) {
					candidateStack.push(A[i]);
				} else {
					candidateStack.pop();
				}
			}
		}
		if(candidateStack.isEmpty()) {
			return 0;
		}
		int candidate = candidateStack.peek().intValue();
		int dominatorCount = 0;
		
		Map<Integer, Integer> dominatorMap = new HashMap<Integer, Integer>();
	    for(int i=0; i<A.length; i++) { 
	    	if(A[i] == candidate) { 
	    		dominatorCount++; 
	    		dominatorMap.put(i, dominatorCount); 
	    	} 
	    }
	    
	    if(dominatorCount > (A.length / 2)) {
	      int lastCandidateOccurenceIndex = 0;
	      int runningDominatorCount = 0;
	      for(int i=0; i<A.length-1; i++) { 
	    	  if(A[i] == candidate) { 
	    		  lastCandidateOccurenceIndex = i; 
	    		  runningDominatorCount = dominatorMap.get(i).intValue(); 
	    	  } else if(dominatorMap.get(lastCandidateOccurenceIndex) != null) { 
	    		  runningDominatorCount = dominatorMap.get(lastCandidateOccurenceIndex).intValue();
	    	  } if(runningDominatorCount > (i+1)/2) {
	          if((dominatorCount - runningDominatorCount) > (A.length - (i+1))/2 ) {
	            equiLeaders++;
	          }
	        }
	      }
	    }
	    return equiLeaders;
	}

}
