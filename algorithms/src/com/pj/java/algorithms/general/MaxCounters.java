package com.pj.java.algorithms.general;

import java.util.Arrays;

/*
 * Calculate the values of counters after applying all alternating operations: 
 * increase counter by 1; set value of all counters to current maximum.
 */
public class MaxCounters {

	public static void main(String[] args) {
		
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int N = 5;
		System.out.println(Arrays.toString(getMaxCounters(N, A)));
		System.out.println(Arrays.toString(solution(N, A)));
		System.out.println(Arrays.toString(getMaxCounter(N, A)));

	}
	
	private static int[] getMaxCounter(int N, int[] A) {
		int[] counters = new int[N];
		if(A.length > 0 && N > 0) {
			int current_min = 0;
			int max = counters[0];
			for(int i = 0; i < A.length; i++) {
				//increase(X)
				if(A[i] >= 1 && A[i] <= N) {
					if(counters[A[i] - 1] < current_min) {
						counters[A[i] - 1] = current_min;
					}
					counters[(A[i] - 1)] += 1;
					if(counters[(A[i] - 1)] > max) {
						max = counters[(A[i] - 1)];
					}
				}//max counter
				else if(A[i] == N + 1) {
					current_min = max;
				}
			}
			for(int i = 0; i < N; i++){
	            if(counters[i] < current_min) {
	            	counters[i] =  current_min;
	            }
	        }
		}
		return counters;
	}
	
	private static int[] getMaxCounters(int N, int[] A) {
		int[] counters = new int[N];
		Arrays.fill(counters, 0);
		if(A.length > 0 && N > 0) {
			int max = counters[0];
			for(int i = 0; i < A.length; i++) {
				//increase(X)
				if(A[i] <= N) {
					counters[(A[i] - 1)] += 1;
					if(counters[(A[i] - 1)] > max) {
						max = counters[(A[i] - 1)];
					}
				}//max counter
				else if(A[i] == N + 1) {
					Arrays.fill(counters, max);
				}
			}
		}
		return counters;
	}
	
	private static int[] solution(int N, int[] A) {
        int counter[] = new int[N];
        int n = A.length;
        int max=-1,current_min=0;

        for(int i=0;i<n;i++){
            if(A[i]>=1 && A[i]<= N){
                if(counter[A[i] - 1] < current_min) counter[A[i] - 1] = current_min;
                counter[A[i] - 1] = counter[A[i] - 1] + 1;
                if(counter[A[i] - 1] > max) max = counter[A[i] - 1];
            }
            else if(A[i] == N+1){
                current_min = max;
            }
        }
        for(int i=0;i<N;i++){
            if(counter[i] < current_min) counter[i] =  current_min;
        }
        return counter;
    }

}
