package com.pj.java.algorithms.general;

public class CyclicRotation {

	public static void main(String[] args) {
		
		int[] A = {3, 8, 9, 7, 6};
		int K = 3;
		int[] result = new int[A.length];
		result = getCyclicRotation(A, K);
		System.out.print("[");
		for(int i = 0; i < result.length; i++) {
			if(i < result.length - 1) {
				System.out.print(result[i] + ", ");
			} else {
				System.out.print(result[i]);
			}
		}
		System.out.print("]");

	}
	
	private static int[] getCyclicRotation(int[] A, int K) {
		if(A.length > 0) {
			int[] rotated = new int[A.length];
			for(int j = 0; j < A.length; j++) {
				rotated[j] = A[j];
			}
			
			for(int i = 0; i < K; i++) {
				int temp = rotated[A.length - 1];
				for(int j = A.length - 1; j > 0; j--) {
					rotated[j] = rotated[j - 1];
				}
				rotated[0] = temp;
			}
			return rotated;
		} else {
			return A;
		}
	}

}
