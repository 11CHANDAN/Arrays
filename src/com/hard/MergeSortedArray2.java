package com.hard;

import java.util.Arrays;

public class MergeSortedArray2 {

	public static void main(String[] args) {
		int[] nums1 = {-5, -2, 4, 5};
		int[] nums2 = {-3, 1, 8};

		MergeSortedArray2 array2 = new MergeSortedArray2();
		array2.merge(nums1, nums2);

		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
	}

	//	optimized approach 1
	//	public void merge(int[] nums1,int[] nums2) {
	//		int left = nums1.length-1;
	//		int right = 0;
	//
	//		while(left>=0 && right<=nums2.length-1) {
	//			if(nums1[left]>nums2[right]) {
	//				int temp = nums2[right];
	//				nums2[right++] = nums1[left];
	//				nums1[left--] = temp;
	//			}else {
	//				break;
	//			}
	//		}
	//		
	//		Arrays.sort(nums1);
	//		Arrays.sort(nums2);
	//	}

	//	optimized approach2	gap method
	public void merge(int[] nums1,int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int len = m+n;
		int gap = (len/2) + (len%2);
		while(gap>0) {
			int left =0;
			int right=gap;
			while(right < len) {
				if(left<m && right>=m) {
					swapIfGreater(nums1, left, nums2, right-m);
				}
				else if(left>=m) {
					swapIfGreater(nums2, left-m, nums2, right-m);
				}
				else {
					swapIfGreater(nums1, left, nums1, right);
				}
				left++;
				right++;
			}
			if(gap == 1) break;
			gap = (gap/2)+(gap%2);
		}
	}

	public void swapIfGreater(int[] arr1, int a, int[] arr2, int b) {
		if(arr1[a]>arr2[b]) {
			int temp1 = arr1[a];
			arr1[a] = arr2[b];
			arr2[b] = temp1;
		}
	}
}
