package com.Code;

public class UglyNumber {

	public static int nthUglyNumber(int n) {
		int arr[] = new int[n];
		arr[0] = 1;
		int a = 2;
		int b = 3;
		int c = 5;
		int i2=0, i3=0, i5=0; 
		int nextNumber = 1;
		for(int index=1; index<n; index++) {
			nextNumber = Math.min(a, Math.min(b,c));
			arr[index] = nextNumber;
			if(nextNumber == a) {
				i2 = i2+1;
				a = arr[i2]*2;
			}if(nextNumber == b) {
				i3 = i3+1;
				b = arr[i3]*3;
			}if(nextNumber == c) {
				i5 = i5+1;
				c = arr[i5]*5;
			}
		}
        return nextNumber;
    }
	public static void main(String[] args) {
		int n = 1000;
		boolean answer;
		if(n==0 || n<0)
			answer = false;
	     while(n%2==0){
	         n = n/2;
	         if(n==1)
	        	 answer = true;
	     }while(n%3==0){
	         n = n/3;
	         if(n==1)
	        	 answer = true;
	     }while(n%5==0){
	         n = n/5;
	         if(n==1)
	        	 answer = true;
	     }  
	        if(n==1)
	        	answer = true;
	        else
	        	answer = false;
	        
	        System.out.println(answer);
	        System.out.println(nthUglyNumber(150));
	}

}
