package com.hard;

import java.util.HashMap;
import java.util.Map;

public class CountGiveSubArrayWithXorK {

	public static void main(String[] args) {
		//		Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.
		int[] nums = {5, 6, 7, 8, 9};
		System.out.println(subArraySumWithK(nums, 5));

		nums = new int[] {4, 2, 2, 6, 4};
		System.out.println(subArraySumWithK(nums, 6));
	}

	//brute force approach
	//	public static int subArraySumWithK(int[] nums,int k) {
	//		int count =0;
	//		for(int i=0;i<nums.length;i++) {
	//			int xor =0;
	//			for(int j=i;j<nums.length;j++) {
	//				xor = xor ^ nums[j];
	//				if(xor == k) {
	//					count++;
	//				}
	//			}
	//		}
	//		
	//		return count;
	//	}

	//optimal approach using prefixsum
	public static int subArraySumWithK(int[] nums,int k) {
		int xor =0;
		int count =0;

		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		m.put(0, 1);
		for(int i=0;i<nums.length;i++) {
			xor = xor ^ nums[i];
			count += m.getOrDefault(xor^k,0);
			m.put(xor, m.getOrDefault(xor,0)+1);
		}

		return count;
	}

}
