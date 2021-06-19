package com.Code;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

	public static int getAnswer(String A ,ArrayList<String>B ) {
		int aLast = 0;
		int answer = 0;
		if(A.length()<=0) {
			return 1;
		}
		for(int index = 0 ; index<B.size(); index++) {
			if(aLast == A.indexOf(B.get(index),aLast) ) {
				answer = getAnswer(A.substring(B.get(index).length()) , B);
				if(answer == 1)
					return answer;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		String A = "likemanquote";
		//System.out.println(A.indexOf("man",5));
		ArrayList<String> B = new ArrayList<String>(Arrays.asList("likem", "like", "man", "keman", "quote", "anquo", "nquote", "manq"));
		B.add("mango");
		System.out.println(B);
		//System.out.println("qoute".substring("quote".length()));
		int answer = getAnswer(A,B);
		System.out.println(answer);
	}

}
