package com.yogaguo.DP;
/**
 * 求二维数组最短路径和，从暴力递归到动态规划
 * @author LENOVO
 *
 */
public class MinPathSum {
	/**
	 * 暴力递归
	 * @param matrix
	 * @param i
	 * @param j
	 * @return
	 */
   public static int minPathSum(int[][] matrix,int i,int j) {
	   if(i == matrix.length - 1 && j == matrix[0].length - 1) {
		   return matrix[i][j];
	   }
	   if(i == matrix.length - 1) {
		   return matrix[i][j] + minPathSum(matrix, i, j+1);
	   }
	   if(j == matrix[0].length - 1) {
		   return matrix[i][j] + minPathSum(matrix,i+1,j);
	   }
	   int right = minPathSum(matrix, i, j+1);
	   int down = minPathSum(matrix, i+1, j);
	   return matrix[i][j] + Math.min(right, down);
   }
   /**
    *   动态规划
    * @param matrix
    * @param i
    * @param j
    * @return
    */
   public static int minPathSum2(int[][] matrix) {
	   if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		   return 0;
	   }
	   int row = matrix.length - 1 ;
	   int col = matrix[0].length - 1;
	   int[][] DP = new int[row+1][col+1];
	   DP[row][col] = matrix[row][col];// base case
	   //填充最后一行其他位置的状态值
	   for( int i = row,j = col - 1;j >=0;j--) {
		   DP[i][j] = matrix[i][j] + DP[i][j + 1];
	   }
	   //填充最后一列的其他位置的状态值
	   for(int j = col,i = row -1; i>=0;i--) {
		   DP[i][j] = matrix[i][i] + DP[i + 1][j];
	   }
	    for(int i = row - 1; i >= 0;i--) {
	    	for(int j = col - 1; j >= 0;j--) {
	    		DP[i][j] = matrix[i][j] + Math.min(DP[i + 1][j], DP[i][j + 1]);
	    	}
	    }
	   return DP[0][0];	   
   }
   public static void main(String[] args) {
	int[][] matrix = {{3,1,0,2},{4,3,2,1},{5,2,1,0}};
	//int res=minPathSum(matrix, 0, 0);
	int res1=minPathSum2(matrix);
	System.out.println(res1);
}
}
