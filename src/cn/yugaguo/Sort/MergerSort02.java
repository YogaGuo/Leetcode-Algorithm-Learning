package cn.yugaguo.Sort;

import java.util.Arrays;

public class MergerSort02 {
	static void MSort(int[] arr,int help[],int L,int Rightend) {
		if(L==Rightend) {
			return;
		}
		int center=L+((Rightend-L) >> 1); /*(L+Rightend);*/
		MSort(arr, help, L, center);
		MSort(arr, help, center+1, Rightend);
		Merge(arr, help, L, center+1, Rightend);
	}
    static void Merge(int[] arr,int[] help,int L,int R,int Rightend ) {
    	  int Leftend = R-1;//左边终点位置。假设左右两列挨着
    	  int i = L;//存放结果的数组的起始位置
    	  int NumEle = Rightend-L+1;
    	  while(L<=Leftend && R <= Rightend) {
    		  help[i++] = arr[L] < arr[R] ? arr[L++] :arr[R++];
    	  }
    	 while(L <= Leftend) {
    		 help[i++]=arr[L++];
    	 }
    	 while(R <= Rightend) {
    		 help[i++]=arr[R++];
    	 }
    	 for(i=0;i<NumEle;i++,Rightend--) {
    		 arr[Rightend]=help[Rightend];
    	 }
      }
    static void Merge_Sort(int[]arr,int n) {
    	int[] help = new int[n];
    	MSort(arr, help, 0, n-1);
    }
    public static void main(String[] args) {
		int[] arr={3,6,1,8,0,34,5,6,8,4,9};
		Merge_Sort(arr, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
