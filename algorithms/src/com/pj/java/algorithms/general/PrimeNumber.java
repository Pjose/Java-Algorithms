package com.pj.java.algorithms.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		//Use limit as max number of prime numbers
		System.out.println("Please input the limit: ");
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();

		List<Integer> primeNumbers = new ArrayList<>();
		int numberToCheck = 2;
		int count = 0;
		
		while(true) {
			boolean isPrime = true;
			for(int factor = 2; factor <= numberToCheck/2; factor++) {
				if(numberToCheck % factor == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(numberToCheck);
				primeNumbers.add(numberToCheck);
				count++;
				if(count >= limit) {
					break;
				}
			}
			numberToCheck++;
		}
	/*	System.out.println("The first " + limit + " prime numbers are: ");
		for(int number : primeNumbers) {
			System.out.println(number + " ");
		}
	*/
		scanner.close();
	}
	
	//Use limit as the max number
	public static void getPrimeNumber() {
		System.out.println("Please input the limit: ");
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();

		List<Integer> primeNumbers = new ArrayList<>();
		
		for(int numberToCheck = 2; numberToCheck <= limit; numberToCheck++) {
			boolean isPrime = true;
			for(int factor = 2; factor <= numberToCheck/2; factor++) {
				if(numberToCheck % factor == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeNumbers.add(numberToCheck);
			}
		}
		System.out.println("Prime numbers from 1 to " + limit + " are: ");
		for(int number : primeNumbers) {
			System.out.println(number + " ");
		}

		scanner.close();
	}

}
