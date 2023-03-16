package com.pj.java.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/*
 * Class to store a Trie Node
 */
public class TrieNode {
	
	// each node stores a map to its child nodes
	Map<Character, TrieNode> child = new HashMap<>();
	
	// stores anagrams in the leaf node
	String words = "";

}
