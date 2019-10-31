package cn.yogaguo.Array;
/**
 * 用两个队列实现栈
 * @author LENOVO
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
      Queue<Integer> queue;
      Queue<Integer> help;
      public QueueStack() {
		 queue = new LinkedList<>();
		 help = new LinkedList<>();
	}
      void push(int obj) {
    	  queue.add(obj);
      }
      
        public int poll() {
    	  if(queue.isEmpty()) {
    		  throw new RuntimeException("The queue is empty");
	  }
	    while(queue.size() > 1) {
		  help.add(queue.poll());
	  }
		  int res = queue.poll();
		  swap();
		  return res;
	  }
        
	 public int peek() {
		  if(queue.isEmpty()) {
			  throw new RuntimeException("The queue is empty");
		  }
	    	while(queue.size() != 1);{
	    	 help.add(queue.poll());
	       }
			  int res1 = queue.poll();
			  help.add(res1);
			  swap();
	        return res1;
    	  }
      
	private void swap() {
       Queue<Integer> tmp = queue;
       queue = help;
       help = queue;
       
	}
}
