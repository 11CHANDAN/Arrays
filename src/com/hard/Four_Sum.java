package com.hard;

import java.util.*;

public class Four_Sum {

	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;

		System.out.println(fourSum(nums, target));

		nums = new int[] {1000000000,1000000000,1000000000,1000000000};
		target = -294967296;

		System.out.println(fourSum(nums, target));
	}

	//better
	//	public static List<List<Integer>> fourSum(int[] nums, int target) {
	//        int n = nums.length; // size of the array
	//        Set<List<Integer>> st = new HashSet<>();
	//
	//        // checking all possible quadruplets:
	//        for (int i = 0; i < n; i++) {
	//            for (int j = i + 1; j < n; j++) {
	//                Set<Long> hashset = new HashSet<>();
	//                for (int k = j + 1; k < n; k++) {
	//                    // taking bigger data type
	//                    // to avoid integer overflow:
	//                    long sum = nums[i] + nums[j];
	//                    sum += nums[k];
	//                    long fourth = target - sum;
	//                    if (hashset.contains(fourth)) {
	//                        List<Integer> temp = new ArrayList<>();
	//                        temp.add(nums[i]);
	//                        temp.add(nums[j]);
	//                        temp.add(nums[k]);
	//                        temp.add((int) fourth);
	//                        temp.sort(Integer::compareTo);
	//                        st.add(temp);
	//                    }
	//                    // put the kth element into the hashset:
	//                    hashset.add((long) nums[k]);
	//                }
	//            }
	//        }
	//        List<List<Integer>> ans = new ArrayList<>(st);
	//        return ans;
	//    }

	//optimized
	public static List<List<Integer>> fourSum(int[] arr,int target){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-3;i++) {
			if(i!=0 && arr[i-1]==arr[i]) {
				continue;
			}
			for(int j=i+1;j<arr.length;j++) {
				if(j!=i+1 && arr[j-1] == arr[j]) {
					continue;
				}
				int k = j+1;
				int l = arr.length -1;
				while(k<l) {
					long sum = arr[i]+arr[j];
					sum += arr[k];
					sum += arr[l];

					if(sum>target) {
						l--;
					}else if(sum<target) {
						k++;
					}else {
						List<Integer> ans = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
						res.add(new ArrayList<>(ans));
						k++;
						l--;
						while(k<l && arr[k]==arr[k-1]) k++;
						while(k<l && arr[l]==arr[l+1]) l--;
					}
				}
			}
		}
		return res;
	}

}
