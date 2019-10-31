package cn.yugaguo.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * @author LENOVO
 *
 */
public class BubbleSort {
      public static void bubbleSort(int[] arr) {
    	  if(arr==null||arr.length<2) {
    		  return;
    	  }
    	  for(int end=arr.length-1;end>0;end--) {
    		  for(int i=0;i<end;i++) {
    			  if(arr[i]>arr[i+1]) {
    				  swap(arr,i,i+1);
    			  }
    		  }
    	  }
      }

	private static void swap(int[] arr, int i, int j) {
		 int temp=arr[i];
		 arr[i]=arr[i+1];
		 arr[i+1]=temp;
	}
	/**
	 * 对数器
	 * @return
	 */
	private static int[] generateRandomArray() {
		Random r=new Random();
		int[] arr=new int[10000];    //注意：一定要拷贝！！！！
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(10000);
		}
		return arr;
	}
	static void check() {
		int[] arr=generateRandomArray();
		int[] arr2=new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		Arrays.sort(arr);
		BubbleSort.bubbleSort(arr2);
		boolean same=true;
		for(int i=0;i<arr2.length;i++) {
			if(arr[i]!=arr2[i]) {
				same=false;
			}
		}
		System.out.println(same==true?"right":"wrong");
	}
	public static void main(String[] args) {
		check();
	}
}
