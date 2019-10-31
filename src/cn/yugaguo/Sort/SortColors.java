package cn.yugaguo.Sort;
/**
 * 荷兰国旗的变形：快排思想的 partition过程：
 * 输入域：[2,0,2,1,1,0]
 * 输出域：[0,0,1,1,2,2]
 * @author LENOVO
 *
 */
public class SortColors {
	 public static void sortColors(int[] arr) {
	    	if(arr == null || arr.length == 0) {
	    		return;
	    	}
	    	int pivot = 1;
	    	int less = -1;
	    	int more = arr.length;
	    	int l = 0;
	    	while(l < more) {
	    		if(arr[l] < pivot ) {
	    			swap(arr,++less,l++);
	    		}else if(arr[l] > pivot) {
	    			swap(arr,--more,l);
	    		}else {
	    			l++;
	    		}
	    	}
	    }

		private static void swap(int[] arr, int i, int j) {
			 int temp = arr[i];
			 arr[i] = arr[j];
			 arr[j] = temp;
			
		}
		public static void main(String[] args) {
			int[] arr = {2,0,2,1,1,0};
			sortColors(arr);
			 for(int i = 0;i<arr.length;i++) {
				 System.out.print(arr[i]+" ");
			 }
		}
}
