package com.pj.java.codility.test;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		
		int max = 5000;
		int min = 0;
		int size = 5000;
		System.out.println(Arrays.toString(generateRandomNumbers(max, min, size)));

	}
	
	private static int[] generateRandomNumbers(int max, int min, int size) {
		int[] output = new int[size];
		Random random = new Random();
		for(int i = 0; i < size; i++) {
			output[i] = random.nextInt(max - min) + min;
		}
		return output;
	}

}
