package com.yogaguo.Tree;
/**
 * 返回给定结点的后继结点  :
 * 思路：有右子树，找右子最左结点；没有右子树，往上找，直到当前结点时父结点的左孩子
 * @author LENOVO
 *
 */
public class SuccessorNode {
  public static class Node{
	  private  Node parent;
	  private Node left;
	  private Node right;
	  private int val;
	  public Node(int data) {
		  this.val = data;
	  }
  }
	  /**
	   * 返回后继结点
	   * @param head
	   * @param n
	   * @return
	   */
	  public static Node getSuccessorNode(Node node) {
		  if(node == null) {
			  return node;
		  }
		  if(node.right != null) {
			  return getLeftMost(node.right);
		  }
		  else {
			  Node parent = node.parent;
			  while(parent != null && parent.left != node) {
				  parent = node;
				  //node = parent;
				  parent = node.parent;
			  }
			  return parent;
		  }
	  }
	private static Node getLeftMost(Node node) {
		 if(node == null) {
			 return node;
		 }
		 while(node.left != null) {
			 node = node.left;
		 }
		 return node;
	}
  public static void main(String[] args) {
	    Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
		
		Node test = head.left.left;
        System.out.println(getSuccessorNode(test).val);    
  }
}
