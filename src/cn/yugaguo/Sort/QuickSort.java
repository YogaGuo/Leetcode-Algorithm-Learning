package cn.yugaguo.Sort;

import java.util.Arrays;

public class QuickSort {
      static void quickSort(int[] arr,int L,int R) {
    	  if(arr==null||arr.length<2) {
    		  return;
    	  }
    	  merge(arr,L,R);
      }

	private static void merge(int[] arr, int l, int r) {
        if(l < r) {
        	 swap(arr,l+(int)(Math.random()*(r-l+1)),r);
        	 int[] pivot=partition(arr, l, r);
        	 merge(arr, l, pivot[0]-1);
        	 merge(arr, pivot[1]+1, r);
        }
        
	}
	static int[] partition(int[] arr,int L,int R) {
		int less=L-1;
		int more=R;
		while(L < more) {
			if(arr[L] < arr[R]) {
				swap(arr,++less,L++);
			}else if(arr[L] > arr[R]) {
				swap(arr,--more,L);
			}else {
				L++;
			}
		}
		swap(arr,more,R);
		return new int[] {less+1,more};
	}

	private static void swap(int[] arr, int more, int r) {
    		int temp=arr[more];
    		arr[more]=arr[r];
    		arr[r]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {2,5,7,1,9,3,6,2,10};
		//quickSort(arr, 0, arr.length-1);
		//InsertionSort.insertionSort(arr);
		MergerSort.sortProcess(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}
}
