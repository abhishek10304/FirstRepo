package com.BitManipulation;

import java.util.Arrays;

public class NonRepeatingElements {
	public static void main(String[] args) {
		
		int[] nums = new int[]{1,2,3,1,2,4};
		Arrays.sort(nums);
		int result = nums[0];
		for(int index=1 ; index<nums.length ; index++) {
			result = nums[index] ^ result;
		}
		result = (result&-result);//https://www.tutorialspoint.com/two-s-complement
		int sum1 = 0, sum2 =0;
		for(int index=0; index<nums.length; index++) {
			if((nums[index]&result) > 0){
                sum1 = (sum1^nums[index]);
            }
            else {
                sum2 = (sum2^nums[index]);
            }
		}
		System.out.println(sum1+"  "+sum2);
	}
}
