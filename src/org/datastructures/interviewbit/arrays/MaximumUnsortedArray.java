package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;

public class MaximumUnsortedArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		ArrayList<Integer> result = subUnsort(input);
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(3);
		input1.add(2);
		input1.add(4);
		input1.add(5);
		ArrayList<Integer> result1 = subUnsort(input1);
	}

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(isListSorted(A))
		{
			result.add(-1);
			return result;
		}
		sort(A);
		if(A.size() >= 1)
			result.add(A.get(0));
		if(A.size() >= 2)
			result.add(A.get(1));
		
		return result;
    }
	
	private static boolean isListSorted(ArrayList<Integer> A)
	{
		int previousNumber = A.get(A.size() - 1);
		for(int i = A.size() - 1; i >= 0; i--)
		{
			int currentNumber = A.get(i);
			if(previousNumber < currentNumber)
				return false;
			previousNumber = currentNumber;
		}
		return true;
	}
	
	private static void sort(ArrayList<Integer> A)
	{
		quickSort(A, 0, A.size() - 1);
	}

	private static void quickSort(ArrayList<Integer> a, int start, int end) 
	{
		if(start > end || start < 0 || end > a.size())
			return;
		int pivotIndex = getPivotIndex(a, start, end);
		quickSort(a, start, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, end);
		
	}

	private static int getPivotIndex(ArrayList<Integer> a, int start, int end) 
	{
		int pivotIndex = start;
		int pivotValue = a.get(end);
		for(int i = start; i < end; i++)
		{
			int currentValue = a.get(i);
			if(currentValue < pivotValue)
			{
				if(i != pivotIndex)
				{
					swap(a, i, pivotIndex);
				}
				pivotIndex++;
			}
		}
		swap(a, end, pivotIndex);
		return pivotIndex;
	}

	private static void swap(ArrayList<Integer> a, int i, int pivotIndex) 
	{
		int temp = a.get(i);
		a.set(i, a.get(pivotIndex));
		a.set(pivotIndex, temp);
		
	}
}
