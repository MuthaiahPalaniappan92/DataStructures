package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(5);
		input.add(4);
		input.add(2);
		int result = maximumGap(input);
	}
	
	public static int maximumGap(final List<Integer> A) {
		
		if(A.size() == 1)
			return 0;
		int maxResult = -1;
		for(int i = 0; i < A.size(); i++)
		{
			for(int j = i + 1; j < A.size(); j++)
			{
				int iValue = A.get(i);
				int jValue = A.get(j);
				if(jValue >= iValue)
				{
					int currentResult = j - i;
					if(currentResult > maxResult)
						maxResult = currentResult;
				}
			}
		}
		
		return maxResult;
    }

}
