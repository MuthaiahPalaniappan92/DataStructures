package org.datastructures.sorting;

import java.util.ArrayList;

public class QuickSortArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(1);
		input.add(1);
		input.add(4);
		sort(input);
		for(Integer i: input)
		{
			System.out.println(i);
		}
	}
	
	public static void sort(ArrayList<Integer> input)
	{
		quickSort(input, 0, input.size() - 1);
	}

	private static void quickSort(ArrayList<Integer> input, int start, int end) 
	{
		if(start > end || end >= input.size() || start < 0)
			return ;
		
		int pivotIndex = pivot(input, start, end);
		quickSort(input, start, pivotIndex - 1);
		quickSort(input, pivotIndex + 1, end);
	}

	private static int pivot(ArrayList<Integer> input, int start, int end) 
	{
		int pivotValue = input.get(end);
		int pivotIndex = start;
		for(int i = start; i < end; i++)
		{
			if(pivotValue >= input.get(i))
			{
				swap(input, i, pivotIndex);
				pivotIndex++;
			}
		}
		swap(input, end, pivotIndex);
		return pivotIndex;
	}

	private static void swap(ArrayList<Integer> input, int i, int pivotIndex) 
	{
		int temp = input.get(i);
		input.set(i, input.get(pivotIndex));
		input.set(pivotIndex, temp);
		
	}
}
