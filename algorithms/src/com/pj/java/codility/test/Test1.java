package com.pj.java.codility.test;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Implement an algorithm for cropping messages that are too long
 */
public class Test1 {

	public static void main(String[] args) {
		
		//String message = "Codility We test coders";
		String message = "Why not";
		//String message = "The quick brown fox jumps over the lazy dog";
		int K = 55;
		System.out.println(cropMessage(message, K));

	}
	
	private static String cropMessage(String message, int K) {
		String output = "";
		String space = " ";
		int strLen = message.length();
		if(strLen != 0 && K > 0) {
			ArrayList<String> tokens = new ArrayList<>();
			StringTokenizer tokenizer = new StringTokenizer(message, " ");
	        while (tokenizer.hasMoreElements()) {
	            tokens.add(tokenizer.nextToken());
	        }
	        
	        int availableSpace = K;
	        if(K > strLen) {
	        	availableSpace = strLen + 1;
	        }
	        for(String word : tokens) {
	        	int currentLength = word.length();
	        	if(currentLength < availableSpace) {
	        		if(availableSpace == K) {
	        			output += word;
	        			availableSpace -= currentLength;
	        		} else {
	        			output += space + word;
		        		availableSpace -= currentLength + 1;
	        		}
	        	} else {
	        		output = output.trim();
	        		return output;
	        	}
	        }
		}
		return output;
	}

}

/*
There is a forum that has a limit of K characters per entry. In this task your job is 
to implement an algorithm for cropping messages that are too long. You are given a 
message, consisting of English alphabet letters and spaces, that might be longer than 
the limit. Your algorithm should crop a number of words from the end of the message, 
keeping in mind that:

it may not crop away part of a word;
the output message may not end with a space;
the output message may not exceed the K-character limit;
the output message should be as long as possible.

This means that, in some cases, the algorithm may need to crop away the entire message, 
outputting an empty string.
For example, given the text: "Codility We test coders"
With K = 14 the algorithm should output: "Codility We"

Note that:
a) the output "Codility We te" would be incorrect, beacuse the original message is cropped 
through the middle of a word;
b) the output "Codility We " would be incorrect, because it ends with a space;
c) the output "Codility We test coders" would be incorrect, because it exceeds the 
K-character limit;
d) the output "Codility" would be incorrect, because it is shorter than the correct 
output.

Write a function
	class Solution { public String solution(String message, int K);
	}
	
which, given a message and an integer K, returns the message cropped to no more than 
K characters, as described above.

Examples:
1. Given message = "Codility We test coders" and K = 14, the function should return 
   "Codility We".

2. Given message = "Why not" and K = 100, the function should return "Why not".

3. Given message = "The quick brown fox jumps over the lazy dog" and K = 39, the 
   function should return "The quick brown fox jumps over the lazy".

Assume that:
K is an integer within the range[1..500];
message is a non-empty string containing at most 500 English alphabet letters and spaces. 
There are no spaces at the beginning or at the end of message; also there can't be two 
or more consecutive spaces in message.

In your solution, focus on correctness. The performance of your solution will not be 
the focus of the assessment. 
 */
