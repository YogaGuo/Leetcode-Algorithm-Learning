package com.yogaguo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.yogaguo.Tree.IsBalanceTree.Node;

public class AverageOfLevelTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}
	 public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> res = new ArrayList<>();
	        if(root == null){
	            return res;
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	        	 long sum = 0;
	           int size = queue.size();
	           for(int i = 0; i< size;i++){
	               TreeNode node = queue.poll();
	               sum += node.val;
	               if(node.left != null){
	                   queue.offer(node.left);
	               }
	               if(node.right != null){
	                   queue.offer(node.right);
	               }
	           } 
	          Double avg = (Double)(sum * 1.0 / size);
	          res.add(avg); 
	        } 
	        return res;
	    }
	 public List<Double> averageOfLevels1(TreeNode root) {
	        List<Double> res = new ArrayList<>();
	       if(root == null){
	           return res;
	       } 
	       List<Double> levelSum = new ArrayList<>();
	       List<Integer> levelvCount = new ArrayList<>();
	       preOrder(root,0,levelSum,levelvCount);
	       for(int i = 0; i < levelvCount.size(); i++){
	           res.set(i,levelSum.get(i)/levelvCount.get(i));
	       }
	        return res;
	    }
	    public void preOrder(TreeNode root,int deepth,  List<Double> levelSum, List<Integer> levelvCount ){
	        if(root == null){
	            return;
	        }
	        if(deepth >= levelvCount.size()){
	            levelSum.add((double)root.val);
	            levelvCount.add(1);
	        }
	        levelvCount.set(deepth,levelvCount.get(deepth)+1);
	        levelSum.set(deepth,levelSum.get(deepth) + root.val);
	        preOrder(root.left,deepth + 1,levelSum,levelvCount);
	        preOrder(root.right,deepth + 1,levelSum,levelvCount);
	    }
}
