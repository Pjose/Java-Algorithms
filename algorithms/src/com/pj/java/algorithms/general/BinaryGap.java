package com.pj.java.algorithms.general;

public class BinaryGap {

	public static void main(String[] args) {
		int n = 65;
		System.out.println(getBinaryGap(n));

	}

	private static int getBinaryGap(int n) {
		int gap = 0;
		int max = 0;
		String bits = Integer.toBinaryString(n);
		for(int i = 0; i < bits.length(); i++) {
			if(bits.charAt(i) == '0') {
				gap++;
			}
			if(bits.charAt(i) == '1' && gap > 0) {
				if(gap > max) {
					max = gap;
				}
				gap = 0;
			}
		}
		return max;
	}

}
