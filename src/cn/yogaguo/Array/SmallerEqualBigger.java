package cn.yogaguo.Array;
/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5-
>1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总
之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求
 * @author LENOVO
 *
 */
public class SmallerEqualBigger {
	public static class Node{
		int value;
		 Node next;
		public Node(int data) {
			 this.value = data;
		 }
	}
  static Node listPartition(Node head,int pivot) {
	  if(head == null) {
		  return head;
	  }
	  Node cur = head;
	  int i =0;
	  while(cur != null) {
		  i++;
		  cur = cur.next;
	  }
	  Node[] arrNode = new Node[i];
	  
	  cur =head;
	  for(i = 0;i < arrNode.length;i++) {
		  arrNode[i] = cur;
		  cur = cur.next;
	  }
	  arrPartition(arrNode, pivot);
	  for( i =1;i != arrNode.length;i++) {
		  arrNode[i -1].next = arrNode[i];
	  }
	  arrNode[i - 1].next = null;
	  return arrNode[0];
	  
  }
     private static void arrPartition(Node[] arrNode, int pivot) {
	   int less = -1;
	   int L = 0;
	   int more = arrNode.length;
	   while(L < more) {
		   if(arrNode[L].value < pivot) {
			   swap(arrNode,++less,L++);
		   }else if(arrNode[L].value > pivot) {
			   swap(arrNode,--more,L);
		   }else {
			   L++;
		   }
	   }
}
	private static void swap(Node[] arrNode, int i, int l) {
      Node temp = arrNode[i];
      arrNode[i] = arrNode[l];
      arrNode[l] = temp;
	}
	/**
	 * 进阶：要求额外空间复杂度O(1),并且相对次序不变(稳定)
	 * @param args
	 */
	  static Node listPartition2(Node head,int pivot) {
		  if(head == null) {
			  return head;
		  }
		  Node sH = null;
		  Node sT = null;
		  Node eH = null;
		  Node eT = null;
		  Node bH = null;
		  Node bT = null;
		  while(head != null) {
			  Node next = head.next;
			  head.next = null;
			  if(head.value > pivot) {
				  if(bH == null) {
					  bH = head;
					  bT = head;
				  }else {
					  bT.next = head;
					  bT = head;
				  }
			  }
			  if(head.value < pivot) {
				  if(sH == null) {
					  sH = head;
					  sT = head;
				  }else {
					  sT.next = head;
					  sT = head;
				  }
			  }
			  if(head.value == pivot) {
				  if(eH == null) {
					  eH = head;
					  eT = head;
				  }else {
					  eT.next = head;
					  eT = head;
				  }
			  }
			  head = next; //移动
		  }
		  //Small equal connection
		  if(sH != null) {
			  sT.next = eH;
			  eT = eT != null ? eT : sT; //检测 equal 区是否存在结点，防止空节点去连接 大于区的头结点
		  }
		  //All Node reconnection
		  if(eT != null) {
			  eT.next = bH;
		  }
		  return sH != null ? sH :eH != null ? eH : bH;
	  }
	public static void main(String[] args) {
		Node head = null;
		head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);
		head = SmallerEqualBigger.listPartition2(head, 3);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	} 
}
