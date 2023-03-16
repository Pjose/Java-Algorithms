package com.pj.java.algorithms.general;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Find the minimal nucleotide from a range of sequence DNA.
 */
public class GenomeRangeQuery {

	public static void main(String[] args) {
		
		//String S = "CAGCCTA";
		String S = "A";
		//int[] P = {2, 5, 0};
		//int[] Q = {4, 5, 6};
		int[] P = {0};
		int[] Q = {0};
		//int[] result = getMinimalImpactFactor(S, P, Q);
		int[] result = getMinImpactFactor(S, P, Q);
		System.out.println(Arrays.toString(result));
		//System.out.println(Arrays.toString(solveGenomicRange(S, P, Q)));
		//System.out.println(Arrays.toString(solution(S, P, Q)));

	}
	
	private static int[] getMinImpactFactor(String S, int[] P, int[] Q) {
		int[] defaultFactors = new int[0];
		if(S.length() > 0 && P.length > 0 && Q.length > 0) {
			int N = S.length();
			int M_P = P.length;
			int M_Q = Q.length;
			for(int fact: P) {
				if(fact >= N)
					return defaultFactors;	
			}
			for(int fact: Q) {
				if(fact >= N)
					return defaultFactors;
			}
			
			if(M_P == M_Q) {
				int[][] genome = new int[3][S.length() + 1];
				int a, c, g;
				for(int i = 0; i < N; i++) {
					a = 0;
					c = 0;
					g = 0;
					if('A' == (S.charAt(i))) {
						a = 1;
					}
					if('C' == (S.charAt(i))) {
						c = 1;
					}
					if('G' == (S.charAt(i))) {
						g = 1;
					}
					//Calculate prefix sums
					genome[0][i + 1] = genome[0][i] + a;
					genome[1][i + 1] = genome[1][i] + c;
					genome[2][i + 1] = genome[2][i] + g; 
				}
				
				int[] result = new int[M_P];
				for(int i = 0; i < M_P; i++) {
					int startIndex = P[i];
					int endIndex = Q[i] + 1;
					if(genome[0][endIndex] - genome[0][startIndex] > 0) {
						result[i] = 1;
					} else if(genome[1][endIndex] - genome[1][startIndex] > 0) {
						result[i] = 2;
					} else if(genome[2][endIndex] - genome[2][startIndex] > 0) {
						result[i] = 3;
					} else {
						result[i] = 4;
					}
				}
				return result;
			}
		}
		return defaultFactors;
	}
	
	private static int[] getMinimalImpactFactor(String S, int[] P, int[] Q) {
		int[] defaultFactors = new int[0];
		if(S.length() > 0 && P.length > 0 && Q.length > 0) {
			int N = S.length();
			int M1 = P.length;
			int M2 = Q.length;
			ArrayList<String> genome = new ArrayList<String>();
			
			if(M1 == M2) {
				int[] impactFactors = new int[M1];
				int index = 0;
				for(int i = 0; i < M1; i++) { //Queries
					genome.add(S.substring(P[i], Q[i] + 1));
				}
				for(String word : genome) {
					int min = 4;
					int curr = 0;
					System.out.println(word);
					for(char c : word.toCharArray()) {
						if(c == 'A') {
							curr = 1;
						} else if(c == 'C') {
							curr = 2;
						} else if(c == 'G') {
							curr = 3;
						} else {
							curr = 4;
						}
					}
					if(curr < min) {
						min = curr;
					}
					impactFactors[index++] = min;
				}
				return impactFactors;
			}
		}
		return defaultFactors;
	}
	
	private static int[] solveGenomicRange(String S, int[] P, int[] Q) {
        //used jagged array to hold the prefix sums of each A, C and G genoms
        //we don't need to get prefix sums of T, you will see why.
        int[][] genoms = new int[3][S.length()+1];
        //if the char is found in the index i, then we set it to be 1 else they are 0
        //3 short values are needed for this reason
        short a, c, g;
        for (int i=0; i<S.length(); i++) {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i))) {
                a=1;
            }
            if ('C' == (S.charAt(i))) {
                c=1;
            }
            if ('G' == (S.charAt(i))) {
                g=1;
            }
            //here we calculate prefix sums. To learn what's prefix sums look at here https://codility.com/media/train/3-PrefixSums.pdf
            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        //here we go through the provided P[] and Q[] arrays as intervals
        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i];
            //we need to add 1 to Q[i], 
            //because our genoms[0][0], genoms[1][0] and genoms[2][0]
            //have 0 values by default, look above genoms[0][i+1] = genoms[0][i] + a; 
            int toIndex = Q[i]+1;
            if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) {
                result[i] = 1;
            } else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) {
                result[i] = 2;
            } else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
	
	private static int[] solution(String S, int[] P, int[] Q){

        int[] result = new int[P.length];

        int[] factor1 = new int[S.length()];
        int[] factor2 = new int[S.length()];
        int[] factor3 = new int[S.length()];
        int[] factor4 = new int[S.length()];

        int factor1Sum = 0;
        int factor2Sum = 0;
        int factor3Sum = 0;
        int factor4Sum = 0;

        for(int i=0; i<S.length(); i++){
            switch (S.charAt(i)) {
            case 'A':
                factor1Sum++;
                break;
            case 'C':
                factor2Sum++;
                break;
            case 'G':
                factor3Sum++;
                break;
            case 'T':
                factor4Sum++;
                break;
            default:
                break;
            }
            factor1[i] = factor1Sum;
            factor2[i] = factor2Sum;
            factor3[i] = factor3Sum;
            factor4[i] = factor4Sum;
        }

        for(int i=0; i<P.length; i++){

            int start = P[i];
            int end = Q[i];

            if(start == 0){
                if(factor1[end] > 0){
                    result[i] = 1;
                }else if(factor2[end] > 0){
                    result[i] = 2;
                }else if(factor3[end] > 0){
                    result[i] = 3;
                }else{
                    result[i] = 4;
                }
            }else{
                if(factor1[end] > factor1[start-1]){
                    result[i] = 1;
                }else if(factor2[end] > factor2[start-1]){
                    result[i] = 2;
                }else if(factor3[end] > factor3[start-1]){
                    result[i] = 3;
                }else{
                    result[i] = 4;
                }
            }
        }
        return result;
    }

}
