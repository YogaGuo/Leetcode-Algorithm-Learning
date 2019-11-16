package com.yogaguo.Recursion;
/**
 * 打印字符串的全排列
 * @author LENOVO
 *
 */
public class Print_All_Permutations {
     public static void permutations(String str) {
    	 procecss(str.toCharArray(),0);
     }

	private static void procecss(char[] str, int i) {
		 if(i == str.length) {
			 System.out.println(str);
		 }else {
			 for(int j=i;j<str.length;j++) {
				 swap(str,i,j);
				 procecss(str, i+1);
			 }
		 }
		
	}

	private static void swap(char[] str, int i, int j) {
		 char temp = str[i];
		 str[i] = str[j];
		 str[j] = temp;
	}
	public static void main(String[] args) {
		permutations("abc");
	}
}
