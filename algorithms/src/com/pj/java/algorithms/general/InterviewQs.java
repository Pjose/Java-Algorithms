package com.pj.java.algorithms.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterviewQs {

	public static void main(String[] args) {
		//Question 1
		// Given entry/exit logs of customers and a cyber cafe's capacity,
	    // find the total number of customers who could not get any computer
		findCustomersNotServed();
		
		String sequence = "ABCDDCEFFEBGAG";
        int capacity = 3;
 
        System.out.println(process(sequence, capacity));
        
        String sequence2 = "ABCDDCBEFFEGAG";
        capacity = 2;
        
        findCustomersNotServed(sequence2, capacity);
        
        //Question 2
        //Frog Jump
        
        
        //Question 3
        //Sum of two
        
        
        //Question 4
        /*
         * Given r red, b blue, and g green balls, find the total number of arrangements 
         * in a row such that no two balls of the same color end up together.
         */
        int r = 2, b = 3, g = 1;
        System.out.println("The total number of distinct arrangements are "
                        + getTotalArrangements(r, b, g));

	}
	
	/*
	 * 
	 */
	private static int getTotalArrangements(int r, int b, int g){
		
		return f(r - 1, b, g, 'r') + f(r, b - 1, g, 'b') + f(r, b, g - 1, 'g');
	}
	
	public static int f(int r, int b, int g, char prev) {
		//base case: invalid number of balls
		if(r < 0 || b < 0 || g < 0) {
			return 0;
		}
		
		//base case: all balls are exhausted
		if(r == 0 && b == 0 && g == 0) {
			return 1;
		}
		
		// if the last ball was red
		if(prev == 'r') {
			return f(r, b -1, g, 'b') + f(r, b, g - 1, 'g');
		}
		
		// if the last ball was blue
		if(prev == 'b') {
			return f(r - 1, b, g, 'r') + f(r, b, g - 1, 'g');
		}
		
		// if the last ball was green
		if(prev == 'g') {
			return f(r - 1, b, g, 'r') + f(r, b - 1, g, 'b');
		}
		
		return 0;
	}
	
	/*
	 * Given an integer representing the capacity of a cyber cafe and a sequence 
	 * representing entry/exit logs of customers, find the total number of 
	 * customers who could not get any computer.
	 * Input: sequence = “ABCDDCEFFEBGAG”
 	 *		  capacity = 3
	 * 
	 * Output: 2 (Customers ‘D’ and ‘F’ left unattended)
	 */
	private static void findCustomersNotServed() {
		String[] seq = {"A","B","C","D","D","C","E","F","F","E","B","G","A","G"};
		final int CAPACITY = 3;
		
		ArrayList<String> sequence = new ArrayList<>();
		for(int i = 0; i < seq.length; i++) {
			sequence.add(seq[i]);
		}
		
		BlockingQueue<String> served = new ArrayBlockingQueue<>(CAPACITY);
		HashSet<String> notServed = new HashSet<>();
		for(String c : seq) {
			if(served.contains(c)) {
				served.remove(c);
			} else {
				if(!served.offer(c)) {
					if(served.contains(c)) {
						served.remove(c);
					} else {
						notServed.add(c);
					}
				}
			}
		}
		//2 (Customers ‘D’ and ‘F’ left unattended)
		System.out.print(notServed.size() + " (Customers");
		int count = 0;
		for(String c : notServed) {
			count++;
			if(count < notServed.size()) {
				System.out.print(" \'" + c + "\',");
			} else {
				System.out.print("and \'" + c);
			}
		}
		System.out.print("\' left unattended)");
		System.out.println();
	}
	
	// Given entry/exit logs of customers and a cyber cafe's capacity,
    // find the total number of customers who could not get any computer
    public static int process(String sequence, int capacity)
    {
        // base case
        if (sequence == null || sequence.length() == 0) {
            return 0;
        }
 
        // to store the count of unattended customers
        int unattended = 0;
 
        // keep track of the customers who were allocated computers
        Set<Character> allocated = new HashSet<>();
 
        // keep track of customers who are currently inside the cyber cafe
        // (irrespective of whether they are attended or not)
        Set<Character> visited = new HashSet<>();
 
        // traverse the given sequence
        for (char c: sequence.toCharArray())
        {
            // If a customer arrives at the cyber cafe
            if (!visited.contains(c))
            {
                // mark customer as visited
                visited.add(c);
 
                // if a computer is available, allocate it to the customer
                if (allocated.size() < capacity) {
                    allocated.add(c);
                }
                // if no computer is available, increment the unattended
                // customer's count
                else {
                    unattended++;
                }
            }
            // if a customer is leaving the cyber cafe, mark the customer as
            // unvisited and deallocate the computer
            else {
                visited.remove(c);
                allocated.remove(c);
            }
        }
 
        return unattended;
    }
    
    private static void findCustomersNotServed(String sequence, int capacity) {
		BlockingQueue<Character> served = new ArrayBlockingQueue<>(capacity);
		HashSet<Character> notServed = new HashSet<>();
		for(char c : sequence.toCharArray()) {
			if(served.contains(c)) {
				served.remove(c);
			} else {
				if(!served.offer(c)) {
					if(served.contains(c)) {
						served.remove(c);
					} else {
						notServed.add(c);
					}
				}
			}
		}
		//2 (Customers ‘D’ and ‘F’ left unattended)
		System.out.print(notServed.size() + " (Customers");
		int count = 0;
		for(Character c : notServed) {
			count++;
			if(count < notServed.size()) {
				System.out.print(" \'" + c + "\',");
			} else {
				System.out.print("and \'" + c);
			}
		}
		System.out.print("\' left unattended)");
		System.out.println();
	}
	

}
