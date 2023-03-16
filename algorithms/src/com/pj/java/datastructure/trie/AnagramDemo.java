package com.pj.java.datastructure.trie;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramDemo {

	public static void insert(TrieNode root, String word, String originalWord) {
		TrieNode curr = root;
		for (char c: word.toCharArray()) {
			curr.child.putIfAbsent(c, new TrieNode());
			curr = curr.child.get(c);
		}
		curr.words += originalWord + " ";
	}
	
	// A recursive function that traverses a Trie in preorder fashion and
    // prints all anagrams together
    public static void printAnagrams(TrieNode root) {
    	//base case
    	if(root == null) {
    		return;
    	}
    	
    	//print the current word
    	if(root.words.length() > 1) {
    		System.out.println(root.words);
    	}
    	
    	//recur for all child nodes
    	for(TrieNode child : root.child.values()) {
    		printAnagrams(child);
    	}
    	
    }
    
 // Function to group anagrams from a given list of words
    public static void groupAnagrams(String[] words) {
    	//
    	TrieNode root = new TrieNode();
    	
    	//
    	for(String word : words) {
    		// Sort the characters of the current word and insert it into the Trie.
            // The original word gets stored in the leaf node
    		String sorted = Stream.of(word.toCharArray())
                    .map(chars -> { Arrays.sort(chars); return new String(chars); })
                    .collect(Collectors.joining());
    		
    		insert(root, sorted, word);
    	}
    	//print all anagrams together
    	printAnagrams(root);
    	
    }
	
	public static void main(String[] args) {
		
		String[] words = {
                "auctioned", "actors", "altered", "streaming", "related",
                "education", "aspired", "costar", "despair", "mastering"
        };
 
        groupAnagrams(words);

	}

}
