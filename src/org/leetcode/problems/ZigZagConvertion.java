package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConvertion {
	
	public static void main(String[] args) {
		String result = convert("PAYPALISHIRING", 3);
		System.out.println(result);
		
		String result1 = convert("PAYPALISHIRING", 4);
		System.out.println(result1);
		
		String result3 = convert("AB", 1);
		System.out.println(result3);
	}

	public static String convert(String s, int numRows) {
		
		if(numRows == 1) return s;
        List<List<Character>> list = createLists(numRows);
        int listIndex = 0;
        int charIndex = 0;
        while(charIndex < s.length())
        {
        	if(listIndex < list.size() - 1)
        	{
        		list.get(listIndex).add(s.charAt(charIndex));
        		listIndex++;
        		charIndex++;
        	}
        	
        	if(listIndex == list.size() - 1)
        	{
        		if(charIndex < s.length())
        		{
        			list.get(listIndex).add(s.charAt(charIndex));
            		listIndex--;
            		charIndex++;
            		while(listIndex > 0)
            		{
            			if(charIndex < s.length())
            			{
            				list.get(listIndex).add(s.charAt(charIndex));
            				listIndex--;
            				charIndex++;
            			}
            			else
            			{
            				break;
            			}
            		}
        		}
        	}
        }
        
        String resultString = constructString(list);
        return resultString;
    }

	private static String constructString(List<List<Character>> lists) 
	{
		StringBuilder result = new StringBuilder();
		for(List<Character> list: lists)
		{
			for(Character c: list)
			{
				result.append(c);
			}
		}
		
		return result.toString();
	}

	private static List<List<Character>> createLists(int numRows) 
	{
		List<List<Character>> results = new ArrayList<List<Character>>();
		for(int i = 0; i < numRows; i++)
		{
			results.add(new ArrayList<Character>());
		}
		return results;
	}
}
