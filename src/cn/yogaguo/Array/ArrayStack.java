package cn.yogaguo.Array;


public class ArrayStack {
     private Integer[] arr;   
     private Integer Index;
     public ArrayStack(int InitSize) {
		 if(InitSize < 0) {
			throw new IllegalArgumentException("Tne init size less than 0");
		 }
		 arr = new Integer[InitSize];
		 Index = 0;
	}
      void push(int obj) {
    	 if(Index == arr.length) {
    		 throw new ArrayIndexOutOfBoundsException("The Stack is full !");
    	 }
    	 arr[Index++] = obj;
     }
     public Integer pop() {
    	if(Index == 0) {
    		throw new ArrayIndexOutOfBoundsException("The Stack is empty !");
    	}
    	return arr[--Index];
     }
     public Integer peek() {
    	 if(Index == 0) {
    		 return null;
    	 }
    	 return arr[Index - 1];
     }
}
