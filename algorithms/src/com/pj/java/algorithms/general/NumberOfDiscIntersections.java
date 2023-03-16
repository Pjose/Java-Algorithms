package com.pj.java.algorithms.general;

/*
 * Compute the number of intersections in a sequence of discs.
 */
public class NumberOfDiscIntersections {

	public static void main(String[] args) {
		
		int[] A = {1, 5, 2, 1, 4, 0};
		System.out.println(intersections(A));

	}
	
	private static int intersections(int[] A)
	{
	    int result = 0;
	    int N = A.length;
	    int[] dps = new int[N];
	    int[] dpe = new int[N];

	    for (int i = 0, t = N - 1; i < N; i++)
	    {
	        int s = i > A[i]? i - A[i]: 0;
	        int e = t - i > A[i]? i + A[i]: t;
	        dps[s]++;
	        dpe[e]++;
	    }

	    int t = 0;
	    for (int i = 0; i < N; i++)
	    {
	        if (dps[i] > 0)
	        {
	            result += t * dps[i];
	            result += dps[i] * (dps[i] - 1) / 2;
	            if (10000000 < result) return -1;
	            t += dps[i];
	        }
	        t -= dpe[i];
	    }

	    return result;
	}

}
