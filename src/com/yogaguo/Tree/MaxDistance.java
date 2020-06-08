package com.yogaguo.Tree;

import com.yogaguo.Tree.PrintTreeMaxAndMin.Node;

/**
 * 二叉树节点间最大距离
 * @author LENOVO
 *
 */
public class MaxDistance {
	static class Node{
		  private Node left;
		  private Node right;
		  private int value;
		  public Node(int data) {
			  this.value = data;
		  }
	  }
	static class ReturnType{
		private int maxDistance;
		private int deep;
		public ReturnType(int h,int deep) {
		 this.maxDistance = h;
		 this.deep = deep;
		}
	}
	public int getMaxDistance( ) {
		
	}
    public static ReturnType process(Node head) {
    	if(head == null) {
    		return new ReturnType(0, 0);
    	}
    	ReturnType leftData = process(head.left);
    	ReturnType rightData = process(head.right);
    	 int p1 = leftData.maxDistance;
    	 int p2 = rightData.maxDistance;
    	 int includeHeadDistance = leftData.deep + 1 + rightData.deep;
    	 int
    }
}
