package com.pj.java.algorithms.general;

import java.util.Stack;

/*
 * Determine whether a given string of parentheses (single type) is properly nested.
 */
public class Nesting {

	public static void main(String[] args) {
		
		String S = "(()(())())";
		//String S = "(()(())())";
		//String S = ")(";
		System.out.println(properlyNested(S));

	}
	
	private static int properlyNested(String S) {
		int result = 0;
		int N = S.length();
		if(N == 0)
			return 1;
		
		Stack<Character> brackets = new Stack<>();
		for(int i = 0; i < N; i++) {
			char c = S.charAt(i);
			if(c == '(') {
				brackets.push(c);
			} else {
				if(brackets.isEmpty()) {
					return 0;
				} else {
					brackets.pop();
					if(brackets.isEmpty() && i == N-1) {
						return 1;
					}
				}
			}
		}
		return result;
	}

}
