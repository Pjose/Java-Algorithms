package com.pj.java.codility.test;

public class AlgorithmTimer {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		System.out.println();

		long endTime = System.currentTimeMillis();
		double duration = (endTime - startTime);
		
		System.out.println("That took " + duration + " milliseconds");
		System.out.println("That took " + ((duration / 1000) % 60) + " seconds");

	}
	
}
