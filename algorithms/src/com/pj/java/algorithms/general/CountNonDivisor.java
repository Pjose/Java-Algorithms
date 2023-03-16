package com.pj.java.algorithms.general;

import java.util.Arrays;
import java.util.HashMap;

public class CountNonDivisor {

	public static void main(String[] args) {
		
		int[] A = {3, 1, 2, 3, 6};
		System.out.println(Arrays.toString(solution(A)));

	}
	
	private static int[] solution(int[] A) {

        int N = A.length;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i : A) {
            Integer key = count.get(i);
            if (key != null) {
                count.put(i, key + 1);
            } else {
                count.put(i, 1);
            }
        }

        HashMap<Integer, Integer> divs = new HashMap<>();
        for (Integer n : count.keySet()) {
            int sum = 0;
            int j = 1;
            while (j * j <= n) {
                if (n % j == 0) {
                    if (count.containsKey(j)) {
                        sum += count.get(j);
                    }
                    //find n = j*k cases to add both to the dividors
                    int k = n / j;
                    if (k != j) {
                        if (count.containsKey(k)) {
                            sum += count.get(k);
                        }
                    }
                }
                j++;
            }

            divs.put(n, N - sum);
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = divs.get(A[i]);
        }

        return A;
    }

}
