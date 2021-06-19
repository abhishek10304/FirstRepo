package com.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopViewTree {

	static TopViewTree topViewTree = new TopViewTree() ;
	
	public class DataNode{
		int value;
		int position;
		int depth;
		
		DataNode(){}

		public DataNode(int value, int position, int depth) {
			super();
			this.value = value;
			this.position = position;
			this.depth = depth;
		};
		
	}
	public static void getTopView(Tree head, Map<Integer,DataNode> map, int position,int depth) {
		
		if(head==null) {
			return;
		}
		
		if(!map.containsKey(position)) {
			map.put(position, topViewTree.new DataNode(head.data, position, depth));
		}else if(map.get(position).depth > depth) {
			map.get(position).value = head.data;
			map.get(position).depth = depth;
		}
		getTopView(head.left,map,position-1,depth+1);
		getTopView(head.right,map,position+1,depth+1);
		
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

		int min = 0; int max = 0;
		Map<Integer,DataNode> map = new HashMap<Integer,DataNode>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		getTopView(head,map,0,0);
		for(Map.Entry element : map.entrySet()) {
			min = Math.min(min, (int) element.getKey());
			max = Math.max(max, (int) element.getKey());
		}		
		for(int index = min; index<= max ; index++) {
			array.add(map.get(index).value);
		}
		System.out.println(map);
		System.out.println(array);
	}
	
}
