package cn.yugaguo.Sort;

import java.util.Arrays;

public class MergerSort {
         static void sortProcess(int[]arr,int L,int R) {   //记住，父问题如何保证排序，子问题就如何保证,反之一样
        	 if(L==R) {
        		 return;
        	 }
        	 int mid = L+((R-L) >> 1);
        	 sortProcess(arr, L, mid);
        	 sortProcess(arr, mid+1, R);
        	 merger(arr,L,mid,R);
         }

		private static void merger(int[] arr, int l, int mid, int r) {
         int[] help = new int[r-l+1];
         int i = 0;
         int p1 = l;
         int p2 = mid+1;
         while(p1 <=  mid && p2 <= r) {
        	 help[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];
         }
         //两个必有一个越界,直接拷贝
         while(p1 <= mid) {
        	 help[i++]=arr[p1++];
         }
         while(p2 <= r) {
        	 help[i++] = arr[p2++];
         }
         for(i=0;i < help.length;i++) {
        	 arr[l+i] = help[i];//!!!，比如，help数组从0-7开始，而原子数组从10-17开始，拷贝时时从0拷到0+10。。。
        	 }
		}
		public static void main(String[] args) {
			int[] arr={3,0,8,1,64,2};
			sortProcess(arr,1 ,4 );
			System.out.println(Arrays.toString(arr));
			
		}
}
