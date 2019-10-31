package cn.yugaguo.Sort;

import java.util.Arrays;

public class HeapSort {
         static void heapSort(int[] arr) {
        	 if(arr==null||arr.length<2) {
        		 return;
        	 }
        	 for(int i=0;i<arr.length;i++) {
        		 heapInsert(arr, i);
        	 }
        	 int heapSize=arr.length;
        	 swap(arr,0,--heapSize);        	 while(heapSize > 0) {
        		 heapify(arr,0,heapSize);
        		 swap(arr,0,--heapSize);
        	 }
        	 
         }

		private static void heapInsert(int[] arr, int Index) {
           	while(arr[Index] > arr[(Index-1)/2]) {
           		swap(arr,Index,(Index-1)/2);
           		Index=(Index-1)/2;
           	}
		}
		
		private static void heapify(int[] arr, int i, int heapSize) {
           int left=2 * i + 1;
           while(left < heapSize) {
        	   int largest=arr[left+1] > arr[left] && left + 1 < heapSize ? left +1 : left;
        	   largest = arr[largest] > arr[i] ? largest : i;
        	   if(largest == i) {
        		   break;
        	   }
        	   swap(arr, largest, i);
        	   i=largest;
        	   left=2 * i +1;
           }
		}

		private static void swap(int[] arr, int index, int i) {
			 int temp=arr[index];
			 arr[index]=arr[i];
			 arr[i]=temp;
		}
		public static void main(String[] args) {
			int arr[] = {5,2,6,0,1,2,5,7};
			heapSort(arr);
			System.out.println(Arrays.toString(arr));
		}
}
