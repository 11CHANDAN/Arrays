package com.hard;

public class PascalTriangle1 {

	public static void main(String[] args) {
//		Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
		System.out.println(funNcR(4-1, 2-1));
	}
	
	public static int funNcR(int n,int r) {
		int res = 1;
		
		for(int i=0; i<r; i++) {
			res = res*(n-i);
			res = res/(i+1);
		}
		return res;
	}

}
