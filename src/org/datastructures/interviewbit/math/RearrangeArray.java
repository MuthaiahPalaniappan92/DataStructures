package org.datastructures.interviewbit.math;

import java.util.ArrayList;

public class RearrangeArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(3);
		input.add(4);
		input.add(1);
		input.add(2);
		arrange(input);
		for (Integer integer : input) {
			System.out.println(integer);
		}
	}
	
	public static void arrange(ArrayList<Integer> a) {
        
        int temp = 0;
        int startIndex = 0;
        while(startIndex < a.size())
        {
        	//(a[a[startIndex]] % n)*n
        	temp = ((a.get(a.get(startIndex))) % a.size()) * a.size();
        	a.set(startIndex, (a.get(startIndex) + temp) / a.size());
        	startIndex++;
        }
    }
}
