package com.pj.java.algorithms.general;

public class FrogJump {

	public static void main(String[] args) {
		
		int X = 10;
		int Y = 85;
		int D = 30;
		System.out.println(getFrogJumps(X, Y, D));

	}
	
	private static int getFrogJumps(int X, int Y, int D) {
		int count = 0;
		int distance = Y - X;
		if(X <= Y) {
			count = (int) Math.ceil(distance/(double) D);
		}
		return count;
	}

}
