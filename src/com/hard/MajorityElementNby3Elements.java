package com.hard;

import java.util.*;

public class MajorityElementNby3Elements {

	public static void main(String[] args) {

		/*
		 * Given an integer array nums of size n. Return all elements which appear more
		 * than n/3 times in the array. The output can be returned in any order.
		 */

		//Here 1 technique is if element occurs more than n/3 (30%) times means at max only 2 element can occur

		int[] nums = {1,1,1,1,3,2,2,2};
		System.out.println(nBy3Elements(nums));

		nums = new int[]{0,0,0,0,0,0,0,0,0};
		System.out.println(nBy3Elements(nums));

	}

	//brute force is using nested for loop
	//better approach
	//	public static List<Integer> nBy3Elements(int[] nums){
	//		Set<Integer> set = new LinkedHashSet<Integer>();
	//		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
	//		int n = nums.length/3;
	//		
	//		
	//		for(int i=0;i<nums.length;i++) {
	//			m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
	//			if(m.get(nums[i])>n) {
	//				set.add(nums[i]);
	//				if(set.size()>2) {
	//					return new ArrayList<>(set);
	//				}
	//			}
	//		}
	//		return  new ArrayList<>(set);
	//	}

	public static List<Integer> nBy3Elements(int[] nums){
		int ele1 = 0, cnt1 =0, ele2 =0, cnt2=0;

		for(int i =0;i<nums.length;i++) {
			if(cnt1 == 0 && nums[i] != ele2) {
				cnt1=1;
				ele1 = nums[i];
			}else if(cnt2 == 0 && nums[i] != ele1) {
				cnt2=1;
				ele2 = nums[i];
			}else if(nums[i]==ele1) {
				cnt1++;
			}else if(nums[i]==ele2) {
				cnt2++;
			}else {
				cnt1--;
				cnt2--;
			}
		}

		//manual check
		cnt1 =0;cnt2 =0;

		for(int j=0;j<nums.length;j++) {
			if(nums[j]==ele1) {
				cnt1++;
			}else if(nums[j]==ele2){
				cnt2++;
			}
		}

		List<Integer> li = new ArrayList<Integer>();
		if(cnt1 > nums.length/3) {
			li.add(ele1);
		}

		if(cnt2 > nums.length/3) {
			li.add(ele2);
		}

		return li;
	}

}
