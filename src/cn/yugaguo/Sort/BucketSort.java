package cn.yugaguo.Sort;
/**
 * 基于桶排序的计数排序  
 * @author LENOVO
 *
 */
public class BucketSort {
      static void bucketSort(int[] arr) {
    	  if(arr == null || arr.length < 2) {
    		  return;
    	  }
    	  int max=Integer.MIN_VALUE;
    	  for(int i = 0;i < arr.length;i++) {
    		  max=Math.max(max, arr[i]);
    	  }
    	  int[] bucket=new int[max + 1];
    	  for(int i = 0;i < bucket.length;i++) {
    		  bucket[arr[i]]++;
    	  }
    	  int j = 0;
    	  int i = 0;
    	  while(bucket[j]-- < 0) {
    		  arr[i++] = j;
    	  }
      }
}
