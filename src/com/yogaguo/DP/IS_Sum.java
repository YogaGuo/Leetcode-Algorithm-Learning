package com.yogaguo.DP;
/**
 * 给定一个数组arr ，和一个整数 aim,如果可以任意选择 arr 的数组，能不能累加得到 aim ,返回 true, 或 false
 * @author LENOVO
 *
 */
public class IS_Sum {
	/**
	 * 暴力递归
	 * @param arr
	 * @param i
	 * @param sum
	 * @param aim
	 * @return
	 */
    public static boolean isSum1(int[] arr, int i ,int sum,int aim) {
    	if(i == arr.length) {
    		return sum == aim;
    	}
    	return isSum1(arr,i + 1,sum,aim) || isSum1(arr,i + 1, sum + arr[i], aim);
    }
    /**
     * 动态规划
     * @param arr
     * @param aim
     * @return
     */
    public static boolean isSum2(int[] arr,int aim) {
    	if(arr == null || arr.length == 0) {
    		return false;
    	}
    	boolean DP[][] = new boolean[arr.length + 1][aim + 1];
    	//填好最后一行
    	for(int i = arr.length,sum = 0;sum <= aim; sum++) {
    		if(sum == aim) {
    			DP[i][sum] = true;
    		}
    		DP[i][sum] = false;
    	}
    	for(int i = arr.length - 1; i >= 0; i--) {
    		for(int sum = aim; sum >= 0; sum--) {
    			if(sum + arr[i] > aim) {
    				DP[i][sum] = DP[i+1][sum]; 
    			}else {
    				DP[i][sum] = DP[i+1][sum] || DP[i+1][sum + arr[i]];
    			}
    		}
    	}
    	return DP[0][0];
    }
    public static void main(String[] args) {
		int [] arr = {3,2,7,13};
		boolean res=isSum1(arr, 0, 0, 9);
		boolean res1=isSum2(arr,9);
		System.out.println(res1);
    	 
	}
}
