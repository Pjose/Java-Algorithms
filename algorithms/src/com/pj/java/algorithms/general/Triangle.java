package com.pj.java.algorithms.general;

import java.util.Arrays;

/*
 * Determine whether a triangle can be built from a given set of edges.
 */
public class Triangle {

	public static void main(String[] args) {
		
		int[] A = {10, 2, 5, 1, 8, 20};
		//int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//int[] A = {5, 6, 11};
		//int[] A = {10, 50, 5, 1};
		System.out.println(isTriangular(A));
		System.out.println(getTriangle(A));
		System.out.println(checkTriangle(A));

	}
	
	private static int isTriangular(int[] A) {
		int result = 0;
		int N = A.length;
		if(N > 2) {
			int P, Q, R;
			for(int i = 0; i < N - 2; i++) {
				P = A[i];
				Q = A[i+1];
				R = A[i+2];
				if(P+Q > R) {
					if(P+R > Q) {
						if(R+Q > P)
							result = 1;
					}
				}
			}
			//cyclic 1
			P = A[0];
			Q = A[1];
			R = A[N-1];
			if(P+Q > R) {
				if(P+R > Q) {
					if(R+Q > P)
						result = 1;
				}
			}
			
			//cyclic 2
			P = A[0];
			Q = A[N-1];
			R = A[N-2];
			if(P+Q > R) {
				if(P+R > Q) {
					if(R+Q > P)
						result = 1;
				}
			}
			
		}
		
		return result;
	}
	
	private static int getTriangle(int[] A) {
		int result = 0;
		int N = A.length;
		if(N > 2) {
			int P, Q, R;
			Arrays.sort(A);
			for(int i = 0; i < N - 2; i++) {
				P = A[i];
				Q = A[i+1];
				R = A[i+2];
				if(P+Q > R) {
					if(P+R > Q) {
						if(R+Q > P)
							result = 1;
					}
				}
			}
		}
		return result;
	}
	
	private static int checkTriangle(int[] A) {
		int result = 0;
		int N = A.length;
		if(N > 2) {
			int P, Q, R;
			Arrays.sort(A);
			for(int i = 0; i < N - 2; i++) {
				P = A[i];
				Q = A[i+1];
				R = A[i+2];
				if(P >= 0 && P > R - Q) {
					return 1;
				}
			}
		}
		return result;
	}

}



