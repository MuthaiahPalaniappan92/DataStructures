package org.leetcode.problems;

public class AddIntegers {

	public static void main(String[] args) {
		
		/*
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		for(int r: result)
		{
			System.out.println(r);
		}
		
		
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = twoSum(nums, target);
		for(int r: result)
		{
			System.out.println(r);
		}
		*/
		
		int[] nums = {-1, -2, -3, -4, -5};
		int target = -8;
		int[] result = twoSum(nums, target);
		for(int r: result)
		{
			System.out.println(r);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
        
		return twoSumStart(nums, 0 ,target);
    }
	
	public static int[] twoSumStart(int[] nums, int index, int target)
	{
		int[] result = twoSum(nums, index, target);
		
		if(result.length != 0)
			return result;
		
		return twoSumStart(nums, index + 1, target);
	}
	
	public static int[] twoSum(int[] nums, int index, int target)
	{
		for(int i = 0; i < nums.length; i++)
		{
			if(i == index)
				continue;
			if(nums[i] + nums[index] == target)
				return new int[] {index, i};
		}
		
		return new int[0];
	}
}
