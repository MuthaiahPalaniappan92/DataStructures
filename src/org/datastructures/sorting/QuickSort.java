package org.datastructures.sorting;

public class QuickSort {

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
		quickSort(input, 0, input.length - 1);
	}

	private static void quickSort(Integer[] input, int start, int end) 
	{
		if((end - start) <= 0)
			return;
		
		int pivotIndex = pivotElementAndReturnPivotIndex(input, start, end);
		quickSort(input, start, pivotIndex - 1);
		quickSort(input, pivotIndex + 1, end);
		
	}

	private static int pivotElementAndReturnPivotIndex(Integer[] input, int start, int end) 
	{
		int pivotValue = input[end];
		int index = start;
		for(int i = start; i <= end; i++)
		{
			if(input[i] <= pivotValue)
			{
				swap(input, index, i);
				index++;
			}
		}
		return index - 1;
	}

	private static void swap(Integer[] input, int index, int i) 
	{
		int temp = input[index];
		input[index] = input[i];
		input[i] = temp;
		
	}
	
	
}
