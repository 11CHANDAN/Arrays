package com.hard;

public class CountInversions {

	public static void main(String[] args) {
		
		/*
		 * Given an integer array nums. Return the number of inversions in the array.
		 * 
		 * 
		 * Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
		 * 
		 * It indicates how close an array is to being sorted. A sorted array has an
		 * inversion count of 0. An array sorted in descending order has maximum
		 * inversion.
		 */
		
		int[] nums = {2, 3, 7, 1, 3, 5};
		System.out.println(numberOfInversions(nums));
		
		nums = new int[] {-10, -5, 6, 11, 15, 17};
		System.out.println(numberOfInversions(nums));
	}
	
	public static int numberOfInversions(int[] nums) {
		CountInversions countInversions = new CountInversions();
		return countInversions.mergeSort(nums, 0, nums.length-1);
	}
	
	public int mergeSort(int[] arr,int low,int high) {
		int cnt = 0;
		if(low<high) {
			int mid = (low+high)/2;
			cnt += mergeSort(arr, low, mid);
			cnt += mergeSort(arr, mid+1, high);
			cnt += merge(arr, low,mid,high);
		}
		return cnt;
	}
	
	public int merge(int[] arr,int l,int m,int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		
		for(int j=0;j<n2;j++) {
			R[j] = arr[m+1+j];
		}
		
		int i = 0, j = 0, cnt = 0;
		int k =l;
		
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}else {
				cnt += (m-i+1);
				arr[k++] = R[j++];
			}
		}
		
		while(i<n1) {
			arr[k++] = L[i++];
		}
		
		while(j<n2) {
			arr[k++] = R[j++];
		}
		
		return cnt;
	}
	
//	public static int numberOfInversions(int[] nums) {
//		int cnt =0;
//		for(int i=0;i<nums.length;i++) {
//			for(int j=i+1;j<nums.length;j++) {
//				if(nums[i]>nums[j]) {
//					cnt++;
//				}
//			}
//		}
//		return cnt;
//	}
	
	

}
