package org.datastructures.sorting;

public class BubbleSort {

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
		int end = input.length - 1;
		while(end >= 0)
		{
			sort(input, 0, end);
			end--;
		}
	}

	private static void sort(Integer[] input, int start, int end) 
	{
		if(start == end)
			return;
		
		if(input[start] > input[start + 1])
			swap(input, start, start + 1);
			
		
		sort(input, start + 1, end);
		
	}

	private static void swap(Integer[] input, int start, int end) 
	{
		int temp = input[end];
		input[end] = input[start];
		input[start] = temp;
	}
}
