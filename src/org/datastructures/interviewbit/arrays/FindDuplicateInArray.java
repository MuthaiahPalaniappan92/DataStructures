package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateInArray {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(4);
		input.add(1);
		input.add(4);
		input.add(1);
		int result = repeatedNumber(input);
	}

	public static int repeatedNumber(final List<Integer> a) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer integer : a) 
		{
			if(set.contains(integer))
				return integer;
			set.add(integer);
		}
		return -1;
    }
}
