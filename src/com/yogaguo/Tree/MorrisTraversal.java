package com.yogaguo.Tree;

/**
 * morris遍历
 * @author LENOVO
 *
 */
public class MorrisTraversal {
   static class Node{
	   private Node left;
	   private Node right;
	   private int value;
	   public Node(int data) {
		   this.value = data;
	   }
   }
   /**
    * morris 遍历
    * @param head
    */
   public static void morris(Node head) {
	   if( head == null) {
		   return;
	   }
	   Node cur1 = head;
	   Node cur2 = null;
	   while(cur1 != null) {
		    cur2 = cur1.left ;
		   if(cur2 != null) {
			   while(cur2.right != null && cur2.right != cur1) {
				   cur2 = cur2.right;
			   }
			   if(cur2.right == null) {
				   cur2.right = cur1;
				   cur1 = cur1.left;
				    continue;
			   }else {
				  cur2.right = null; 
			   }
		   }
		   cur2 = cur2.right;
	   }
   }
    /**
     * morris 实现前序遍历
     * @param head
     */
   public static void morrisPre(Node head) {
	   if( head == null) {
		   return;
	   }
	   Node cur1 = head;
	   Node cur2 = null;
	   while(cur1 != null) {
		    cur2 = cur1.left ;
		   if(cur2 != null) {
			   while(cur2.right != null && cur2.right != cur1) {
				   cur2 = cur2.right;
			   }
			   if(cur2.right == null) {
				   cur2.right = cur1;
				   System.out.print(cur1.value+" ");
				   cur1 = cur1.left;
				    continue;
			   }else {
				  cur2.right = null; 
			   }
		   }else {
			   System.out.print(cur1.value+" ");
		   }
		   cur1 = cur1.right;
	   }
   }
   /**
    * Morris的中序遍历
    * @param args
    */
   public static void morrisIn(Node head) {
	   if( head == null) {
		   return;
	   }
	   Node cur1 = head;
	   Node cur2 = null;
	   while(cur1 != null) {
		   cur2 = cur1.left;
		   if( cur2 != null) {
			   while(cur2.right != null && cur2.right != cur1) {
				   cur2 = cur2.right;
			   }
			   if(cur2.right == null) {
				   cur2.right = cur1;
				   cur1 = cur1.left;
				   continue;
			   }else {
				   cur2.right = null;
			   }
		   }
		   System.out.print(cur1.value+" ");
		   cur1 = cur1.right;
	   }
   }
   /**
    * Morris 的后序遍历
    * @param args
    */
   public static void morrisPos(Node head) {
	   if(head == null) {
		   return;
	   }
	   Node cur1 = head;
	   Node cur2 = null;
	   while(cur1 != null) {
		   cur2 = cur1.left;
		   if(cur2 != null) {
			   while(cur2.right != null && cur2.right != cur1) {
				   cur2 = cur2.right;
			   }
			   if(cur2.right == null) {
				   cur2.right = cur1;
				   cur1 = cur1.left;
				   continue;
			   }else {
				   cur2.right = null;
				   printEdge(cur1.left);
			   }
		   }
		   cur1 = cur1.right;
	   }
	   printEdge(head);
   }
	   private static void printEdge(Node left) {
			   Node cur = reverse(left);
			   while(cur != null) {
				   System.out.print(cur.value+" ");
				   cur = cur.right;
			   }
			
		}
		private static Node reverse(Node cur) {
			Node next = null;
			Node pre = null;
			while(cur != null) {
			    next = cur.right;
			    cur.right = pre;
			    pre = cur;
			    cur = next;
			}
			return pre;
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
				morrisPre(head);
				System.out.println(" ");
				morrisIn(head);
				System.out.println(" ");
				morrisPos(head);
		}
}
