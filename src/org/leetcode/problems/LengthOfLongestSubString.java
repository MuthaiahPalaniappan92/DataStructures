package org.leetcode.problems;

import java.util.LinkedHashSet;

public class LengthOfLongestSubString {
	
	public static void main(String[] args) {
		String input1 = "abcabcbb";
		int result1 = lengthOfLongestSubstring(input1);
		System.out.println(result1);
		
		String input2 = "bbbbb";
		int result2 = lengthOfLongestSubstring(input2);
		System.out.println(result2);
		
		String input3 = "pwwkew";
		int result3 = lengthOfLongestSubstring(input3);
		System.out.println(result3);
		
		String input4 = "dvdf";
		int result4 = lengthOfLongestSubstring(input4);
		System.out.println(result4);
		
		String input5 = "ohomm";
		int result5 = lengthOfLongestSubstring(input5);
		System.out.println(result5);
	}

	public static int lengthOfLongestSubstring(String s) {
        
		String longestSubStringWithNoRepeats = "";
		LinkedHashSet<Character> currentSubStringCharacters = new LinkedHashSet<Character>();
		for(int i = 0; i < s.length(); i++)
		{
			if(currentSubStringCharacters.contains(s.charAt(i)))
			{
				if(currentSubStringCharacters.size() > longestSubStringWithNoRepeats.length())
				{
					longestSubStringWithNoRepeats = convertMapToString(currentSubStringCharacters);
				}
				
				currentSubStringCharacters = copySetToNewSet(currentSubStringCharacters, s.charAt(i));
				currentSubStringCharacters.add(s.charAt(i));
			}
			else
			{
				currentSubStringCharacters.add(s.charAt(i));
			}
		}
		
		return (currentSubStringCharacters.size() > longestSubStringWithNoRepeats.length()) ? 
					currentSubStringCharacters.size() :
					longestSubStringWithNoRepeats.length();
    }
	
	private static LinkedHashSet<Character> copySetToNewSet(LinkedHashSet<Character> input, Character characterLookingFor)
	{
		LinkedHashSet<Character> result = new LinkedHashSet<Character>();
		boolean isCharacterFound = false;
		for(Character c: input)
		{
			if(!isCharacterFound)
			{
				if(c == characterLookingFor)
				{
					isCharacterFound = true;
				}
				continue;
			}
			else
			{
				result.add(c);
			}
		}
		return result;
	}

	private static String convertMapToString(LinkedHashSet<Character> input) 
	{
		StringBuilder sb = new StringBuilder();
		for(Character c: input)
		{
			sb.append(c);
		}
		
		return sb.toString();
	}
}
