package cn.yogaguo.Array;
/**
 * 打印两个链表值相等的结点
 * @author LENOVO
 *
 */
public class PrintCommonPart {
   static class Node{
	   public int value;
	   public Node next;
	   public Node(int data) {
		   this.value = data;
	   }
   }
   public static void printCommonPart(Node head1,Node head2) {
	   Node cur1 = head1;
	   Node cur2 = head2;
	   while(cur1 != null && cur2 != null) {
		   if(cur1.value < cur2.value) {
			   cur1 = cur1.next;
		   }else if(cur1.value > cur2.value) {
			   cur2 = cur2.next;
		   }else {
			   System.out.print(cur1.value + " ");
			   cur1 = cur1.next;
			   cur2 = cur2.next;
		   }
	   }
   }
   public static void printList(Node head) {
	   Node cur = head;
	   while(cur != null) {
		   System.out.print(cur.value + " ");
		   cur = cur.next;
	   }
   }
   public static void main(String[] args) {
	Node head1 =new Node(2);
	head1.next = new Node(3);
	head1.next.next = new Node(5);
	head1.next.next.next = new Node(6);
	
	Node head2 = new Node (1);
	head2.next = new Node(2);
	head2.next.next = new Node(5);
	head2.next.next.next = new Node(7);
	head2.next.next.next.next = new Node(8);
	
	printList(head1);
	System.out.println("");
	printList(head2);
	System.out.println("");
	printCommonPart(head1, head2);
}
}
