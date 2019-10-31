package cn.yugaguo.Sort;

public class TestRecursion {
     static int getMax(int[] arr,int L,int R) {
    	 if(L==R) {    //base case递归终止条件    
    		 return arr[L];
    	 }
    	 int mid=(L+R)/2; //更好的方式：L+((R-L)/2)防止溢出
    	 int maxLeft=getMax(arr,L,mid);		 
    	 int maxRright=getMax(arr,mid+1,R);
    	 return Math.max(maxLeft, maxRright);
     }
     public static void main(String[] args) {
		int[] arr= {3,0,9,1,8,6,5};
		int max=getMax(arr, 0, arr.length-1);
		System.out.println(max);
	}
}
