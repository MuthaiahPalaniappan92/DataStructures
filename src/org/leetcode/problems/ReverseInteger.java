package org.leetcode.problems;

public class ReverseInteger {

	public static void main(String[] args) {
		int result = reverse(123);
		System.out.println(result);
		int result1 = reverse(-123);
		System.out.println(result1);
		int result3 = reverse(120);
		System.out.println(result3);
		int result4 = reverse(0);
		System.out.println(result4);
		int result5 = reverse(1534236469);
		System.out.println(result5);
	}
	
	public static int reverse(int x) {
		
		StringBuilder sb = new StringBuilder();
        String xStr = Integer.toString(x);
        
        if(xStr.length() == 1)
        	return x;
        
        int index = 0;
        if(xStr.charAt(0) == '-')
        {
        	index = 1;
        	sb.append('-');
        }
        	
        
        for(int i = xStr.length() - 1; i >= index; i--)
        {
        	sb.append(xStr.charAt(i));
        }
        
        int result = 0;
        try {
        	result = Integer.parseInt(sb.toString().replaceAll("0+$", ""));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return result;
    }
}
