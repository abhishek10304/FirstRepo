package com.Code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class LRUProblem
{
    static Map<Integer,Integer> pair = new HashMap<Integer,Integer>();
    static int cap;
    static Queue<Integer> queue = new LinkedList<Integer>();
    
    LRUProblem(int cap){
        this.cap = cap;
    }

    public static int get(int key){
    	if(!pair.containsKey(key)) {
    		return -1;
    	}
    	queueOperation(key);
    	return pair.get(key);
    }

    public static void set(int key, int value){
        if(pair.size()<cap || pair.containsKey(key)) {
        	pair.put(key, value);
        	queueOperation(key);
        }else {
        	pair.remove(queue.remove());
        	pair.put(key, value);
        	queueOperation(key);
        }
    }
    
    private static void queueOperation(int key) {
    	if(queue.contains(key)) {
    		queue.remove(key);
    	}queue.add(key);
    }
    
    public static void main(String args[]) {
    	int key,value;
    	Scanner sc = new Scanner(System.in);  
    	System.out.print("Enter cap ");  
    	int cap = sc.nextInt();  
    	LRUProblem lru = new LRUProblem(cap);
    	System.out.print("Enter TCs "); 
    	int TCs = sc.nextInt();
    	while(TCs-->0) {
    		System.out.print("Enter set or get "); 
        	int str = sc.nextInt();
        	if(str==0) {
        		key = sc.nextInt();
        		value = sc.nextInt();
        		lru.set(key, value);
        	}else {
        		key = sc.nextInt();
        		System.out.println(lru.get(key));
        	}
    	}
    }
}