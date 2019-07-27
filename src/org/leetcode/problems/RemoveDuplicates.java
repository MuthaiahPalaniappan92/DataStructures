package org.leetcode.problems;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] input = {1,1,2};
		int result = removeDuplicates(input);
		System.out.println(result);
		int[] input1 = {0,0,1,1,1,2,2,3,3,4};
		int result1 = removeDuplicates(input1);
		System.out.println(result1);
	}

	public static int removeDuplicates(int[] nums) 
	{
		if(nums.length == 0)
			return 0;
        int previousNumber = nums[0];
        int previousNumberIndex = 0;
        for(int i = 1; i < nums.length; i++)
        {
        	int currentNumber = nums[i];
        	if(previousNumber != currentNumber)
        	{
        		previousNumberIndex++;
        		nums[previousNumberIndex] = nums[i];
        		previousNumber = currentNumber;
        	}
        	else
        	{
        		ArrayUtils.remove(nums, i);
        	}
        }
        nums = Arrays.copyOf(nums, previousNumberIndex + 1);
        return nums.length;
    }
	
	/*
	 * 
	 *  if(nums.length == 0)
			return 0;
        int previousNumber = nums[0];
        int size = 1;
        for(int i = 1; i < nums.length; i++)
        {
        	int currentNumber = nums[i];
        	if(previousNumber != currentNumber)
        	{
        		size++;
        		previousNumber = currentNumber;
        	}
        }
        return size;
	 */
}
