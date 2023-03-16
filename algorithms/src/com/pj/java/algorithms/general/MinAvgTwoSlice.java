package com.pj.java.algorithms.general;

/*
 * Find the minimal average of any slice containing at least two elements.
 */
public class MinAvgTwoSlice {

	public static void main(String[] args) {
		
		int[] A = {4, 2, 2, 5, 1, 5, 8};
		//int[] A = {-100000, 100000};
		int[][] slice = { {1, 2},
				          {3, 4},
		                  {1, 4} };
		System.out.println(getMinAvgTwoSlice(A));
		System.out.println(solution(A));

	}
	
	private static int getMinAvgTwoSlice(int[] A) {
		int minAvg = 0;
		int minStartPos = 0;
		if(A.length > 1 && A.length <= 100000) {
			int N = A.length;
			int[] pf = new int[N + 2];
			for(int i = 0; i < N; i++) {
				pf[i + 1] = pf[i] + A[i];
			}
			
			int[][] slice = new int[N/2][2];
			int counter = 1;
			for(int i = 0; i < N/2; i++) {
				if(i < (N/2)-1) {
					slice[i][0] = counter++;
					slice[i][1] = counter++;
				} else {
					slice[i][0] = slice[0][0];
					slice[i][1] = counter-1;
				}
			}
			
			for(int i = 0; i < slice.length; i++) {
				int left = slice[i][0];
				int right = slice[i][1];
				int sliceTotal = pf[right + 1] - pf[left];
				int sliceAvg = sliceTotal / (right - left + 1);
				if(minAvg == 0) {
					minAvg = sliceAvg;
					minStartPos = left;
				} else {
					if(sliceAvg < minAvg) {
						minAvg = sliceAvg;
						minStartPos = left;
					}
				}
			}
		}
		
		return minStartPos;
	}
	
	private static int solution(int[] A) {
        int minAvgIdx=0;
        double minAvgVal=(A[0]+A[1])/2; //At least two elements in A.
        double currAvg;
        for(int i=0; i<A.length-2; i++){
            /**
             * We check first the two-element slice
             */
            currAvg = ((double)(A[i] + A[i+1]))/2;
            if(currAvg < minAvgVal){
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
            /**
             * We check the three-element slice
             */
            currAvg = ((double)(A[i] + A[i+1] + A[i+2]))/3;
            if(currAvg < minAvgVal){
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
        }
        /**
         * Now we have to check the remaining two elements of the array
         * Inside the for we checked ALL the three-element slices (the last one
         * began at A.length-3) and all but one two-element slice (the missing
         * one begins at A.length-2).
         */
        currAvg = ((double)(A[A.length-2] + A[A.length-1]))/2;
        if(currAvg < minAvgVal){
            minAvgVal = currAvg;
            minAvgIdx = A.length-2;
        }
        return minAvgIdx;
    }

}
