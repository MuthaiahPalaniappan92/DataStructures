package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

import org.leetcode.problems.models.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_2 = new TreeNode(2);
		TreeNode root_5 = new TreeNode(5);
		root.left = root_2;
		root.right = root_5;
		TreeNode root_3 = new TreeNode(3);
		TreeNode root_4 = new TreeNode(4);
		root_2.left = root_3;
		root_2.right = root_4;
		TreeNode root_6 = new TreeNode(6);
		root_5.right = root_6;
		flatten(root);
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static void flatten(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        flatten(root, result);
        for (Integer integer : result) {
			System.out.println(integer);
		}
    }

	private static void flatten(TreeNode root, List<Integer> result) 
	{
		result.add(root.val);
		
		if(root.left == null && root.right == null)
			return;
		
		if(root.left != null)
			flatten(root.left, result);
		
		if(root.right != null)
			flatten(root.right, result);
		
	}
}
