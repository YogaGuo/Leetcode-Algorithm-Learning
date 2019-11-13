package cn.yogaguo.Array;

import java.util.Stack;
/**
 * 两个单链表生成相加链表：
 * 例：9—>3—>6    6—>3
 * 结果：1—>0->0->0
 * @author LENOVO
 *
 */
public class AddList {
    static class Node{
    	private int value;
    	private Node next;
    	public Node(int data) {
    		this.value = data;
    	}
    }
    /**
     *   解法一：用栈
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList(Node head1,Node head2 ) {
    	Stack<Integer> s1 = new Stack<>();
    	Stack<Integer> s2 = new Stack<>();
    	while(head1!= null) {
    		s1.push(head1.value);
    		head1 = head1.next;
    	}
    	while(head2 != null) {
    		s2.push(head2.value);
    		head2 = head2.next;
    	}
    	int n1,n2;
    	int ca = 0 ;
    	int n;
    	Node pre = null;
    	Node node = null;
    	while(!s1.isEmpty()|| !s2.isEmpty()) {
    		 n1 = s1.isEmpty() ? 0 : s1.pop();
    		 n2 = s2.isEmpty() ? 0 : s2.pop();
    		 n = n1 + n2 + ca;
    		 pre = node;
    		 node = new Node(n%10);
    		 node.next = pre;
    		 ca = n/10;
    	}
    	if(ca == 1) {
    		pre = node;
    		node = new Node(1);
    		node.next = pre;
    	}
    	return node;
    }
    /**
     *     解法二：链表反转 
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList2(Node head1,Node head2) {
    	 head1=reverse(head1);
    	 head2=reverse(head2);
    	 Node c1 = head1;
    	 Node c2 = head2;
    	 int n1,n2,n;
    	 int ca = 0;
    	 Node pre = null;
    	 Node node = null;
    	 while(c1 != null || c2 != null) {
    		n1 = c1!= null ? c1.value : 0;
    		n2 = c2 != null ? c2.value : 0;
    		n = n1 + n2 + ca;
    		pre = node;
    		node = new Node(n%10);
    		node.next = pre;
    		ca = n/10;
    		c1 = c1 != null ? c1.next : null;
    		c2 = c2 != null ? c2.next : null;
    	 }
    	 if(ca == 1) {
    		 pre = node;
    		 node = new Node(1);
    		 node.next = pre;
    	 }
    	 return node;
    }
	private static Node reverse(Node head) {
		 Node pre = null;
		 Node cur = head;
		 Node next = null;
		 while(cur != null) {
			 next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
		 return pre;
	}
	private static void Print(Node head) {
		while(head != null) {
			System.out.print(head.value+" ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		Node head1 = new Node(9);
		head1.next = new Node(3);
		head1.next.next = new Node(7);
		Node head2 = new Node(6);
		head2.next = new Node(3);
		head1=addList2(head1, head2);
		Print(head1);
	}
}
