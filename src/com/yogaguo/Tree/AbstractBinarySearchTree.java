package com.yogaguo.Tree;
/** 
 * 
 * @author LENOVO
 *
 */
public class AbstractBinarySearchTree {
	 public Node root;
	 protected int size ;
	 public static class Node{
		   public int value;
		   public Node left;
		   public Node right;
		   public Node parent;
		public Node(int value, Node left, Node right, Node parent) {
				super();
				this.value = value;
				this.left = left;
				this.right = right;
				this.parent = parent;
			 }
		   }
	 /**
	  * 
	  * @param value
	  * @param parent
	  * @param left
	  * @param right
	  * @return
	  */
	    public Node createNode(int value,Node parent,Node left,Node right) {
	    	return new Node(value,parent,left,right);
	    }
	    /**
	     * 
	     * @param element
	     * @return
	     */
	   public Node search(int element) {
		   Node node = root;
		   while(node != null &&  node.value != element) {
			   if(element < node.value) {
				   node = node.left;
			   }
			   else {
				   node = node.right;
			   }
		   }
		   return node;
	   }
	   /**
	    * 
	    * @param element
	    * @return
	    */
	   public Node insert(int element) {
		   if(root == null) {
			   root = createNode(element, null,null,null);
			   size++;
			   return root;
		   }
		    Node insertParentNode = null;
		    Node searchTempNode = root;
		    while(searchTempNode != null ) {
		    	insertParentNode = searchTempNode;
		    	 if(element < searchTempNode.value) {
		    		 searchTempNode = searchTempNode.left;
		    	 }
		    	 else {
		    		 searchTempNode = searchTempNode.right;
		    	 }
		    }
		    Node newNode = createNode(element, null, null, null);
		    if(newNode.value < insertParentNode.value) {
		    	insertParentNode.left = newNode;
		    }
		    else {
		    	insertParentNode.right = newNode;
		    }
		     size++;
		     return newNode;
	   }
	   /**
	    * 
	    * @param element
	    * @return
	    */
	   public Node delete(int element) {
		   Node deleteNode = search(element);
		   if(deleteNode != null) {
			   return delete(deleteNode);
		   }
		   return null;
	   }
	   private Node delete(Node deleteNode) {
			if(deleteNode != null) {
				Node nodeToReplace = null;
				if(deleteNode.left == null) {
					nodeToReplace = transplant(deleteNode,deleteNode.right);
				}
				else if(deleteNode.right == null) {
					nodeToReplace = transplant(deleteNode, deleteNode.left);
				}
				else {
					Node successorNode = getMinmun(deleteNode.right);
					if(successorNode.parent != deleteNode) {
						transplant(successorNode, successorNode.right);
						successorNode.right = deleteNode.right;
						successorNode.right.parent = successorNode;
					}
					transplant(deleteNode, successorNode);
					successorNode.left = deleteNode.left;
					successorNode.left.parent = successorNode;
					nodeToReplace = deleteNode;
					size--;
				}
				 return nodeToReplace;
			}
			return null;
		}
	   private Node getMinmun(Node node) {
			 while(node.left != null) {
				 node = node.left;
			 }
			 return node;
		}
	   /**
	    * 
	    * @param nodeToReplace
	    * @param newNode
	    * @return
	    */
	   private Node transplant(Node nodeToReplace, Node newNode) {
			if(nodeToReplace.parent == null) {
				this.root = nodeToReplace;
			}
			else if(nodeToReplace.parent.right == nodeToReplace) {
				nodeToReplace.parent.right = newNode;
			}
			else {
				nodeToReplace.parent.left = newNode;
			}
			if(newNode != null) {
				newNode.parent = nodeToReplace.parent;
			}
			return newNode;
		}
	 /*  p = delte; t = p->right;
       while (t->left){
           p = t; t = t->left;
       }
       delte->val = t->val;
       if (p == delte)
           delte->right = t->right;
       else
           p->left = t->right;
   }
   
   free(t);
   return delte;*/

 
		    
}
