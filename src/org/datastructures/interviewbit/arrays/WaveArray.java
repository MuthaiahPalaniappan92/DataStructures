package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;

public class WaveArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(1);
		input.add(4);
		input.add(3);
		
		ArrayList<Integer> result = wave(input);
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		sort(A);
		if(A.size() == 1)
			return A;
		int i = 0;
		int j = 1;
		while(i < A.size() && j < A.size())
		{
			swap(A, i, j);
			i = i + 2;
			j = j + 2;
		}
		return A;
    }

	private static void sort(ArrayList<Integer> a) 
	{
		quickSort(a, 0, a.size() - 1);
	}

	private static void quickSort(ArrayList<Integer> a, int start, int end) 
	{
		if(start > end || start < 0 || end >= a.size())
			return;
		
		int pivotIndex = pivot(a, start, end);
		quickSort(a, start, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, end);
	}

	private static int pivot(ArrayList<Integer> a, int start, int end) 
	{
		int pivotIndex = start;
		int pivotValue = a.get(end);
		while(start < end)
		{
			int currentValue = a.get(start);
			if(pivotValue > currentValue)
			{
				swap(a, start, pivotIndex);
				pivotIndex++;
			}
			start++;
		}
		swap(a, end, pivotIndex);
		return pivotIndex;
	}

	private static void swap(ArrayList<Integer> a, int start, int pivotIndex) 
	{
		int temp = a.get(start);
		a.set(start, a.get(pivotIndex));
		a.set(pivotIndex, temp);
	}
}
