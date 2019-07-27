package org.datastructures.interviewbit.arrays;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddOneToNumber {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		ArrayList<Integer> result = plusOne(input);
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		input1.add(0);
		input1.add(1);
		input1.add(2);
		input1.add(3);
		ArrayList<Integer> result1 = plusOne(input1);
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		String numberAsString = getStringFromListOfInteger(A);
		BigInteger bigInteger = new BigInteger(numberAsString);
		BigInteger bigIntegerPlusOne = bigInteger.add(new BigInteger("1"));
		return convertBigIntegerToListOfInteger(bigIntegerPlusOne);
    }

	private static ArrayList<Integer> convertBigIntegerToListOfInteger(BigInteger bigIntegerPlusOne) 
	{
		String input = bigIntegerPlusOne.toString();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < input.length(); i++)
		{
			result.add(Character.getNumericValue(input.charAt(i)));
		}
		return result;
	}

	private static String getStringFromListOfInteger(ArrayList<Integer> a) 
	{
		StringBuilder sb = new StringBuilder();
		for (Integer integer : a) 
		{
			sb.append(integer);
		}
		return sb.toString();
	}
}
