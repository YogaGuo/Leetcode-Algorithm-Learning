package com.yogaguo.Tree;

import com.yogaguo.Tree.PreInPosTraversal.Node;

/**
 * 打印二叉树的最大值和最小值
 * @author LENOVO
 *
 */
public class PrintTreeMaxAndMin {
  static class Node{
	  private Node left;
	  private Node right;
	  private int value;
	  public Node(int data) {
		  this.value = data;
	  }
  }
  public static void printTreeMaxAndMin(Node head) {
	  ReturnMaxAndMin data = process(head);
	  System.out.println("max="+ data.max);
	  System.out.println("min="+ data.min);
  }
  static class ReturnMaxAndMin{
	  private int max;
	  private int min;
   public ReturnMaxAndMin(int max,int min) {
	    this.max = max;
	    this.min = min;
	 }
  }
   public static ReturnMaxAndMin process(Node head) {
	   if(head == null) {
		  return new ReturnMaxAndMin(Integer.MIN_VALUE,Integer.MAX_VALUE);
	   }
	    ReturnMaxAndMin leftNode = process(head.left);
	    ReturnMaxAndMin rightNode = process(head.right);
	    return new ReturnMaxAndMin( Math.max(Math.max(leftNode.max, rightNode.max),head.value),
	    		                Math.min(Math.min(leftNode.min, rightNode.min),head.value));
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
		printTreeMaxAndMin(head);
}
}
