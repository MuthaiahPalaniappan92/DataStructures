package org.leetcode.problems;

import java.math.BigInteger;

import org.leetcode.problems.models.ListNode;

public class AddTwoList {

	public static void main(String[] args) {
		/*
		ListNode l = new ListNode(2);
		ListNode l1 = new ListNode(4);
		l.next = l1;
		ListNode l2 = new ListNode(3);
		l1.next = l2;
		
		ListNode ll = new ListNode(5);
		ListNode ll1 = new ListNode(6);
		ll.next = ll1;
		ListNode ll2 = new ListNode(4);
		ll1.next = ll2;
		
		addTwoNumbers(l, ll);
		

		ListNode l = new ListNode(8);
		ListNode l1 = new ListNode(9);
		l.next = l1;
		ListNode l2 = new ListNode(9);
		l1.next = l2;
		
		ListNode ll = new ListNode(2);
		
		addTwoNumbers(l, ll);
		
		
		ListNode l = new ListNode(9);
		
		ListNode ll = new ListNode(1);
		ListNode ll1 = new ListNode(9);
		ll.next = ll1;
		ListNode ll2 = new ListNode(9);
		ll1.next = ll2;
		ListNode ll3 = new ListNode(9);
		ll2.next = ll3;
		ListNode ll4 = new ListNode(9);
		ll3.next = ll4;
		ListNode ll5 = new ListNode(9);
		ll4.next = ll5;
		ListNode ll6 = new ListNode(9);
		ll5.next = ll6;
		ListNode ll7 = new ListNode(9);
		ll6.next = ll7;
		ListNode ll8 = new ListNode(9);
		ll7.next = ll8;
		ListNode ll9 = new ListNode(9);
		ll8.next = ll9;
		
		addTwoNumbers(l, ll);
		*/
		
		ListNode l = new ListNode(5);
		ListNode l1 = new ListNode(6);
		l.next = l1;
		ListNode l2 = new ListNode(4);
		l1.next = l2;
		
		ListNode ll = new ListNode(1);
		ListNode ll1 = new ListNode(0);
		ll.next = ll1;
		ListNode ll2 = new ListNode(0);
		ll1.next = ll2;
		ListNode ll3 = new ListNode(0);
		ll2.next = ll3;
		ListNode ll4 = new ListNode(0);
		ll3.next = ll4;
		ListNode ll5 = new ListNode(0);
		ll4.next = ll5;
		ListNode ll6 = new ListNode(0);
		ll5.next = ll6;
		ListNode ll7 = new ListNode(0);
		ll6.next = ll7;
		ListNode ll8 = new ListNode(0);
		ll7.next = ll8;
		ListNode ll9 = new ListNode(0);
		ll8.next = ll9;
		ListNode ll10 = new ListNode(0);
		ll9.next = ll10;
		ListNode ll11 = new ListNode(0);
		ll10.next = ll11;
		ListNode ll12 = new ListNode(0);
		ll11.next = ll12;
		ListNode ll13 = new ListNode(0);
		ll12.next = ll13;
		ListNode ll14 = new ListNode(0);
		ll13.next = ll14;
		ListNode ll15 = new ListNode(0);
		ll14.next = ll15;
		ListNode ll16 = new ListNode(0);
		ll15.next = ll16;
		ListNode ll17 = new ListNode(0);
		ll16.next = ll17;
		ListNode ll18 = new ListNode(0);
		ll17.next = ll18;
		ListNode ll19 = new ListNode(0);
		ll18.next = ll19;
		ListNode ll20 = new ListNode(0);
		ll19.next = ll20;
		ListNode ll21 = new ListNode(0);
		ll20.next = ll21;
		ListNode ll22 = new ListNode(0);
		ll21.next = ll22;
		ListNode ll23 = new ListNode(0);
		ll22.next = ll23;
		ListNode ll24 = new ListNode(0);
		ll23.next = ll24;
		ListNode ll25 = new ListNode(0);
		ll24.next = ll25;
		ListNode ll26 = new ListNode(0);
		ll25.next = ll26;
		ListNode ll27 = new ListNode(0);
		ll26.next = ll27;
		ListNode ll28 = new ListNode(0);
		ll27.next = ll28;
		ListNode ll29 = new ListNode(0);
		ll28.next = ll29;
		ListNode ll30 = new ListNode(0);
		ll29.next = ll30;
		
		addTwoNumbers(l, ll);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1String = reverseString(concatNodesInList(l1));
        String l2String = reverseString(concatNodesInList(l2));
        BigInteger sum = new BigInteger(l1String).add(new BigInteger(l2String));
        String sumString = sum.toString();
        
        return convertStringToListNode(sumString);
    }
	
	private static String concatNodesInList(ListNode listNode)
	{
		String result = getNodeValue(listNode);
		if(listNode.next == null)
			return result;
		
		return result + concatNodesInList(listNode.next);
	}
	
	private static String getNodeValue(ListNode listNode)
	{
		return Integer.toString(listNode.val);
	}
	
	private static String reverseString(String str)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--)
		{
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	private static ListNode convertStringToListNode(String input)
	{
		ListNode result = null;
		for(int i = input.length() - 1; i >= 0; i--)
		{
			if(result == null)
			{
				result = new ListNode(Character.getNumericValue(input.charAt(i)));
			}
			else
			{
				ListNode cuurentNode = new ListNode(Character.getNumericValue(input.charAt(i)));
				ListNode lastNode = result;
				ListNode currNode = result;
				while(lastNode.next != null)
				{
					currNode = lastNode;
					lastNode = currNode.next;
				}
				lastNode.next = cuurentNode;
			}
		}
		
		return result;
	}
	
}
