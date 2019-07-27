package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HotelBookingPossible {
	
	public static void main(String[] args) {
		/*
		ArrayList<Integer> arrive = new ArrayList<Integer>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(5);
		
		ArrayList<Integer> depart = new ArrayList<Integer>();
		depart.add(2);
		depart.add(6);
		depart.add(8);
		
		boolean result = hotel(arrive, depart, 1);
		System.out.println(result);
		
		ArrayList<Integer> arrive1 = new ArrayList<Integer>();
		arrive1.add(1);
		arrive1.add(2);
		arrive1.add(3);
		arrive1.add(4);
		
		ArrayList<Integer> depart1 = new ArrayList<Integer>();
		depart1.add(10);
		depart1.add(2);
		depart1.add(6);
		depart1.add(14);
		
		boolean result1 = hotel(arrive1, depart1, 2);
		System.out.println(result1);
		
		ArrayList<Integer> arrive2 = new ArrayList<Integer>();
		arrive2.add(1);
		arrive2.add(2);
		arrive2.add(3);
		
		ArrayList<Integer> depart2 = new ArrayList<Integer>();
		depart2.add(2);
		depart2.add(3);
		depart2.add(4);
		
		boolean result2 = hotel(arrive2, depart2, 1);
		System.out.println(result2);
		
		ArrayList<Integer> arrive3 = new ArrayList<Integer>();
		arrive3.add(21);
		arrive3.add(21);
		arrive3.add(45);
		arrive3.add(40);
		arrive3.add(3);
		arrive3.add(0);
		arrive3.add(13);
		arrive3.add(23);
		arrive3.add(27);
		arrive3.add(31);
		arrive3.add(16);
		arrive3.add(15);
		
		ArrayList<Integer> depart3 = new ArrayList<Integer>();
		depart3.add(49);
		depart3.add(32);
		depart3.add(65);
		depart3.add(48);
		depart3.add(30);
		depart3.add(11);
		depart3.add(57);
		depart3.add(60);
		depart3.add(72);
		depart3.add(73);
		depart3.add(22);
		depart3.add(39);
		
		boolean result3 = hotel(arrive3, depart3, 6);
		System.out.println(result3);
		
		
		int[] arrive4Array = { 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 };
		ArrayList<Integer> arrive4 = new ArrayList<Integer>();
		for (Integer integer : arrive4Array) 
		{
			arrive4.add(integer);
		}
		
		int[] depart4Array = { 28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53 };
		ArrayList<Integer> depart4 = new ArrayList<Integer>();
		for(Integer integer: depart4Array)
		{
			depart4.add(integer);
		}
		
		boolean result4 = hotel(arrive4, depart4, 23);
		System.out.println(result4);
		*/
		
		int [] arrive5Array = { 9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27 };
		ArrayList<Integer> arrive5 = new ArrayList<Integer>();
		for(Integer integer: arrive5Array)
			arrive5.add(integer);
		
		int[] depart5Array = { 32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38 };
		ArrayList<Integer> depart5 = new ArrayList<Integer>();
		for(Integer integer: depart5Array)
			depart5.add(integer);
		
		boolean result5 = hotel(arrive5, depart5, 16);
		System.out.println(result5);
		/*
		int[] arrive6Array = { 49, 8, 22, 28, 9, 15, 42, 3 };
		ArrayList<Integer> arrive6 = new ArrayList<Integer>();
		for(Integer integer: arrive6Array)
			arrive6.add(integer);
		
		int[] depart6Array = { 72, 38, 66, 51, 49, 57, 79, 30 };
		ArrayList<Integer> depart6 = new ArrayList<Integer>();
		for(Integer integer: depart6Array)
			depart6.add(integer);
		
		boolean result6 = hotel(arrive6, depart6, 2);
		System.out.println(result6);
		*/
	}

	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		sort(arrive, depart);
		handleTiesWithArriveAndUpdateDepart(arrive, depart);
		for(int i = 0; i < arrive.size(); i++)
		{
			int requiredRooms = getMergeIndex(arrive, depart, i).size();
			if(K <  requiredRooms)
				return false;
		}
		return true;
    }
	
	private static ArrayList<Integer> getMergeIndex(ArrayList<Integer> arrive, ArrayList<Integer> depart, int index)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(arrive.size() < index)
			return result;
		int max = depart.get(index);
		result.add(index);
		for(int i = index + 1; i < arrive.size(); i++)
		{
			int currentArrive = arrive.get(i);
			if(max > currentArrive)
			{		
				result.add(i);
			}
			else
			{
				return result;
			}
		}
		return result;
	}
	
	private static void sort(ArrayList<Integer> a, ArrayList<Integer> b) 
	{
		quickSort(a, 0, a.size() - 1, b);
	}

	private static void quickSort(ArrayList<Integer> a, int start, int end, ArrayList<Integer> b) 
	{
		if(start > end || start < 0 || end >= a.size())
			return;
		
		int pivotIndex = pivot(a, start, end, b);
		quickSort(a, start, pivotIndex - 1, b);
		quickSort(a, pivotIndex + 1, end, b);
	}

	private static int pivot(ArrayList<Integer> a, int start, int end, ArrayList<Integer> b) 
	{
		int pivotIndex = start;
		int pivotValue = a.get(end);
		while(start < end)
		{
			int currentValue = a.get(start);
			if(pivotValue > currentValue)
			{
				swap(a, start, pivotIndex, b);
				pivotIndex++;
			}
			start++;
		}
		swap(a, end, pivotIndex, b);
		return pivotIndex;
	}

	private static void swap(ArrayList<Integer> a, int start, int pivotIndex, ArrayList<Integer> b) 
	{
		int temp = a.get(start);
		a.set(start, a.get(pivotIndex));
		a.set(pivotIndex, temp);
		
		int temp1 = b.get(start);
		b.set(start, b.get(pivotIndex));
		b.set(pivotIndex, temp1);
	}
	
	private static void handleTiesWithArriveAndUpdateDepart(ArrayList<Integer> arrive, ArrayList<Integer> depart)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sameNumber = 0;
		for (int i = 0; i < arrive.size(); i++) 
		{
			int currentNumber = arrive.get(i);
			if(set.contains(currentNumber))
			{
				sameNumber++;
			}
			else
			{
				if(sameNumber != 0)
				{
					int startIndex = i - sameNumber - 1;
					int endIndex = i - 1;
					map.put(startIndex, endIndex);
					set.add(currentNumber);
					sameNumber = 0;
				}
				else
				{
					set.add(currentNumber);
				}
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    Integer startIndex = entry.getKey();
		    Integer endIndex = entry.getValue();
		    quickSort(depart, startIndex, endIndex);
		}
	}

	private static void quickSort(ArrayList<Integer> a, int start, int end) 
	{
		if(start > end || start < 0 || end >= a.size())
			return;
		
		int pivotIndex = pivot(a, start, end);
		quickSort(a, start, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, end);
	}

	private static int pivot(ArrayList<Integer> a, int start, int end) 
	{
		int pivotIndex = start;
		int pivotValue = a.get(end);
		while(start < end)
		{
			int currentValue = a.get(start);
			if(pivotValue > currentValue)
			{
				swap(a, start, pivotIndex);
				pivotIndex++;
			}
			start++;
		}
		swap(a, end, pivotIndex);
		return pivotIndex;
	}

	private static void swap(ArrayList<Integer> a, int start, int pivotIndex) 
	{
		int temp = a.get(start);
		a.set(start, a.get(pivotIndex));
		a.set(pivotIndex, temp);
	}
}
