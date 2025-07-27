package com.hard;

import java.util.Arrays;

public class MergeSortedArray1 {

	public static void main(String[] args) {
		
		/*
		 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
		 * order, and two integers m and n, representing the number of elements in nums1
		 * and nums2 respectively.
		 * 
		 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
		 * 
		 * The final sorted array should not be returned by the function, but instead be
		 * stored inside the array nums1.
		 */ 

		 MergeSortedArray1  array1 = new MergeSortedArray1();
		 
		 int[] nums1 = {1, 3, 5, 0, 0, 0};
		 int m = 3;

		 int[] nums2 = {2, 4, 6};
		 int n = 3;
		 
		 array1.merge(nums1, m, nums2, n);

		 System.out.println(Arrays.toString(nums1));
		 
		 nums1 = new int[]{1, 2, 3};
		 m = 3;
		 nums2 = new int[]{};
		 n = 0;
		 // Expected: [1, 2, 3]

		 array1.merge(nums1, m, nums2, n);

		 System.out.println(Arrays.toString(nums1));
		 
		 nums1 = new int[]{0, 0, 0};
		  m = 0;
		 nums2 = new int[]{1, 2, 3};
		  n = 3;
		 // Expected: [1, 2, 3]
		 
		  array1.merge(nums1, m, nums2, n);

		  System.out.println(Arrays.toString(nums1));

	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j= n-1;
		int k = m+n-1;
		
		while(i>=0 && j>=0) {
			if(nums1[i]>nums2[j]) {
				nums1[k--] = nums1[i--];
			}else {
				nums1[k--] = nums2[j--];
			}
		}
		
		//nums1 is already sorted so i am using only while loop for j
		while(j>=0) {
			nums1[k--] = nums2[j--];
		}
		
	}

}
