package org.datastructures.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		Integer[] input = {9, 3, 7, 5, 1, 4, 0};
		sort(input);
		for(Integer i: input)
		{
			System.out.println(i);
		}
	}
	
	public static void sort(Integer[] input)
	{
		selectionSort(input, 0);
	}

	private static void selectionSort(Integer[] input, int start) 
	{
		if(input.length <= start)
			return;
		
		int minIndex = findMinValueIndex(input, start);
		swap(input, start, minIndex);
		selectionSort(input, start+1);
	}

	private static void swap(Integer[] input, int start, int minIndex) 
	{
		int temp = input[start];
		input[start] = input[minIndex];
		input[minIndex] = temp;
		
	}

	private static int findMinValueIndex(Integer[] input, int start) 
	{
		int minValue = input[start];
		int minIndex = start;
		for(int i = start; i < input.length; i++)
		{
			if(minValue > input[i])
			{
				minValue = input[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
