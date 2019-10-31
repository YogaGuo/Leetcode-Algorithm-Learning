package cn.yogaguo.Array;
import java.util.HashMap;

/**
 * 复制含有随机指针的链表
 * @author LENOVO
 *
 */
public class CopyListWithRandom {
   static class Node{
	   public int value;
	   public Node next;
	   public Node random;
	   public Node(int data) {
		   this.value = data;
	   }
   }
   /**
    * Case 1:Use Hash
    * @param head
    * @return
    */
   public static Node copyListRandom1(Node head) {
	   HashMap<Node, Node> map = new HashMap<>();
	   Node cur = head;
	   while(cur != null) {
		   map.put(cur, new Node(cur.value));
		   cur = cur.next;
	   }
	   Node x = head;
	   while(x != null) {
		   map.get(x).next = map.get(x.next);
		   map.get(x).random = map.get(x.random);
		   x = x.next;
   }
	   return map.get(head);
}
   /**
    * Case 2:
    */
   public static Node copyListWithRandom2(Node head) {
	   Node cur = head;
	   Node next = null;
	   // copy node link to list
	   while(cur != null) {
		    next = cur.next;
		    cur.next = new Node(cur.value);
		    cur.next.next = next;
		    cur = next;
	   }
	   //set copy node random
	   cur = head;
	   Node curcopy = cur.next;
	   while(cur != null) {
		   next = cur.next.next;
		   curcopy = cur.next;
		   curcopy.random = cur.random != null ? cur.random.next: null;
		   cur = next;
	   }
	   //Split
	   Node res = head.next;
	   cur = head;
	   while(cur != null) {
		   next = cur.next.next;
		   curcopy = cur.next;
		   curcopy.next = next != null ? next.next : null;
		   cur = next;
	   }
	   return res;
   }
}
