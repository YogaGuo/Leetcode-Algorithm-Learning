package com.yogaguo.Tree;

import java.util.Stack;

/**
 * 
 * @author LENOVO
 *
 */

public class PreInPosTraversal {
		public static class Node{
			private int vlaue;
			private Node left;
			private Node right;
			public Node(int data) {
				this.vlaue = data;
			}
		}
		  public static void preOrderRecur(Node head) {
			  if(head == null) {
				  return ;
			  }
			  System.out.println(head.vlaue+" ");
			  preOrderRecur(head.left);
			  preOrderRecur(head.right);
		  }
		 public static void inOrderRecur(Node head) {
			 if(head == null) {
				 return;
			 }
			 inOrderRecur(head.left);
			 System.out.println(head.vlaue);
			 inOrderRecur(head.right);
		 }
		 public static void posOrderRecur(Node head) {
			 if(head == null) {
				 return;
			 }
			 posOrderRecur(head.left);
			 posOrderRecur(head.right);
			 System.out.println(head.vlaue);
		 }
		 /**
		  * 先序非递归
		  * @param head
		  */
		public static void preOrderUnRecur(Node head) {
			if(head != null) {
				Stack<Node> stack = new Stack<>();
				stack.push(head);
				while(!stack.isEmpty()) {
					head=stack.pop();
					System.out.println(head.vlaue+" ");
					if(head.right != null) {
					  stack.push(head.right);
					}
					if(head.left != null) {
					  stack.push(head.left);	
					}
				}
			}
			System.out.println();
		}
		/**
		 * 二叉树的中序非递归
		 * @param head
		 */
		public static void inOrderUnRecur(Node head) {
			if(head != null) {
				Stack<Node> stack = new Stack<>();
				while(!stack.isEmpty() || head != null) {
					if(head != null) {
						stack.push(head);
						head = head.left;
					}else {
						head=stack.pop();
						System.out.println(head.vlaue+" ");
						head = head.right;
					}
				}
			}
			System.out.println( );
		}
}
