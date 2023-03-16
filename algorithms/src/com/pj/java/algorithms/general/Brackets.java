package com.pj.java.algorithms.general;

import java.util.Stack;

/*
 * Determine whether a given string of parentheses (multiple types) is properly nested.
 */
public class Brackets {

	public static void main(String[] args) {
		
		String S = "{[()()]}";
		//String S = "([)()]";
		//String S = ")(";
		System.out.println(isProperlyNested(S));
		System.out.println(properlyNested(S));

	}
	
	private static int isProperlyNested(String S) {
		int result = 0;
		int N = S.length();
		if(N == 0)
			return 1;
		
		Stack<Character> bracketsStack = new Stack<>();
		String roundBrackets = "()";
		String squareBrackets = "[]";
		String curlyBrackets = "{}";
		for(int i = 0; i < N; i++) {
			if(S.charAt(i) == '(' || S.charAt(i) == '[' || S.charAt(i) == '{') {
				bracketsStack.add(S.charAt(i));
			} else if(S.charAt(i) == '}' || S.charAt(i) == ']' || S.charAt(i) == ')') {
				if(bracketsStack.empty()) {
					if(i == N-1)
						return 1;
					else
						return 0;
				}
				String temp = bracketsStack.peek().toString() + S.substring(i, i+1);
				if(temp.equals(curlyBrackets) || temp.equals(squareBrackets) 
						|| temp.equals(roundBrackets)) {
					bracketsStack.pop();
					if(bracketsStack.empty() && i == N-1) {
						return 1;
					}
				} else {
					return 0;
				}
			}
		}
		return result;
	}
	
	private static int properlyNested(String S) {
		int result = 0;
		int N = S.length();
		if(N == 0)
			return 1;
		
		Stack<Character> brackets = new Stack<>();
		for(int i = 0; i < N; i++) {
			char c = S.charAt(i);
			switch(c) {
				case '}':
					if(brackets.empty() || brackets.pop() != '{')
						return 0;
					break;
				case ']':
					if(brackets.empty() || brackets.pop() != '[')
						return 0;
					break;
				case ')':
					if(brackets.empty() || brackets.pop() != '(')
						return 0;
					break;
				default:
					brackets.push(c);
					break;
			}
			
		}
		result = brackets.empty()? 1 : 0;
		
		return result;
	}

}

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string; S has the form "VW" where V and W are properly nested strings. For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000]; string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")". Complexity:

expected worst-case time complexity is O(N); expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 
 */
