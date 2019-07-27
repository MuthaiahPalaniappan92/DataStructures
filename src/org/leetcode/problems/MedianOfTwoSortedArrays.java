package org.leetcode.problems;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
		
		int[] nums3 = {1, 2};
		int[] nums4 = {3, 4};
		double result1 = findMedianSortedArrays(nums3, nums4);
		System.out.println(result1);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedArray = mergeTwoSortedArrays(nums1, nums2);
        if(sortedArray.length % 2 == 0)
        {
        	int median = sortedArray.length / 2 - 1;
        	return (((double) sortedArray[median + 1]) + ((double) sortedArray[median])) / 2;
        }
        
        int median = (int) Math.round(sortedArray.length / 2);
        return (double) sortedArray[median];
    }
	
	private static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2)
	{
		int[] result = new int[nums1.length + nums2.length];
		int currentIndex = 0;
		int nums1Index = 0;
		int nums2Index = 0;
		while(nums1Index < nums1.length && nums2Index < nums2.length)
		{
			if(nums1[nums1Index] <= nums2[nums2Index])
			{
				result[currentIndex] = nums1[nums1Index];
				nums1Index++;
			}
			else
			{
				result[currentIndex] = nums2[nums2Index];
				nums2Index++;
			}
			currentIndex++;
		}
		
		for(int i = nums1Index; i < nums1.length; i++)
		{
			result[currentIndex] = nums1[i];
			currentIndex++;
		}
		
		for(int i = nums2Index; i < nums2.length; i++)
		{
			result[currentIndex] = nums2[i];
			currentIndex++;
		}
		
		return result;
	}
}
