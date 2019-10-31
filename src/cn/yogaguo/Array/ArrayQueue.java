package cn.yogaguo.Array;

public class ArrayQueue {
      private Integer[] arr;
      private Integer size;
      private Integer end;
      private Integer start;
      public ArrayQueue(int InitSize) {
		 if(InitSize < 0 ) {
			 throw new IllegalArgumentException("The init size is less than 0");
			 }
		 arr = new Integer[InitSize];
		 size = 0;
		 end = 0;
		 start = 0;
	}
     public void push(int obj) {
    	 if(size == arr.length) {
    		 throw new ArrayIndexOutOfBoundsException("The "
    		 		+ "Queue is full !");
    	 }
    	 size++;
    	 arr[end] = obj;
    	 end = hasMove(size,end);
     }
     public int poll() {
    	 if(size == 0) {
    		 throw new ArrayIndexOutOfBoundsException("The Queue is empty !");
    	 }
    	 size--;
    	 int tmp=start;
    	 start = hasMove(size, start);
    	 return arr[tmp];
     }
     public int peek() {
    	 if(size == 0) {
    		 return 0;
    	 }
    	 return arr[start];
     }
	private int hasMove(int Size, int Index) {
		return Index == Size - 1 ? 0 : Index + 1;
	}
}
