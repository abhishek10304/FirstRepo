package com.BitManipulation;

public class FilpsReqToMakeSameNums {

	public static void main(String[] args) {
		int a= 20, b = 25;
		int count = 0;    
        while(a!=0 || b!=0){
            if((a&1) != (b&1)){
                count++;
            } 
            a = a>>1;
            b= b>>1;
        }
        System.out.println(count);
	}

}
