package cn.yugaguo.Sort;

public class InsertionSort {
        static void insertionSort(int[] arr) {
        	if(arr==null||arr.length<2) {
        		return;
        	}
        	for(int i=1;i<arr.length;i++) {
        		for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--) {
        			 swap(arr,j,j+1);
        		}
        	}
        }

		private static void swap(int[] arr, int j, int i) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
}
