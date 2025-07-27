package com.hard;

import java.util.*;

public class MergeOverlappingSubintervals {

	public static void main(String[] args) {
		
		/*
		 * Given an array of intervals where intervals[i] = [starti, endi], merge all
		 * overlapping intervals and return an array of the non-overlapping intervals
		 * that cover all the intervals in the input.
		 */
		
		List<List<Integer>> intervals = Arrays.asList(
			    Arrays.asList(1, 3), Arrays.asList(2, 6), Arrays.asList(8, 9),
			    Arrays.asList(9, 11), Arrays.asList(8, 10), Arrays.asList(2, 4),
			    Arrays.asList(15, 18), Arrays.asList(16, 17)
			);

		
		System.out.println(mergeOverlap(intervals));
		
		List<List<Integer>> intervals1 = Arrays.asList(
				Arrays.asList(1, 10), Arrays.asList(2, 5), Arrays.asList(3, 4), Arrays.asList(6, 9)
			);
		
		System.out.println(mergeOverlap(intervals1));
	}
	
	public static List<List<Integer>>  mergeOverlap(List<List<Integer>> intervals) {
		List<List<Integer>> res = new ArrayList<>();
		intervals.sort(Comparator.comparingInt(a -> a.get(0)));
		
		for(int i=0;i<intervals.size();i++) {
			int start = intervals.get(i).get(0);
			int end = intervals.get(i).get(1);
			
			if(res.isEmpty() || start > res.get(res.size()-1).get(1)) {
				res.add(Arrays.asList(start,end));
			}else{
				end = Math.max(end,  res.get(res.size()-1).get(1));
				res.get(res.size()-1).set(1, end);
			}
			
		}		
		
		return res;
	}
	
	public int[][] merge(int[][] intervals) {
	    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

	    List<int[]> res = new ArrayList<>();

	    for (int[] interval : intervals) {
	        if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
	            res.add(interval);
	        } else {
	            res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
	        }
	    }

	    return res.toArray(new int[res.size()][]);

	    }
	
//	//brute force approach sort and merge
//	public static List<List<Integer>>  mergeOverlap(List<List<Integer>> intervals) {
//		List<List<Integer>> res = new ArrayList<>();
//		intervals.sort(Comparator.comparingInt(a -> a.get(0)));
//		
//		for(int i=0;i<intervals.size();i++) {
//			int start = intervals.get(i).get(0);
//			int end = intervals.get(i).get(1);
//			
//			if(!res.isEmpty() && end <= res.get(res.size()-1).get(1)) {
//				continue;
//			}
//			
//			for(int j=i+1;j<intervals.size();j++) {
//				if (intervals.get(j).get(0) <= end) {
//                    end = Math.max(end, intervals.get(j).get(0));
//                } else {
//                    break;
//                }
//			}
//			
//			res.add(Arrays.asList(start,end));
//		}
//		return res;
//	}
	
}
