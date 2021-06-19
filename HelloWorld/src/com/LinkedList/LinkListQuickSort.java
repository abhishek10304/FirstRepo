package com.LinkedList;

public class LinkListQuickSort {
	
	public static Node partition(Node start, Node end) {
		if(start == end || start == null || end == null) {
			return start;
		}
		
		Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
        
        while (start != end) {
            if (start.data < pivot) {
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
		
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        
		return pivot_prev;
	}
	
	public static Node quickSort(Node start, Node end) {
		if(start == null || start == end || start == end.next) {
			return start;
		}
		Node pivotPrev = partition(start,end);
		quickSort(start,pivotPrev);
		
		if(start==pivotPrev && pivotPrev!=null) {
			quickSort(pivotPrev.next,end);
		}
		else if(pivotPrev!=null && pivotPrev.next!=null) {
			quickSort(pivotPrev.next.next,end);
		}
		return start;
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

		Node head = new Node(70);
		head.next = new Node(99);
		head.next.next = new Node(4);
		head.next.next.next = new Node(88);
		head.next.next.next.next = new Node(71);
		head.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next = new Node(12);
		head.next.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next.next = new Node(27);
		printList(head);
		Node end = head;
		while(end.next!=null) {
			end = end.next;
		}
		head = quickSort(head,end);
		printList(head);
		//97 50 64 79 11 58 
		//70 99 4 88 71 8 12 70 27
	}
	
}
