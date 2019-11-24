package com.yogaguo.DP;



/**
 * 0 1 背包 DP[i][j]:前 i 件物品，不超过 y 重量 的最大价值
 * @author LENOVO
 *
 */
@SuppressWarnings("all")
public class Knapsack {
    public static int maxValue(int[] w,int[] v,int bag) {
       int[][] DP = new int[w.length + 1][bag + 1];
       boolean[] X = new boolean[w.length];
       for(int i = 0; i < DP[0].length ; i++ ) {
    	   DP[0][i] = 0;
       }
       for(int i = 0; i < DP.length; i++ ) {
    	   DP[i][0] = 0;
       }
       for(int i = 1; i < DP.length; i++) {
    	   for(int j = 1; j < DP[0].length; j++) {
    		   DP[i][j] = DP[i - 1][j];
    		   if(w[i - 1] <= j) {
    			   DP[i][j] = Math.max(DP[i - 1][j], v[i - 1] + DP[i - 1][j - w[i - 1]]);
    		   }
    	   }
       }
        int Max_Value =DP[w.length][bag];
        for(int i = X.length - 1; i > 0; i--) {
        	if(DP[i+1][bag] > DP[i][bag]) {
        		X[i] = true ;
        		bag -= w[i];
        	}else {
        		X[i] = false;
        	}
        }
        int Sum_Weght = 0;
          for(int i = 0; i<X.length;i++) {
        	   if(X[i] == true) {
        		   System.out.print(i+1+" ");
        		   Sum_Weght += w[i];
        	   }
          }
          System.out.print(Sum_Weght+" ");
          
        return Max_Value;
    }
     
    

	public static void main(String[] args) {
    	int[] c = { 3, 2, 4, 7 };
		int[] v = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue(c, v, bag));
		 
	}
}
