package com.yogaguo.Tree;

/**
 * 打印二叉树边界
 * 
 * @author LENOVO
 *
 */
public class PrintEdge {
	static class Node{
		private int value;
		private Node left;
		private Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	public static void printEdge(Node head) {
		if(head == null) {
			return;
		}
		int Height = getHeight(head,0);
		Node[][] EdgeMap = new Node[Height][2]; 
		setEdgeMap(head,0,EdgeMap);
		for(int i = 0;i < EdgeMap.length; i++) {
			System.out.print(EdgeMap[i][0].value+" ");
		}
		printLeafNotInMap(head,0,EdgeMap);
		for(int i = EdgeMap.length - 1; i != -1; i-- ) {
			if(EdgeMap[i][0] != EdgeMap[i][1]) {
				System.out.print(EdgeMap[i][1].value+" ");
			}
		}
	}
	private static void printLeafNotInMap(Node head, int l,Node[][] edgeMap) {
		if(head == null) {
			return;
		}
		if(head.left == null && head.right == null && head != edgeMap[l][0] && head != edgeMap[l][1]) {
			System.out.print(head.value+" ");
		}
		printLeafNotInMap(head.left, l + 1, edgeMap);
		printLeafNotInMap(head.right, l + 1, edgeMap);
		
	}
	private static void setEdgeMap(Node head, int i, Node[][] edgeMap) {
		 if( head == null) {
			 return ;
		 }
		 edgeMap[i][0] = edgeMap[i][0] == null ? head : edgeMap[i][0];
		 edgeMap[i][1] = head;
		 setEdgeMap(head.left, i + 1, edgeMap);
		 setEdgeMap(head.right, i + 1, edgeMap);
		
	}
	private static int getHeight(Node head, int i) {
		 if( head == null) {
			 return i;
		 }
		 return Math.max(getHeight(head.left, i + 1), getHeight(head.right, i + 1));
	}
    public static void main(String[] args) {
    	Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		printEdge(head);
	}
}
