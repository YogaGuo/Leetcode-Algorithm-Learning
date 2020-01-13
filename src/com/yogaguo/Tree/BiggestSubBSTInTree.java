package com.yogaguo.Tree;
/**
 * 给定一棵二叉树的头节点head，请返回最大搜索二叉子树的大小
 * 大致流程： 以每一个节点为头的情况下的整棵树讨论 3 种情况：
 *       - 1 以 一个节点为头，左子树中的某一颗子树为最大搜索子树 
 *       - 2 以 一个节点为头，右子树中的某一颗子树为最大搜索子树 
 *       - 3 左子树和右子树整体都是 BST，左树的 max 小于 当前节点；右树的 min 大于当前结点，则以当前节点为头的整棵树为BST
 * 我们要收集的信息：
 *       1 左子树中最大BST的size   2  右子树中最大BST的size
 *       3 左树上最大BST的头部是否等于当前节点的左孩子，如果等于，以当前节点为头的整颗树是BST
 *       4 右树上最大BST的头部是否等于当前节点的右孩子，如果等于，以当前节点为头的整颗树是BST
 *       5 左树最大 max
 *       6 右树最小 min 
 * 进一步抽象为：
 *       1 不管是左树还是右树，收集 它 的 size
 *       2 不管是左树还是右树，收集 它 的 head                     
 *       2 不管是左树还是右树，收集 它 的 max min                     
 * @param data
 */
public class BiggestSubBSTInTree {
   static class Node{
	   private Node left;
	   private Node right;
	   private int value;
	   public Node(int data) {
		   this.value = data;
	   }
   }
   public static Node getResult(Node head) {
	     ReturnType node = process(head);
	     return node.head;
   }
   static class ReturnType{
	   private int size;
	   private Node head;
	   private int min;
	   private int max;
	   public ReturnType(int size,Node head,int min,int max) {
		   this.size = size;
		   this.head = head;
		   this.min = min;
		   this.max = max;
	   }
   }
   public static ReturnType process(Node head) {
	   if(head == null) {
		   new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
	   }
	   Node left = head.left;
	   Node right = head.right;
	   ReturnType leftSubTreeInfo = process(left);
	   ReturnType rightSubTreeInfo = process(right);
	   int includeItSelf = 0;
	   if(leftSubTreeInfo.head == left
			   && rightSubTreeInfo.head == right
			   && leftSubTreeInfo.max < head.value
			   && rightSubTreeInfo.min > head.value
			   ) {
		   includeItSelf = leftSubTreeInfo.size + 1 + rightSubTreeInfo.size;
	   }
	   int p1 = leftSubTreeInfo.size;
	   int p2 = rightSubTreeInfo.size;
	   int maxSize = Math.max(Math.max(p1, p2),includeItSelf);
	   Node maxHead = p1 > p2 ? leftSubTreeInfo.head : rightSubTreeInfo.head;
	   if(maxSize == includeItSelf ) {
		   maxHead = head;
	   }
	   return new ReturnType(maxSize, maxHead, 
			            Math.min(Math.min(leftSubTreeInfo.min, rightSubTreeInfo.min), head.value),
			            Math.max(Math.max(leftSubTreeInfo.max, rightSubTreeInfo.max), head.value));
   }
}
