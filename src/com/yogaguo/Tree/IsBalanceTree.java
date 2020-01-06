package com.yogaguo.Tree;

public class IsBalanceTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	public static class ReturnData{
		public int height;
		public boolean isBalance;
		public ReturnData(int height,boolean isBalance) {
			this.height = height;
			this.isBalance = isBalance;
		}
	}
	public static boolean isBalance(Node head) {
		return process(head).isBalance;
	}
	public static ReturnData process(Node head) {
		if(head == null) {
			return new ReturnData(0, true);
		}
		ReturnData left = process(head.left);
		if(!left.isBalance) {
			return new ReturnData(0,false);
		}
		ReturnData right = process(head.right);
		if(!right.isBalance) {
			return new ReturnData(0,false);
		}
		if(Math.abs(left.height - right.height) > 1) {
			return new ReturnData(0, false);
		}
		return  new ReturnData( Math.max(left.height,right.height) + 1,true);
	}
	public static int getDeep(Node head) {
		return head == null ? 0 : Math.max(getDeep(head.left), getDeep(head.right) + 1);
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		System.out.println(isBalance(head));
		System.out.println(getDeep(head));
	}
}
