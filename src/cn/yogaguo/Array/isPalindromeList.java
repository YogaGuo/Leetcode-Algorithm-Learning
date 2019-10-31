package cn.yogaguo.Array;

import java.util.Stack;
/**
 * 判断链表是否为 回文 链表
 * @author LENOVO
 *
 */
  

public class isPalindromeList {
	public static class  Node{
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}	
	}
   /**
    * 空间复杂度O(n)  
    */
	static boolean isPalinadromelist1(Node head) {
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while(cur != null) {
		  stack.push(cur);
		  cur = cur.next;
		}
		while(head != null) {
			if(head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		 return true;
	}
	/**
	 * 使用一般栈空间，空间复杂度O(n)
	 */
	static boolean isPalinadrome2(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Stack<Node> stack =new Stack<>();
		while(slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		while(!stack.isEmpty()) {
		     if(head.value != stack.pop().value){
		        return false;
		     }
		     head = head.next;
		}
		return true;
	}
	/**
	 * 空间复杂度O(1)
	 * @param head
	 * @return
	 */
	static boolean isPalinadrome3(Node head) {
		
		if( head == null || head.next == null) {
			  return true;
		  }
		  Node slow = head;
		  Node fast = head;
		  while(fast.next != null && fast.next.next != null) {
			  slow = slow.next;
			  fast = fast.next.next;
		  }
		  Node n1 = slow.next;
		  slow.next = null;
		  Node n2 =null;
		  while(n1 != null) {
			  n2 = n1.next;
			  n1.next = slow;
			  slow = n1;
			  n1 =n2;
		  }
		  while(slow != null && head != null) {
			  if(slow.value != head.value) {
				  return false;
			  }
			  slow = slow.next;
			  head = head.next;
		  }
		  return true;
	}
	public static void main(String[] args) {
		Node head = null;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		System.out.println(isPalinadrome3(head));
	}
}
