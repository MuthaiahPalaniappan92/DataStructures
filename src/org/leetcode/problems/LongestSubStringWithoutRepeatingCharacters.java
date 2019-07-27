package org.leetcode.problems;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String input = "abcabcb";
		int result = lengthOfLongestSubstring(input);
		String input1 = "bbbbb";
		int result1 = lengthOfLongestSubstring(input1);
		String input2 = "pwwkew";
		int result2 = lengthOfLongestSubstring(input2);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        String longestSubString = findLongestSubStringWithoutRepeatingCharacters(s);
        return longestSubString.length();
    }

	private static String findLongestSubStringWithoutRepeatingCharacters(String s) 
	{
		HashMap<Character, Integer> characterWithItsIndex = new HashMap<Character, Integer>();
		String longestSubString = "";
		int i = 0;
		while(i < s.length())
		{
			char currentCharacter = s.charAt(i);
			if(characterWithItsIndex.containsKey(currentCharacter))
			{
				if(longestSubString.length() < characterWithItsIndex.size())
					longestSubString = convertMapKeysToString(characterWithItsIndex);
				i = characterWithItsIndex.get(currentCharacter);
				characterWithItsIndex = new HashMap<Character, Integer>();
			}
			else
			{
				characterWithItsIndex.put(currentCharacter, i);
			}
			i++;
		}
		
		if(longestSubString.length() < characterWithItsIndex.size())
			longestSubString = convertMapKeysToString(characterWithItsIndex);
		return longestSubString;
	}
	
	private static String convertMapKeysToString(HashMap<Character, Integer> characterWithItsIndex) {
		StringBuilder sb = new StringBuilder();
		for(Character c: characterWithItsIndex.keySet())
		{
			sb.append(c);
		}
		return sb.toString();
	}
}
