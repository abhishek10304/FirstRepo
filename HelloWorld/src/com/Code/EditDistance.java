package com.Code;

import CommonCode.CommonCode;

public class EditDistance extends CommonCode{

	public static int editDistance(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		int[][] array = new int[sLen+1][tLen+1];
		for(int i=0; i<=sLen; i++) {
			for(int j=0; j<=tLen; j++) {
				if(i==0)
					array[i][j]=j;
				else if(j==0)
					array[i][j]=i;
				else if(s.charAt(i-1) == t.charAt(j-1))
					array[i][j] = array[i-1][j-1];
				else
					array[i][j] = 1 + Math.min(array[i-1][j-1], Math.min(array[i][j-1], array[i-1][j]));
			}
		}	
		printArray2D(array, sLen, tLen);
		return array[sLen][tLen];
	}
	 public static void main(String args[]){
		// System.out.println(editDistance("geek", "gesek")); 
		 System.out.println(editDistance("aabcba", "badckba"));
	 }
}
