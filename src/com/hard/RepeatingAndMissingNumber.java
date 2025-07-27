package com.hard;

import java.util.*;

public class RepeatingAndMissingNumber {

	public static void main(String[] args) {

		/*
		 * Given an integer array nums of size n containing values from [1, n] and
		 * each value appears exactly once in the array, except for A, which appears
		 * twice and B which is missing. Return the values A and B, as an array of
		 * size 2, where A appears in the 0-th index and B in the 1st index.
		 */		
		RepeatingAndMissingNumber repeatingAndMissingNumber = new RepeatingAndMissingNumber();

		int[] nums = {3, 5, 4, 1, 1};
		System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(nums)));

		nums = new int[] {1, 2, 3, 6, 7, 5, 7};
		System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(nums)));
	}
	
	// optimal approach is using maths function
	public int[] findMissingRepeatingNumbers(int[] nums) {
		int n = nums.length;
		long s = (long) (n * (n+1))/2;
		long sn = (long) (n* (n+1) * (2*n+1))/6;
		
		long actualSum = 0;
	    long actualSumSq = 0;
	    
	    for(int val : nums) {
	    	actualSum += val;
	    	actualSumSq += (long) val * val;
	    }
	    
	    long diff1 = actualSum - s;
	    long diff2 = actualSumSq - sn;
	    
	    long sumAB = diff2 / diff1; // A + B

	    int A = (int) ((diff1 + sumAB) / 2);
	    int B = (int) (A - diff1);

	    return new int[]{A, B};
	}
	
	// brute-force
//	public int[] findMissingRepeatingNumbers(int[] nums) {
//		int repeatingNum = -1;
//		int missingNum = -1;
//		
//		for(int i =1;i<=nums.length;i++) {
//			int cnt = 0;
//			for(int j=0;j<nums.length;j++) {
//				if(nums[j]==i) {
//					cnt++;
//				}
//				
//			}
//			
//			if(cnt == 2) {
//				repeatingNum = i;;
//			}else if(cnt == 0) {
//				missingNum = i;
//			}
//			
//			if(repeatingNum!=-1 && missingNum != -1) {
//				break;
//			}
//		}
//		
//		int[] ans = new int[2];
//		ans[0] = repeatingNum;
//		ans[1] = missingNum;
//		
//		return ans;
//	}
	
//	//Hashing
//	public int[] findMissingRepeatingNumbers(int[] nums) {
//		int[] ans = new int[2];
//		
//		int[] m = new int[nums.length+1];
//		
//		for(int i=0;i<nums.length;i++) {
//			m[nums[i]]++;
//		}
//		
//		for(int j=0;j<=m.length;j++) {
//			if(m[j] == 2) {
//				ans[0] = j;
//			}
//			else if(m[j] == 0) {
//				ans[1] = j;
//			}
//			
//			if(ans[0]!=-0 && ans[1] != 0) {
//				break;
//			}
//		}
//		
//		return ans;
//	} 
}
