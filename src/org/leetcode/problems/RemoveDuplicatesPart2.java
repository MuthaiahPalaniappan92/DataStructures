package org.leetcode.problems;

import java.util.Arrays;

public class RemoveDuplicatesPart2 {

	public static void main(String[] args) {
		int[] input = {1,1,1,2,2,3};
		int result = removeDuplicates(input);
		System.out.println(result);
		int[] input1 = {0,0,1,1,1,1,2,3,3};
		int result1 = removeDuplicates(input1);
		System.out.println(result1);
	}
	
	public static int removeDuplicates(int[] nums) 
	{
		if(nums.length <= 2)
			return nums.length;
		
		int previousNumber1 = nums[0];
		int previousNumber2 = nums[1];
		int previousIndex = 1;
		for(int i = 2; i < nums.length; i++)
		{
			int currentNumber =nums[i];
			if(previousNumber1 != previousNumber2 || previousNumber1 != currentNumber || previousNumber2 != currentNumber)
			{
				previousIndex++;
				previousNumber1 = previousNumber2;
				previousNumber2 = currentNumber;
				nums[previousIndex] = nums[i];
			}
		}
		nums = Arrays.copyOf(nums, previousIndex + 1);
        return nums.length;
    }
}
