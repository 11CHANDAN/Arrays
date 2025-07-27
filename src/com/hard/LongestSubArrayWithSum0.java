package com.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum0 {

	public static void main(String[] args) {

		/*
		 * You are given an integer array arr of size n which contains both positive and
		 * negative integers. Your task is to find the length of the longest contiguous
		 * subarray with sum equal to 0.
		 * 
		 * Return the length of such a subarray. If no such subarray exists, return 0.
		 */

		int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println(subArrayWithSum0(nums));

		nums = new int[]{2, 10, 4};
		System.out.println(subArrayWithSum0(nums));

		int[] arr = {1, 2, -3, 3, -1, -2, 4};
		System.out.println(subArrayWithSum0(arr));

		int[] arr1 = {0, 0, 0, 0};
		System.out.println(subArrayWithSum0(arr1));

		int[] arr2 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		System.out.println(subArrayWithSum0(arr2 	));

	}

	public static int subArrayWithSum0(int[] nums) {
		int maxlen =0;
		int prefixSum =0;

		Map<Integer,Integer> m = new HashMap<Integer, Integer>();

		for(int i=0;i<nums.length;i++) {
			prefixSum += nums[i];

			if(prefixSum==0) {
				maxlen = i+1;
			}else {
				if(m.containsKey(prefixSum)) {
					maxlen = Math.max(maxlen, i-m.get(prefixSum));
				}else {
					m.put(prefixSum, i);
				}
			}
		}
		return maxlen;
	}
}
