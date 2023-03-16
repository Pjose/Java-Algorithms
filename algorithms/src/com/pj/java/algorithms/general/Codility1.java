package com.pj.java.algorithms.general;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Codility1 {

	public static void main(String[] args) {
		
		String message = "Codility We test coders";
		int K = 14;
		System.out.println(solution(message, K));

	}
	
	private static String solution(String message, int K) {
        String output = "";
        int msgLen = message.length();
        if(msgLen == 0) {
        	return output;
        } else if(msgLen < K) {
        	return message;
        }
        
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(message, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        
        int cumulativeSize = 0;
        for(String str : tokens) {
        	if(cumulativeSize == 0) {
        		output += str + " ";
        		cumulativeSize += str.length() + 1;
        	}
        	if(cumulativeSize < K) {
        		if((cumulativeSize + str.length() + 1) < K) {
        			output += str + " ";
        		}
        	}
        }
        
        return output.trim();
    }

}
