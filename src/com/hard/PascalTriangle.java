package com.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	// this is brute force for optimal i will generate 1 row and i will add in result
//	public static List<List<Integer>> generate(int numRows) {
//		List<List<Integer>> op = new ArrayList<>();
//
//		for(int i= 0; i<=numRows; i++){
//			List<Integer> row = new ArrayList<>();
//			row.add(1);
//			for(int j=1;j<i;j++){
//				List<Integer> prevRow = op.get(i - 1);
//	            row.add(prevRow.get(j - 1) + prevRow.get(j));
//			}
//			if(i>0){
//				row.add(1);
//			}
//			op.add(new ArrayList<>(row));
//		}
//		return op;
//	}
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for(int i=1;i<=numRows;i++) {
			ans.add(nthRow(i));
		}
		return ans;
	}
	
	public static List<Integer> nthRow(int r){
		 List<Integer> ans = new ArrayList<Integer>();
		 int res = 1;
		 ans.add(1);
		 
		 for(int i =1;i< r; i++) {
			 res = res * (r-i);
			 res = res / i;
			 ans.add(res);
		 }
		 
		 return ans;
		
	}
}

