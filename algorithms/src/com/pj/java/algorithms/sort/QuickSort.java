package com.pj.java.algorithms.sort;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int size = 20;
		int[] array = new int[size];
		Random random = new Random();
		for(int i = 0; i < size; i++) {
			array[i] = random.nextInt(1000);
		}
		
		System.out.println("Before sorting: ");
		printArray(array);
		
		quickSort(array);
		
		System.out.println("After sorting: ");
		printArray(array);
	}

	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int lowIndex, int highIndex) {
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, highIndex);
		
		int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		quickSort(array, lowIndex, leftPointer - 1);
		quickSort(array, leftPointer + 1, highIndex);
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);
		}
		
		swap(array, leftPointer, highIndex);
		return leftPointer;
	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void printArray(int[] array) {
		for(int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
