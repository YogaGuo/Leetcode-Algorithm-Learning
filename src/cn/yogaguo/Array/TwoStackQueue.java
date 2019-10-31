package cn.yogaguo.Array;

import java.util.Stack;

public class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;
       public TwoStackQueue() {
    	   stackPush = new Stack<>();
    	   stackPop = new Stack<>();
       }
       
     public void push(int obj) {  
    	 stackPush.push(obj);
     }
     
     public int poll() {
    	 if(stackPush.isEmpty() && stackPop.isEmpty()) {
    		 throw new RuntimeException("Queue is empty！");
    	 }
    	 dao();
    	 return stackPop.pop();
     }
     
     public void dao() {
    	 if(stackPop.isEmpty()) {
    		 while(!stackPush.isEmpty()) {
    			 stackPop.push(stackPush.pop());
    		 }
    	 }
     }
     
}
