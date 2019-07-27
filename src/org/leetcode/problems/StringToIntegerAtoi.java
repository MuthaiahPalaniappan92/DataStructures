package org.leetcode.problems;

import java.util.HashSet;

public class StringToIntegerAtoi {

	public static void main(String[] args) {
		int result = myAtoi("42");
		System.out.println(result);
		int result1 = myAtoi("-42");
		System.out.println(result1);
		int result2 = myAtoi("4193 with words");
		System.out.println(result2);
		int result3 = myAtoi("words and 987");
		System.out.println(result3);
		int result4 = myAtoi("-91283472332");
		System.out.println(result4);
		int result5 = myAtoi(" -41");
		System.out.println(result5);
		int result6 = myAtoi("+2");
		System.out.println(result6);
		int result7 = myAtoi("+-2");
		System.out.println(result7);
	}
	
	public static int myAtoi(String str) {
        
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = GetNumericSet();
		for(int i = 0; i < str.length(); i++)
		{
			if(set.contains(str.charAt(i)))
			{
				if(str.charAt(i) == ' ')
					continue;
				sb.append(str.charAt(i));
			}
			else
			{
				break;
			}
		}
		
		if(sb.toString().equals(""))
		{
			return 0;
		}
		else if(sb.toString().equals("-") || sb.toString().equals("+"))
		{
			return 0;
		}
		else if(sb.toString().contains("+") && sb.toString().contains("-"))
		{
			return 0;
		}
		else
		{
			try {
				return Integer.parseInt(sb.toString());
			} catch (Exception e) {
				return -2147483648;
			}
		}
    }
	
	private static HashSet<Character> GetNumericSet()
	{
		HashSet<Character> set = new HashSet<Character>();
		set.add('1');
		set.add('2');
		set.add('3');
		set.add('4');
		set.add('5');
		set.add('6');
		set.add('7');
		set.add('8');
		set.add('9');
		set.add('0');
		set.add('-');
		set.add(' ');
		set.add('+');
		return set;
	}
}
