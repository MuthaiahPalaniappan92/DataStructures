package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubArray {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(-2);
		input.add(1);
		input.add(-3);
		input.add(4);
		input.add(-1);
		input.add(2);
		input.add(1);
		input.add(-5);
		input.add(4);
		int result = maxSubArray(input);
	}

	public static int maxSubArray(final List<Integer> A) {
		
		int maxSum = A.get(0);
		for(int start = 0; start < A.size(); start++)
		{
			int currentSum = 0;
			currentSum += A.get(start);
			if(maxSum < currentSum)
			{
				maxSum = currentSum;
			}
			for(int end = start + 1; end < A.size(); end++)
			{
				currentSum += A.get(end);
				if(maxSum < currentSum)
				{
					maxSum = currentSum;
				}
			}
		}
		
		return maxSum;
    }
}
