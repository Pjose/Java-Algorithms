package com.pj.java.algorithms.general;

/*
 * Compute number of integers divisible by k in range [a..b].
 */
public class CountDiv {

	public static void main(String[] args) {
		//[0, 2000000000, 1]
		int A = 16;
		int B = 346;
		int K = 17;
		//System.out.println(getCountDiv(A, B, K));
		System.out.println(solution(A, B, K));
		System.out.println(countDivisors(A, B, K));
		System.out.println(solution2(A, B, K));
	}
	
	private static int getCountDiv(int A, int B, int K) {
		int div = 0;
		if(A <= B && A >= 0 && B >= 0 && A <= 2000000000 && B <= 2000000000
				&& K >= 1 && K <= 2000000000) {
			for(int i = A; i <= B; i++) {
				if(i % K == 0) {
					div++;
				}
			}
		}
		return div;
	}
	
	private static int solution(int A, int B, int K) {
        return B / K - A / K + (A % K == 0 ? 1 : 0);
    }
	
	private static int countDivisors(int A, int B, int K) {
	    int count = (B - A) / K;
	    if (A % K == 0 || B % K == 0)
	        count++;
	    return count;
	}
	
	private static int solution2(int A, int B, int K) {
	    int firstDividableInRange = A % K == 0 ? A : A + (K - A % K);
	    int lastDividableInRange = B - B % K;
	    int result = (lastDividableInRange - firstDividableInRange) / K + 1;

	return result;
	}

}
