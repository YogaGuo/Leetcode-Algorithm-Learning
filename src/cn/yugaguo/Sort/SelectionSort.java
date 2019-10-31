package cn.yugaguo.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 * @author LENOVO
 *
 */
public class SelectionSort {
            static void selectionSort(int[] arr) {
            	if(arr==null||arr.length<2){
            		return;
            	}
            	for(int i=0;i<arr.length;i++) {
            		int minIndex=i;
            		for(int j=i+1;j<arr.length;j++) {
            			minIndex=arr[j]<arr[minIndex]?j:minIndex;
            		}
            		swap(arr,i,minIndex);
            	}
            }

	    private static void swap(int[] arr, int i, int minIndex) {
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
			}
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
