package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NBy3RepeatedNumber {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(1);
		input.add(1);
		int result = repeatedNumber(input);
	}

	public static int repeatedNumber(final List<Integer> a) {
		HashMap<Integer, Integer> mapOccurence = new HashMap<Integer, Integer>();
		for (Integer integer : a) {
			if(mapOccurence.containsKey(integer))
			{
				int currentValue = mapOccurence.get(integer);
				mapOccurence.put(integer, currentValue + 1);
			}
			else
			{
				mapOccurence.put(integer, 1);
			}
		}
		
		int nBy3 = a.size() / 3;
		for(Integer key : mapOccurence.keySet())
		{
			if(mapOccurence.get(key) > nBy3)
				return key;
		}
		
		return -1;
    }
}
