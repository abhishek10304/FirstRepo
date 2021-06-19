package com.BinaryTree;

import java.util.ArrayList;

public class LevelOrderTraverse {

	public static int treeHeight(Tree head) {
		if(head == null) {
			return 0;
		}
		int lh = treeHeight(head.left);
		int rh = treeHeight(head.right);
		if(lh>rh) return lh+1;
		else return rh+1;
	}
	
	public static void levelOrderTrav(Tree head, int height, ArrayList<Integer> array) {
		if(head == null)
			return;
		
		if( height==1 ) {
			array.add(head.data);
			return;
		}
		levelOrderTrav(head.left, height-1, array);
		levelOrderTrav(head.right, height-1, array);
	}
	
	
	public static ArrayList<Integer> levelOrder(Tree node){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> arrayRev = new ArrayList<Integer>();
		int height = treeHeight(node);
		System.out.println(height);
		
		for(int index = 1 ; index <= height; index++) {
			levelOrderTrav(node, index, array);
		}
		for(int index = height ; index >= 1; index--) {
			levelOrderTrav(node, index, arrayRev);
		}
		System.out.println(array);	
		System.out.println(arrayRev);
		return array;	
	}
	
	public static void main(String args[]) {
		Tree head = new Tree(1);
		head.left = new Tree(2);
		head.right = new Tree(3);
		head.left.left = new Tree(4);
		head.left.right = new Tree(5);
		head.right.left = new Tree(6);
		head.right.right = new Tree(7);
		head.left.left.left = new Tree(8);
		head.right.left.left = new Tree(9);
		head.right.right.right = new Tree(10);
		head.right.left.left.left = new Tree(11);
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array = levelOrder(head);
		
	}
}
