package org.datastructures.sorting;

import java.util.Arrays;

public class MergeSort {

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
		if(input.length <= 1)
			return;
		
		int inputLength = input.length;
		int inputMedian = inputLength / 2;
		
		Integer[] firstArray = Arrays.copyOf(input, inputMedian);
		Integer[] secondArray = Arrays.copyOfRange(input, inputMedian, inputLength);
		
		sort(firstArray);
		sort(secondArray);
		sortArrays(firstArray, secondArray, input);
	}

	private static void sortArrays(Integer[] firstArray, Integer[] secondArray, Integer[] input) {
		
		int resultIndex = 0;
		int firstArrayIndex = 0;
		int secondArrayIndex = 0;
		
		while(firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length)
		{
			if(firstArray[firstArrayIndex] < secondArray[secondArrayIndex])
			{
				input[resultIndex] = firstArray[firstArrayIndex];
				firstArrayIndex++;
			}
			else
			{
				input[resultIndex] = secondArray[secondArrayIndex];
				secondArrayIndex++;
			}
			resultIndex++;
		}
		
		for(int i = firstArrayIndex; i < firstArray.length; i++)
		{
			input[resultIndex] = firstArray[i];
			resultIndex++;
		}
		
		for(int i = secondArrayIndex; i < secondArray.length; i++)
		{
			input[resultIndex] = secondArray[i];
			resultIndex++;
		}
	}
}
