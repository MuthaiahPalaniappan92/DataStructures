package org.datastructures.interviewbit.arrays;

import java.util.ArrayList;

import org.datastructures.interviewbit.arrays.models.Interval;

public class MergeIntervals {
	
	public static void main(String[] args) {
		
		/*
		ArrayList<Interval> input1 = new ArrayList<Interval>();
		input1.add(new Interval(1, 3));
		input1.add(new Interval(6, 9));
		
		ArrayList<Interval> result1 = insert(input1, new Interval(2, 5));
		for(Interval interval: result1)
		{
			System.out.println(interval.start);
			System.out.println(interval.end);
			System.out.println("------------");
		}
		System.out.println("Hello");
		
		
		
		
		System.out.println("Hello");
		
		
		ArrayList<Interval> input3 = new ArrayList<Interval>();
		input3.add(new Interval(3, 6));
		input3.add(new Interval(8, 10));
		
		ArrayList<Interval> result3 = insert(input3, new Interval(1, 2));
		for(Interval interval: result3)
		{
			System.out.println(interval.start);
			System.out.println(interval.end);
			System.out.println("------------");
		}
		
		ArrayList<Interval> input4 = new ArrayList<Interval>();
		input4.add(new Interval(1, 2));
		input4.add(new Interval(3, 6));
		
		ArrayList<Interval> result4 = insert(input4, new Interval(8, 10));
		for(Interval interval: result4)
		{
			System.out.println(interval.start);
			System.out.println(interval.end);
			System.out.println("------------");
		}
		
		
		ArrayList<Interval> input5 = new ArrayList<Interval>();
		input5.add(new Interval(3, 5));
		input5.add(new Interval(7, 9));
		
		ArrayList<Interval> result5 = insert(input5, new Interval(1,12));
		for(Interval result: result5)
		{
			System.out.println(result.start);
			System.out.println(result.end);
			System.out.println("------------");
		}
		
		
		
		ArrayList<Interval> input2 = new ArrayList<Interval>();
		input2.add(new Interval(1, 2));
		input2.add(new Interval(3, 5));
		input2.add(new Interval(6, 7));
		input2.add(new Interval(8, 10));
		input2.add(new Interval(12, 16));
		
		ArrayList<Interval> result = insert(input2, new Interval(4, 9));
		for(Interval interva: result)
		{
			System.out.println(interva.start);
			System.out.println(interva.end);
			System.out.println("------------");
		}
		
		*/
		
		ArrayList<Interval> input6 = new ArrayList<Interval>();
		input6.add(new Interval(31935139, 38366404));
		input6.add(new Interval(54099301, 76986474));
		input6.add(new Interval(87248431, 94675146));
		
		ArrayList<Interval> result6 = insert(input6, new Interval(43262807, 68844111));
		for(Interval interval: result6)
		{
			System.out.println(interval.start);
			System.out.println(interval.end);
			System.out.println("------------");
		}
	}
	
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
	{
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval intervalToAdd = new Interval();
		int i = 0;
		boolean newIntervalAdded = false;
		boolean intervalToAddStartAdded = false;
		while(i < intervals.size())
		{
			Interval currentInterval = intervals.get(i);
			
			if(!newIntervalAdded)
			{
				if(intervalToAddStartAdded)
				{
					if(currentInterval.start > newInterval.end)
					{
						intervalToAdd.end = newInterval.end;
						result.add(intervalToAdd);
						intervalToAdd = new Interval();
						newIntervalAdded = true;
						intervalToAddStartAdded = false;
						continue;
					}
					
					if(currentInterval.start == newInterval.end || currentInterval.end > newInterval.end)
					{
						intervalToAdd.end = currentInterval.end;
						result.add(intervalToAdd);
						intervalToAdd = new Interval();
						newIntervalAdded = true;
						intervalToAddStartAdded = false;
					}
					i++;
					continue;
				}
				
				if(newInterval.start < currentInterval.start)
				{
					intervalToAdd.start = newInterval.start;
					if(newInterval.end > currentInterval.start)
					{
						intervalToAddStartAdded = true;
						continue;
					}
					if(newInterval.end < currentInterval.end)
					{
						intervalToAdd.end = newInterval.end;
						result.add(intervalToAdd);
						newIntervalAdded = true;
						intervalToAdd = new Interval();
					}
					intervalToAddStartAdded = true;
					continue;
				}
				else
				{
					intervalToAdd.start = currentInterval.start;
					if(newInterval.start > currentInterval.end)
					{
						intervalToAdd.end = currentInterval.end;
						result.add(intervalToAdd);
						intervalToAdd = new Interval();
					}
					else
					{
						intervalToAddStartAdded = true;
					}
					i++;
				}
			}
			else
			{
				result.add(currentInterval);
				i++;
			}	
		}
		
		if(!newIntervalAdded)
		{
			if(intervalToAddStartAdded)
			{
				intervalToAdd.end = newInterval.end;
				result.add(intervalToAdd);
			}
			else
			{
				result.add(newInterval);
			}
		}
		
		return result;
	}

}


