package cn.yogaguo.Array;
/**
 * 分别实现两个函数，一个可以删除单向链表中的倒数第K个结点，另一个可以删除双向链表第倒数第K个结点
 * 如果链表长度为N,时间复杂度为O(N),额外空间复杂度为O(1)
 * @author LENOVO
 *
 */
public class RemovLastKthNode {
  static class Node{
	  private int value;
	  private Node next;
	  public Node (int data) {
		  this.value = data;
	  }
  }
  static class Node2{
	  private int value;
	  private Node2 next;
	  private Node2 last;
	  public Node2(int data) {
		  this.value = data;
	  }
  }
  /**
   * 单链表的删除
   * @param head
   * @param k
   * @return
   */
  public static Node removeLastKthNode(Node head,int k) {
	  if(head == null || k < 1) {
		  return head;
	  }
	  Node cur = head;
	  while(cur != null) {
		  k--;
		  cur = cur.next;
	  }
	  if(k == 0) {
		   head = head.next; 
	  }
	  else if(k < 0) {
		  cur = head;
		  while(++k != 0) {
			  cur = cur.next;
		  }
		  cur.next = cur.next.next;
	  }
	  return head;
  }
    public static Node Test(Node head,int k) {
    	if(head == null || k < 1) {
    		return head;
    	}
    	Node help = new Node(0);
    	help.next = head;
    	Node p = help;
    	Node q = help;
    	int n = 0;
    	while(q != null && n != k + 1 ) {
    		q = q.next;
    		n++;
    	}
    	while( q != null) {
    		p = p.next;
    		q = q.next;
    	}
    	p.next = p.next.next;
    	return help.next;
    }
  /**
   * 双向链表的删除
   * @param head
   * @param k
   * @return
   */
  public static Node2 removeLastKthNode2(Node2 head,int k) {
	  if(head == null || k < 1) {
		  return head;
	  }
	  Node2 cur = head;
	  while(cur != null) {
		  k--;
		  cur = cur.next;
	  }
	  if(k == 0) {
		  head=head.next;
	  }
	  else if( k < 0) {
		  cur = head;
		  while(++k != 0) {
			  cur = cur.next;
		  }
		  Node2 next = cur.next.next;
		  cur.next = next;
		  if(next != null) {
			  next.last = cur;
		  }
	  }
	  return head;
  }
  public static void main(String[] args) {
	Node head = new Node(1);
	head.next = new Node(4);
	head.next.next = new Node(2);
	head.next.next.next = new Node(9);
	head.next.next.next.next = new Node(7);
	//head=removeLastKthNode(head, 5);
	head=Test(head, 2);
	while(head != null) {
		System.out.print(head.value+" ");
		head=head.next;
	}
}
}
