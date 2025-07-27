package com.hard;

public class MaxProductSubArray {

	public static void main(String[] args) {
		
		/*
		 * Given an integer array nums. Find the subarray with the largest product, and
		 * return the product of the elements present in that subarray.
		 * 
		 * 
		 * A subarray is a contiguous non-empty sequence of elements within an array.
		 */
		
		int[] nums = {4, 5, 3, 7, 1, 2};
		System.out.println(maxProduct(nums));
		
		nums = new int[] {-5, 0, -2};
		System.out.println(maxProduct(nums));
		
		nums = new int[] {5};
		System.out.println(maxProduct(nums));
		
		nums = new int[]{-7};
		System.out.println(maxProduct(nums));
		
		nums = new int[]{-1, -2, -3, -4};
		System.out.println(maxProduct(nums));
	}
	
//	public static int maxProduct(int[] nums) {
//		int mp = 0;
//		
//		for(int i=0;i<nums.length;i++) {
//			int p = nums[i];
//			for(int j=i+1;j<nums.length;j++) {
//				mp = Math.max(mp, p);
//				p *= nums[j];
//			}
//			mp = Math.max(mp, p);
//		}
//		return mp;
//	}
	
	public static int maxProduct(int[] nums) {
		int prefix = 1;
		int suffix = 1;
		
		int res = Integer.MIN_VALUE;
		int n =nums.length;
		
		for(int i=0;i<n;i++) {
			if(prefix == 0) prefix = 1;
			if(suffix == 0) suffix = 1;
			
			prefix *= nums[i];
			suffix *= nums[n-i-1];
			
			res = Math.max(res, prefix);
			res = Math.max(res, suffix);
		}
		
		return res;
	}
}
