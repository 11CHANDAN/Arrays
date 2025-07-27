package com.hard;

import java.util.ArrayList;
import java.util.List;

public class NthRowPascalTriangle {
	
	public static void main(String[] args) {
		System.out.println(nthRow(6));
		System.out.println(nthRow(2));
	}
	
	public static List<Integer> nthRow(int r){
		List<Integer> ans = new ArrayList<>();
		int res=1;
		ans.add(1);
		for(int i=1;i<r;i++) {
			res = res *(r - i);
			res = res / i;
			ans.add(res);
		}
		return ans;
	}

}
