package org.datastructures.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualHash {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(4);
		input.add(7);
		input.add(1);
		input.add(2);
		input.add(9);
		input.add(8);
		ArrayList<Integer> result = equal(input);
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		input1.add(3);
		input1.add(4);
		input1.add(7);
		input1.add(1);
		input1.add(2);
		input1.add(9);
		input1.add(8);
		ArrayList<Integer> result1 = equal2(input);
	}

	public static ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) 
		{
			for(int j = 0; j < A.size(); j++)
			{
				for(int k = 0; k < A.size(); k++)
				{
					for(int l = 0; l < A.size(); l++)
					{
						if(i < j && k < l && i < k && j != l && j != k)
						{
							if(A.get(i) + A.get(j) == A.get(k) + A.get(l))
							{
								result.add(i);
								result.add(j);
								result.add(k);
								result.add(l);
								return result;
							}
						}
					}
				}
			}
		}
		return result;
    }
	
	public static ArrayList<Integer> equal2(ArrayList<Integer> A){
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0; i < A.size(); i++)
		{
			for(int j = i + 1; j < A.size(); j++)
			{
				int value = A.get(i) + A.get(j);
				if(map.containsKey(value))
				{
					ArrayList<Integer> temp = extractFromString(map.get(value));
					int tempI = temp.get(0);
					int tempJ = temp.get(1);
					int tempK = i;
					int tempL = j;
					if(tempI < tempJ && tempK < tempL && tempI < tempK && tempJ != tempL && tempJ != tempK)
					{
						result.add(tempI);
						result.add(tempJ);
						result.add(tempK);
						result.add(tempL);
						return result;
					}
				}
				else
				{
					map.put(value, i + "," + j);
				}
			}
		}
		
		return result;
	}
	
	private static ArrayList<Integer> extractFromString(String str)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = str.indexOf(",");
		int firstNumber = Integer.parseInt(str.substring(0, index));
		int secondNumber = Integer.parseInt(str.substring(index + 1));
		result.add(firstNumber);
		result.add(secondNumber);
		return result;
	}
}
