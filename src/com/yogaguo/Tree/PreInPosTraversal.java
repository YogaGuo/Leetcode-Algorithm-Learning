package com.yogaguo.Tree;

import java.util.ArrayList;
import java.util.List;
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
			  System.out.print(head.vlaue+" ");
			  preOrderRecur(head.left);
			  preOrderRecur(head.right);
		  }
		  
		 public static void inOrderRecur(Node head) {
			 if(head == null) {
				 return;
			 }
			 inOrderRecur(head.left);
			 System.out.print(head.vlaue);
			 inOrderRecur(head.right);
		 }
		 
		 public static void posOrderRecur(Node head) {
			 if(head == null) {
				 return;
			 }
			 posOrderRecur(head.left);
			 posOrderRecur(head.right);
			 System.out.print(head.vlaue+" ");
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
					System.out.print(head.vlaue+" ");
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
		public List<Integer> preorderTraversal(Node root) {
			List<Integer> res = new ArrayList<>();
	        if(root != null){
	            Stack<Node> stack = new Stack<>();
	            stack.push(root);
	            while(!stack.isEmpty()){
	                root = stack.pop();
	                res.add(root.vlaue);
	                if(root.right != null){
	                    stack.push(root.right);
	                }
	                 if(root.left != null){
	                     stack.push(root.left);
	                 }
	            }
	        }
			 return res;
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
						System.out.print(head.vlaue+" ");
						head = head.right;
					}
				}
			}
			System.out.println( );
		}
		
		/*public static int getHeight(Node head,int l) {
			if(head == null) {
				return l;
			}
			return Math.max(getHeight(head.left,l + 1), getHeight(head.right, l + 1));
		}*/
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
			//preOrderRecur(head);
			preOrderRecur(head);
			//System.out.println(" ");
			//preOrderUnRecur(head);
		}
           	
}
