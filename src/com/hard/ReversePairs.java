package com.hard;

public class ReversePairs {

	public static void main(String[] args) {
		ReversePairs reversePairs = new ReversePairs();
		int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		System.out.println(reversePairs.reversePairs(nums));
		
		nums = new int[] {6, 4, 1, 2, 7};
		System.out.println(reversePairs.reversePairs(nums)); //Expected = 3
		
		nums = new int[] {5, 4, 4, 3, 3};
		System.out.println(reversePairs.reversePairs(nums)); //Expected = 0
	}

	//	public int reversePairs(int[] nums) {
	//        int cnt =0;
	//        for(int i=0;i<nums.length;i++){
	//            for(int j=i+1;j<nums.length;j++){
	//                if(nums[i] > ((long) 2*nums[j])){
	//                    cnt++;
	//                }
	//            }
	//        }
	//        return cnt;
	//    }

	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length-1);
	}

	public int mergeSort(int[] nums,int low,int high) {
		int cnt = 0;
		if(low<high) {
			int mid = (low+high)/2;
			cnt += mergeSort(nums, low, mid);
			cnt += mergeSort(nums, mid+1, high);
			cnt += countpairs(nums, low, mid, high);
			merge(nums, low, mid, high);
		}
		return cnt;
	}
	
	public int countpairs(int[] nums,int low,int mid,int high) {
		int cnt = 0;
		int right = mid+1;
		for(int i =low; i<=mid;i++) {
			while(right<= high && nums[i] > (long)2 * nums[right]) {
				right ++;
			}
			
			cnt += right - (mid+1);
		}
		return cnt;
	}

	public void merge(int[] nums,int low,int mid,int high) {
		int n1 = mid-low+1;
		int n2 = high - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for(int i=0;i<n1;i++) {
			L[i] = nums[low+i];
		}

		for(int j=0;j<n2;j++) {
			R[j] = nums[mid+1+j]; 
		}
		
		int  i =0, j =0;
		int k=low;
		
		while(i<n1 && j<n2) {
			if(L[i]<R[j]) {
				nums[k++] = L[i++];
			}else {
				nums[k++] = R[j++];
			}
		}
		
		while(i<n1) {
			nums[k++] = L[i++];
		}
		
		while(j<n2) {
			nums[k++] = R[j++];
		}
	}
}
