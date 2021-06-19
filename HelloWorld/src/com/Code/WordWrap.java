package com.Code;

import CommonCode.CommonCode;

public class WordWrap {

	final static int MAX = Integer.MAX_VALUE;
	
	 public static void solveWordWrap (int arr[], int n, int M)
	    {
		 
		 int minCost[][] = new int[n][n];
		 int space;
		 int cal[] = new int[n];
		 int rootCal[] = new int[n];
		 
		 for(int i=0; i<n; i++) {
			 space = M - arr[i];
			 minCost[i][i] = space;// here we can use space*space if we want to get more accurate answer as squaring will increase the space.
			 for(int j=i+1; j<n; j++) {
				 space = space - arr[j] - 1;
				 if(space>=0)
					 minCost[i][j] = space;//space*space
				 else
					 minCost[i][j] = MAX;
			 }
		 }
	     minCost[n-1][n-1] = 0;
		 
		 CommonCode cc = new CommonCode();
		 cc.printArray2D(minCost, n);
		 
		 for(int i=n-1; i>=0; i--) {
			 cal[i] = minCost[i][n-1];
			 
			 for(int j=n-1; j>i; j--) {	 
				 if(minCost[i][j-1] == MAX )continue;
				 if(cal[i] > minCost[i][j-1]+cal[j] ) {
					 cal[i] = minCost[i][j-1]+cal[j];
				 }
			 }
		 } cc.printArray(cal, n);
		 
		 //return cal[0];
		 
	    }
	 public static void main(String args[])
	    {
	        WordWrap w = new WordWrap();
	        int l[] = {3, 2, 2, 5};
	        int n = l.length;
	        int M = 6;
	        w.solveWordWrap (l, n, M);
	    }
	
}
