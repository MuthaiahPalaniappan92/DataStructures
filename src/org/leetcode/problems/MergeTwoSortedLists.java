package org.leetcode.problems;

import org.leetcode.problems.models.ListNode;

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l1_1 = new ListNode(2);
		l1.next = l1_1;
		ListNode l1_2 = new ListNode(4);
		l1_1.next = l1_2;
		
		ListNode l2 = new ListNode(1);
		ListNode l2_1 = new ListNode(3);
		l2.next = l2_1;
		ListNode l2_2 = new ListNode(4);
		l2_1.next = l2_2;
		
		ListNode result = mergeTwoLists(l1, l2);
	}
	
	

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode l1Copy = l1;
		ListNode l2Copy = l2;
		ListNode result = new ListNode();
		ListNode resultCopy = result;
		while(l1Copy != null && l2Copy != null)
		{
			if(l1Copy.val < l2Copy.val)
			{
				resultCopy.val = l1Copy.val;
				resultCopy.next = new ListNode();
				resultCopy = resultCopy.next;
				
				l1Copy = l1Copy.next;
			}
			else
			{
				resultCopy.val = l2Copy.val;
				resultCopy.next = new ListNode();
				resultCopy = resultCopy.next;
				
				l2Copy = l2Copy.next;
			}
		}
		
		while(l1Copy != null)
		{
			resultCopy.val = l1Copy.val;
			resultCopy.next = new ListNode();
			resultCopy = resultCopy.next;
			
			l1Copy = l1Copy.next;
		}
		
		while(l2Copy != null)
		{
			resultCopy.val = l2Copy.val;
			resultCopy.next = new ListNode();
			resultCopy = resultCopy.next;
			
			l2Copy = l2Copy.next;
		}
		
		return result;
    }
}
