package org.leetcode.problems;

public class LongestPalindrome {

	public static void main(String[] args) {
		String input1 = "babad";
		String result1 = longestPalindrome(input1);
		System.out.println(result1);
		
		String input2 = "cbbd";
		String result2 = longestPalindrome(input2);
		System.out.println(result2);
		
		String input3 = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
		String result3 = longestPalindrome(input3);
		System.out.println(result3);
	}
	
	public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++)
        {
        	for(int j = s.length(); j >= longestPalindrome.length(); j--)
        	{
        		String subString = s.substring(i, j);
        		if(subString.length() <= longestPalindrome.length())
        			break;
        		if(isPalindrome(subString))
        		{
        			longestPalindrome = subString;
        			break;
        		}
        	}
        }
        
        return longestPalindrome;
    }
	
	private static boolean isPalindrome(String s)
	{
		if(s.contentEquals(reverseString(s)))
			return true;
		
		return false;
	}
	
	private static String reverseString(String s)
	{
		StringBuilder reverStringBuilder = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--)
		{
			reverStringBuilder.append(s.charAt(i));
		}
		return reverStringBuilder.toString();
	}
}
