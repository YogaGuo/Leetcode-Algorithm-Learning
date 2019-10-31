package cn.yugaguo.Sort;
/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)且要求不能用非基于比较的排序。
 * @author LENOVO
 *
 */
public class Max_Gap {
	 static int  maxGap(int[] arr) {
		 if(arr == null || arr.length < 2) {
			 return 0;
		 }
		 int max=Integer.MAX_VALUE;
		 int min=Integer.MIN_VALUE;
		 int len=arr.length;
		 for(int i = 0;i<arr.length;i++) {
			 max=Math.max(max, arr[i]);
			 min=Math.min(min, arr[i]);
		 }
		 if(max == min) {
			 return 0;
		 }
		 boolean[] hasNums = new boolean[len + 1];
		 int[] Max = new int[len + 1];
		 int[] Min = new int[len + 1];
		 int bid = 0; 
		 for(int i = 0;i < len;i++) {
		     bid=bucket(arr[i],len,max,min);
			 Max[bid] = hasNums[i] ? Math.max(arr[i], Max[bid]) : arr[i];
			 Min[bid] = hasNums[i] ? Math.min(arr[i], Min[bid]) : arr[i];
			 hasNums[i] = true;
		 }
		 int res=0;//设置全局变量!!!
		 int largest=Max[0];
		 int i = 1;
		 for(; i<=len;i++) {
			 if(hasNums[i]) {
				 res=Math.max(Min[i] - largest, res);
				 largest = Max[i];
			 }
		 }
		 return res;
	 }

	private static int bucket(long num, long len, long max, long min) {
		return (int)((num - min) * len / (max- min)); 
		 
	}
	public static void main(String[] args) {
		int[] arr = {2,6,1,34,28,77,23};
		System.out.println(maxGap(arr));
		
	}

		 
}
