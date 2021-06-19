package com.LinkedList;

public class LinkListMergeSort {

	public static Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	public static Node middleNode(Node head) {
		if (head == null)
			return head;

		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	 public static Node mergeSort(Node head) {
	  
     if(head == null || head.next == null) {
    	 return head;
     }
     
	 Node middle = middleNode(head); 
	 Node middleNext = middle.next; 
	 middle.next =null;
	 
	 Node left = mergeSort(head); 
	 Node right = mergeSort(middleNext);

	 Node sorted = sortedMerge(left,right); 
	 return sorted;

	 }

	public static void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Node head = new Node(23);
		head.next = new Node(43);
		head.next.next = new Node(12);
		head.next.next.next = new Node(103);
		head.next.next.next.next = new Node(32);
		head.next.next.next.next.next = new Node(-87);
		printList(head);
		head = mergeSort(head);
		printList(head);
		/*
		 * Node a = new Node(1); a.next = new Node(4); a.next.next = new Node(10);
		 * 
		 * Node b = new Node(2); b.next = new Node(3); b.next.next = new Node(6);
		 * 
		 * printList(a); printList(b); printList(sortedMerge(a, b));
		 */
	}
}
