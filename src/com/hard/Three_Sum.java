package com.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));

		nums = new int[] {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
		System.out.println(threeSum(nums));
	}

	//	//instead of list try with set
	//	public static List<List<Integer>> threeSum(int[] nums){
	//		List<List<Integer>> ans = new ArrayList<>();
	//		for(int i=0;i<nums.length;i++) {
	//			int n1 = nums[i];
	//			for(int j=i+1;j<nums.length;j++) {
	//				int n2 = nums[j];
	//				for(int k =i+2;k<nums.length;k++) {
	//					if(i==j || i==k || j==k) {
	//						continue;
	//					}
	//					int n3 = nums[k];
	//					int sum = n1 + n2 + n3;
	//					if(sum==0) {
	//						List<Integer> res = new ArrayList<>();
	//						res.add(nums[i]);
	//						res.add(nums[j]);
	//						res.add(nums[k]);
	//						Collections.sort(res);
	//						if(ans.size()!=0) {
	//							int cnt =0;
	//							for(int l=0;l<ans.size();l++) {
	//								if(ans.get(l).toString().equals(res.toString())) {
	//									cnt++;
	//								}
	//							}
	//							if(cnt==0) {
	//								ans.add(res);
	//							}
	//						}else {
	//							ans.add(new ArrayList<Integer>(res));
	//						}
	//					}
	//				}
	//			}
	//		}
	//		return ans;
	//	}

	//	//better approach by using hashing
	//	public static List<List<Integer>> threeSum(int[] nums){
	//		Set<List<Integer>> ans = new HashSet<>();
	//		
	//		for(int i=0;i<nums.length;i++) {
	//			Set<Integer> res = new HashSet<Integer>();
	//			for(int j=i+1;j<nums.length;j++) {
	//				int k = -(nums[i]+nums[j]);
	//				if(res.contains(k)) {
	//					List<Integer> temp = Arrays.asList(nums[i],nums[j],k);
	//					temp.sort(null);
	//					ans.add(temp);
	//				}
	//				res.add(nums[j]);
	//			}
	//		}
	//		
	//		List<List<Integer>> list = new ArrayList<List<Integer>>(ans);
	//		return list;
	//	}

	//optimal approach using 2 pointers
	public static List<List<Integer>> threeSum(int[] arr){
		List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
	}
}
