package com.BinaryTree;

public class InvertBinaryTree {

	public static Tree invert(Tree head) {
		if(head == null) {
			return null;
		}
		
		Tree lTree = head.left;
		Tree rTree = head.right;
		
		lTree = invert(lTree);
		rTree = invert(rTree);
		
		head.right = lTree;
		head.left = rTree;
		
		return head;
	}
	
	public static void inorder(Tree head) {
		if(head==null)
			return;
		
		inorder(head.left);
		System.out.print(head.data+" ");
		inorder(head.right);
		
		return;
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

		inorder(head);
		invert(head);
		System.out.println();
		inorder(head);
	}
	
}
