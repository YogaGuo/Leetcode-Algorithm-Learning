package com.yogaguo.Tree;

import com.yogaguo.Tree.SerializeAndReconstrctTree.Node;
/**
 * 统计完全二叉树节点个数，时间复杂度低于O(N)
 * @author LENOVO
 *
 */
public class CompleteTreeNumber {
	  public static class Node{
		  private int value;
		  private Node left;
		  private Node right;
		  public Node(int data) {
			  this.value = data;
		  }
	  }
	public static int countNodes(Node head) {
        if(head == null){
            return 0;
        }
        return bs(head,1,mostLeft(head,1));
    }
    public static int bs(Node node,int l,int h){
        if(l == h){
            return 1;
        }
        if(mostLeft(node.right,l + 1)  == h){
            return (1 << (h -l)) + bs(node.right,l + 1,h);
        }else{
            return (1 << (h - 1- l)) + bs(node.left,l + 1,h);
        }
    }
       private  static int mostLeft(Node node,int level){
              while(node != null){
                  level++;
                  node = node.left;                     
              }                                            
                return level - 1;
    }
       public static void main(String[] args) {
	    	Node head = new Node(1);
			head.left = new Node(2);
			head.right = new Node(3);
			head.left.left = new Node(4);
			head.left.right = new Node(5);
		//	head.right.left = new Node(6);
			System.out.println(countNodes(head));
	}
}
