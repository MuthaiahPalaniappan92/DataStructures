package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;

public class FirstMissingInteger {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(0);
		System.out.println(firstMissingPositive(input));
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		input1.add(3);
		input1.add(4);
		input1.add(-1);
		input1.add(1);
		System.out.println(firstMissingPositive(input1));
		
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		input2.add(-8);
		input2.add(-7);
		input2.add(-6);
		System.out.println(firstMissingPositive(input2));
	}
	
	public static int firstMissingPositive(ArrayList<Integer> A) {
		sort(A);
		int result = 1;
		int expectedNumber = 1;
		for(Integer a: A)
		{
			if(a > 0)
			{
				if(a != expectedNumber)
					return expectedNumber;
				expectedNumber++;
			}
		}
		
		if(expectedNumber > 0)
			return expectedNumber;
		return result;
    }
	
	private static void sort(ArrayList<Integer> input)
	{
		quickSort(input, 0, input.size() - 1);
	}

	private static void quickSort(ArrayList<Integer> input, int start, int end) 
	{
		if((end - start) <= 0)
			return;
		
		int pivotIndex = pivotElementAndReturnPivotIndex(input, start, end);
		quickSort(input, start, pivotIndex - 1);
		quickSort(input, pivotIndex + 1, end);
	}

	private static int pivotElementAndReturnPivotIndex(ArrayList<Integer> input, int start, int end) 
	{
		int pivotValue = input.get(end);
		int index = start;
		for(int i = start; i <= end; i++)
		{
			if(input.get(i) <= pivotValue)
			{
				swap(input, index, i);
				index++;
			}
		}
		return index - 1;
	}

	private static void swap(ArrayList<Integer> input, int index, int i) 
	{
		int temp = input.get(index);
		input.set(index, input.get(i));
		input.set(i, temp);
		
	}
}
