package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxNonNegativeSubArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(5);
		input.add(-7);
		input.add(2);
		input.add(3);
		ArrayList<Integer> result = maxset(input);
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		input.add(-1);
		input.add(-1);
		ArrayList<Integer> result1 = maxset(input1);
		
		ArrayList<Integer> input3 = new ArrayList<Integer>();
		input3.add(336465782);
		input3.add(-278722862);
		input3.add(-2145174067);
		input3.add(1101513929);
		input3.add(1315634022);
		input3.add(-1369133069);
		input3.add(1059961393);
		input3.add(628175011);
		input3.add(-1131176229);
		input3.add(-859484421);
		ArrayList<Integer> result3 = maxset(input3);
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> subLists = buildSubArrays(A);
		if(subLists.size() == 0) return new ArrayList<Integer>();
		HashMap<Integer, Long> listIndexWithItsSum = getIndexWithItsSum(subLists);
		long maxSum = getMaxSum(listIndexWithItsSum);
		ArrayList<Integer> subListsIndexWithMaxSum = getAllSubListKeyWithMaxSum(listIndexWithItsSum, maxSum);
		if(subListsIndexWithMaxSum.size() == 1)
			return subLists.get(subListsIndexWithMaxSum.get(0));
		HashMap<Integer, Integer> listIndexWithItsSize = getIndexWithItsSize(subLists);
		int maxSize = getMaxSize(listIndexWithItsSize);
		ArrayList<Integer> subListsIndexWithMaxSize = getAllSubListKeyWithMaxSize(listIndexWithItsSize, maxSize);
		return subLists.get(subListsIndexWithMaxSize.get(0));
		
    }
	
	private static ArrayList<ArrayList<Integer>> buildSubArrays(ArrayList<Integer> input)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (Integer i : input) 
		{
			if(i >= 0)
			{
				subList.add(i);
			}
			else
			{
				if(subList.size() > 0)
				{
					result.add(subList);
					subList = new ArrayList<Integer>();
				}
			}
		}
		
		if(subList.size() > 0)
			result.add(subList);
		
		return result;
	}
	
	private static HashMap<Integer, Long> getIndexWithItsSum(ArrayList<ArrayList<Integer>> input)
	{
		HashMap<Integer, Long> listIndexWithItsSum = new HashMap<Integer, Long>();
		for(int i = 0; i < input.size(); i++)
		{
			long sum = sumList(input.get(i));
			listIndexWithItsSum.put(i, sum);
		}
		
		return listIndexWithItsSum;
	}
	
	private static ArrayList<Integer> getAllSubListKeyWithMaxSum(HashMap<Integer, Long> listIndexWithItsSum, long maxSum)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(Integer key: listIndexWithItsSum.keySet())
		{
			long currentSum = listIndexWithItsSum.get(key);
			if(currentSum == maxSum)
			{
				result.add(key);
			}
		}
		return result;
	}
	
	private static long getMaxSum(HashMap<Integer, Long> listIndexWithItsSum)
	{
		long winningSum = 0;
		for(Integer key: listIndexWithItsSum.keySet())
		{
			long currentSum = listIndexWithItsSum.get(key);
			if(currentSum > winningSum)
			{
				winningSum = currentSum;
			}
		}
		return winningSum;
	}
	
	private static HashMap<Integer, Integer> getIndexWithItsSize(ArrayList<ArrayList<Integer>> input)
	{
		HashMap<Integer, Integer> listIndexWithItsSum = new HashMap<Integer, Integer>();
		for(int i = 0; i < input.size(); i++)
		{
			int size = input.size();
			listIndexWithItsSum.put(i, size);
		}
		
		return listIndexWithItsSum;
	}
	
	private static int getMaxSize(HashMap<Integer, Integer> listIndexWithItsSize)
	{
		int winningSize = 0;
		for(Integer key: listIndexWithItsSize.keySet())
		{
			int currentSum = listIndexWithItsSize.get(key);
			if(currentSum > winningSize)
			{
				winningSize = currentSum;
			}
		}
		return winningSize;
	}
	
	private static ArrayList<Integer> getAllSubListKeyWithMaxSize(HashMap<Integer, Integer> listIndexWithItsSize, int maxSize)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(Integer key: listIndexWithItsSize.keySet())
		{
			int currentSize = listIndexWithItsSize.get(key);
			if(currentSize == maxSize)
			{
				result.add(key);
			}
		}
		return result;
	}
	
	private static long sumList(ArrayList<Integer> input)
	{
		long result = 0;
		for (Integer integer : input) {
			result += integer;
		}
		return result;
	}
}
