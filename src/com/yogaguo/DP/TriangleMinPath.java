package com.yogaguo.DP;

import java.util.Arrays;
import java.util.List;

public class TriangleMinPath {
	 public static int minimumTotal(   int[][] triangle) {
	        int n = triangle[0].length;
	        int[][] dp = new int[n+1][n+1];
	        for(int i = 1; i <=n; i++){
	           for(int j = 1; j <= i; j++){
	               dp[i][j] = triangle[i-1][j-1];
	               if(i==1&&j==1) continue;
	               if(j==1) dp[i][j] += dp[i-1][j];
	               else if(j==i) dp[i][j] += dp[i-1][j-1];
	               else dp[i][j] += Math.min(dp[i-1][j],dp[i-1][j-1]);
	           }
	        }
	           int res = dp[n][1];
	           for(int i=2;i<=n;i++){
	               res = Math.min(res,dp[n][i++]);
	           }
	           return res;
	    }
	 public static void main(String[] args) {
		//int[][] triangle = {{-1},{2,3},{1,-1,-3}};
		 int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println(minimumTotal(triangle));
	}
	 
}
