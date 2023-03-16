package com.pj.java.algorithms.general;

/*
 * Count factors of given number n.
 */
public class CountFactors {

	public static void main(String[] args) {
		
		//int N = 24;
		//int N = 100000;
		int N = 2147483647;
		System.out.println(solution(N));
		//System.out.println(getNumberOfFactors(N));
		//System.out.println(getFactorsCount(N));

	}
	
	private static int getFactorsCount(int N) {
		int count = 0;
		int i = 1;
		if(N > 0) {
			while(i * i < N) {
				if(N % i == 0)
					count += 2;
				i++; 
			}
			if(i * i == N) 
				count += 1;
		}
		return count;
	}
	
	private static int getNumberOfFactors(int N) {
		int count = 0;
		int i = 1;
		if(N > 0) {
			int[] factors = new int [N+1];
			for(i = 1; i < N+1; i++) {
				int k = i;
				while(k <= N) {
					factors[k] = (factors[k] + 1) % 2;
					k += i;
				}
				count += factors[i];
			}
		}
		return count;
	}
	
	private static int solution(int N) {
	    int factors = 0;
	    int sqrtOfN = (int) Math.sqrt(N);
	    if(Math.pow(sqrtOfN, 2) != N) {
	    	sqrtOfN++;
	    } else { 
	      factors++;
	    }
	   
	    for(int i = 1; i < sqrtOfN; i++) {
	      if(N % i == 0) {
	        factors += 2;
	      }
	    }

	    return factors;
	  }

}
