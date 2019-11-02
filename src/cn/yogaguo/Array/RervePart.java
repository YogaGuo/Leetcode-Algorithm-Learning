package cn.yogaguo.Array;
/**
 * 给定一个单向链表，以及两个整数from 和 to ，在单向链表上把第from个结点到第to个结点这一部分进行反转
 * 例如：1—>2->3->4->5->null from=2,to =4
 *    1->4->3->2->5->null 
 *    要求：如果链表长度为N，时间复杂度为O(N),额外空间复杂度O(1),
 *    如果不满足 1<=from<=to<=N,则不用调整
 * @author LENOVO
 *
 */
public class RervePart {
   static class Node{
	   private int value;
	   private Node next;
	   public Node(int data) {
		   this.value=data;
	   }
   }
   public static Node rervePart(Node head,int from,int to) {
	   if(head == null || head.next == null) {
		   return head;
	   }
	   int len=0;
	   Node cur=head;
	   Node fPre=null;
	   Node tPos=null;
	   while(cur!=null) {
		   len++;
		   fPre = len == from-1 ? cur :fPre;
		   tPos = len == to+1 ? cur : tPos;
		    cur = cur.next;
	   }
	   if(from < 1 || from > to || to > len) {
		   return head;
	   }
	   Node n1 = fPre != null ? fPre.next : head;
	   Node n2 = n1.next;
	   n1.next = tPos;
	   Node next = null;
	   while(n2 != tPos) {
		   next = n2.next;
		   n2.next = n1;
		   n1 = n2;
		   n2 = next;
	   }
	   if(fPre != null) {
		   fPre.next = n1;
		   return head;
	   }
	   return n1;
   }
   public static void Print(Node head) {
	   Node cur = head;
	   while(cur!= null) {
		  System.out.print(cur.value+" ");
		  cur = cur.next;
	   }
   }
   public static void main(String[] args) {
	Node head = new Node (1);
	head.next = new Node(2);
	head.next.next = new Node(3);
	head.next.next.next = new Node(4);
	head.next.next.next.next = new Node(5);
	head=rervePart(head, 2, 4);
	Print(head);
}
}
