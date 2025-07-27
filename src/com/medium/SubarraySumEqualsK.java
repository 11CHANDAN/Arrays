package com.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		
		/*
		 * Given an array of integers nums and an integer k, return the total number of
		 * subarrays whose sum equals to k.
		 * 
		 * A subarray is a contiguous non-empty sequence of elements within an array.
		 */
		
		int[] nums = {1, 2, 3}; 
		int k = 3;
		
		System.out.println(subArraySum(nums, k));
		
		nums = new int[]{3,-3, 1, 1, 1};
		System.out.println(subArraySum(nums, k));
	}
	
	public static int subArraySum(int[] nums,int k) {
		int count = 0, prefixsum = 0;
		Map<Integer, Integer> m = new HashMap();
		m.put(0, 1);
		
		for(int i = 0;i<nums.length;i++) {
			prefixsum += nums[i];
			count += m.getOrDefault(prefixsum-k, 0);
			m.put(prefixsum, m.getOrDefault(prefixsum, 0)+1);
		}
		
		return count;
	}

}
