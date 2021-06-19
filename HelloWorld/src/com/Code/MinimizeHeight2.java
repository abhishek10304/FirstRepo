package com.Code;

import java.util.Arrays;

public class MinimizeHeight2 {
		
	public static void main(String args[]) {
		 
		int arr[] = new int[] {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
		int n =10;
		int k = 5;
        int small, big, add, sub;
        Arrays.sort(arr);

        int min = arr[n-1] - arr[0];
        
        small = arr[0]+k;
        big = arr[n-1]-k;
        
       if(small>big){
           small = big + small;
           big = small - big;
           small = small - big; 
       }
       
       for(int index = 1 ; index< n-1 ; index++){
    	   
    	   System.out.println("small : "+small+" big : "+big);
           if(arr[index] - k < 0) {
        	   add = arr[index] + k;
        	   
        	   if(add>big)
        		   	big = add;
        	   
           }else {
        	   add = arr[index] + k;
        	   sub = arr[index] - k;
        	   
        	   if(sub>=small || add<=big)
        		   continue;
        	   
        	   if(big - sub <= add - small) {
        		   small = sub; 
        	   }else {
        		   big = add;
        	   }
           }
       }
       System.out.println(Math.min(min, big - small));
	}
}
