package com.BitManipulation;

public class SetBits {

	public static void main(String[] args) {

		int N = 9;
		
		//to check if N is 2^x like 1,2,4,8,16....
		long x = N&(N-1);
        if(x == 0 && N!=0)
        	System.out.println("true");
        else 
        	System.out.println("false");
		
		int count = 0 ;
        while(N>0){
            count = count + (N & 1);
            N = N >> 1;
        }
		System.out.println("The number of 1s in the integer is "+count);
	}

}
