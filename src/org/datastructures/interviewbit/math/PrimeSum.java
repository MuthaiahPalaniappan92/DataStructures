package org.datastructures.interviewbit.math;

import java.util.ArrayList;

public class PrimeSum {
	
	public static void main(String[] args) {
		int input = 4;
		ArrayList<Integer> result = primesum(input);
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		
		int input1 = 150;
		ArrayList<Integer> result1 = primesum(input1);
		System.out.println(result1.get(0));
		System.out.println(result1.get(1));
		
		int input2 = 200;
		ArrayList<Integer> result2 = primesum(input2);
		System.out.println(result2.get(0));
		System.out.println(result2.get(0));
	}

	public static ArrayList<Integer> primesum(int A) {
		ArrayList<ArrayList<Integer>> resultWrapper = new ArrayList<ArrayList<Integer>>();
		for(int i = A - 1; i >= 0; i--)
		{
			int anotherValue = A - i;
			if(isPrime(i))
			{
				if(isPrime(anotherValue))
				{
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(anotherValue);
					result.add(i);
					resultWrapper.add(result);
				}
			}
		}
		
		return resultWrapper.get(0);
    }

	private static boolean isPrime(int number) 
	{
		if(number == 1)
			return false;
		if (number == 2 || number == 3)
            return true;
        if (number % 2 == 0)
            return false;
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
	}
	
	private static ArrayList<Integer> reArrange(ArrayList<Integer> input)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(input.get(0) < input.get(1))
		{
			result.add(input.get(0));
			result.add(input.get(1));
		}
		else
		{
			result.add(input.get(1));
			result.add(input.get(0));
		}
		
		return result;
	}
}
