package com.BinaryTree;

import java.util.ArrayList;

public class DiameterOfTree {
	
	static DiameterOfTree diameterOfTree = new DiameterOfTree();
	
	public class Height{
		public int h; 
	}
	
	public static int getDiameter(Tree head, Height height) {
		if(head == null) {
			height.h =0;
			return 0;
		}
		Height lh = diameterOfTree.new Height();
		Height rh = diameterOfTree.new Height();
		
		int lDiameter = getDiameter(head.left,lh);
		int rDiameter = getDiameter(head.right,rh);
		
		height.h = Math.max(lh.h, rh.h) + 1;
		
		return Math.max(lh.h+rh.h+1,Math.max(lDiameter, rDiameter));
	}
	
	public static int diameter(Tree head) {
	
		Height height = diameterOfTree.new Height();
		int answer = getDiameter(head,height);
		return answer;
	}
	
	public static void main(String[] args) {
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

		int diameter = diameter(head);
		System.out.println(diameter);
	}

}
