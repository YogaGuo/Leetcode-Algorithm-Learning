package cn.yogaguo.Union;

import java.util.HashMap;
import java.util.List;

 

/**
 * 查并集
 * @author LENOVO
 *
 */
public class UnionFind {
    public static  class Node{
    	/**
    	 * Whatever DataStruct you like   
    	 */
    }
    public static class UnionSet{
    	HashMap<Node,Node> fatherMap;
    	HashMap<Node, Integer> sizeMap;
	    public UnionSet(List<Node> nodes) {
	    	makeSets(nodes);
	    }
	    private void makeSets(List<Node> nodes) {
	    	fatherMap = new HashMap<>();
	    	sizeMap = new HashMap<>();
	        fatherMap.clear();
	        sizeMap.clear();
	       for(Node node : nodes) {
	    	   fatherMap.put(node, node);
	    	   sizeMap.put(node, 1);
	       }
	    }
      private Node findHead(Node node) {
    	 Node father =  fatherMap.get(node);
    	 if(father != node) {
    		 father = findHead(father);
    	 }
    	 fatherMap.put(node, father);
    	 return father;
      }
      public boolean isSameSet(Node a,Node b) {
    	  return findHead(a) == findHead(b);
      }
      public void union(Node a,Node b) {
    	  if(a == null || b == null) {
    		  return;
    	  }
    	  Node aHead = findHead(a);
    	  Node bHead = findHead(b);
    	  if(aHead != bHead) {
    		  int aSize = sizeMap.get(aHead);
    		  int bSize = sizeMap.get(bHead);
    		  if(aSize <= bSize) {
    			  fatherMap.put(aHead, bHead);
    			  sizeMap.put(bHead,  bSize + aSize);
    		  }else {
    			  fatherMap.put(bHead, aHead);
    			  sizeMap.put(aHead, bSize + aSize);
    		  }
    	  }
      }
    }
   
}
