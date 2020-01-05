package com.yogaguo.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * @author LENOVO
 *
 */
public class SerializeAndReconstrctTree {
  public static class Node{
	  private int value;
	  private Node left;
	  private Node right;
	  public Node(int data) {
		  this.value = data;
	  }
  }
  /**
   * Method 1 :按PreOrder
   * @param head
   * @return
   */
	  public static String serializeByPre(Node head) {
		  if(head == null) {
			  return "#!";
		  }
		  String res = head.value + "!";
		  res += serializeByPre(head.left);
		  res += serializeByPre(head.right);
		  return res;
	  }
	  
	  
		  public static Node reconSerializeByPre(String prestr) {
			  String[] values = prestr.split("!");
			  Queue<String> queue = new LinkedList<>();
			  for(int i = 0; i != values.length; i++) {
				  queue.offer(values[i]);
			  }
			  return reconPreOrder(queue);
		  }
		private static Node reconPreOrder(Queue<String> queue) {
			String value = queue.poll();
			 if(value.equals("#")) {
				 return null;
			 }
			 Node head = new Node(Integer.valueOf(value));
			 head.left = reconPreOrder(queue);
			 head.right = reconPreOrder(queue);
			 return head;
		}
		/**
		 * 按层遍历序列化与反序列化
		 */
		public static String serialByLevel(Node head) {
			if(head == null) {
				return "#!";
			}
			String res = head.value + "!";
			Queue<Node> queue = new LinkedList<>();
			queue.offer(head);
			while(!queue.isEmpty()) {
			 head = queue.poll();
			 if(head.left != null) {
				 res += head.value + "!";
				 queue.offer(head.left);
			 }else {
				 res += "#!";
			 }
			 if(head.right != null) {
				 res += head.value + "!";
				 queue.offer(head.right);
			 }else {
				 res += "#!";
			 }
			}
			return res;
		}
	  public static Node reconSerialByLevel(String levelStr) {
		  String[] values = levelStr.split("!");  
		  int index = 0;
		  Node head = generateNode(values[index++]);
		  Queue<Node> queue = new LinkedList<>();
		  if(head != null) {
			  queue.offer(head);
		  }
		   Node node = null;
		  while(!queue.isEmpty()) {
			  node = queue.poll();
			  node.left = generateNode(values[index++]);
			  node.right = generateNode(values[index++]);
			  if(node.left != null) {
				  queue.offer(node.left);
			  }
			  if(node.right != null) {
				  queue.offer(node.right);
			  }
		  }
		  return head;
	  }

	private static Node generateNode(String value) {
		 if(value.equals("#")) {
			 return null;
		 }
		 return new Node(Integer.valueOf(value));
	}
}
