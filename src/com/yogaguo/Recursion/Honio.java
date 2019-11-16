package com.yogaguo.Recursion;
/**
 * 汉诺塔问题
 * @author LENOVO
 *
 */
public class Honio {
	public static void hanio(int N) {
		func(N,"左","右","中");
	}

	private static void func(int N,String from, String to, String help) {
		 if(N == 1) {
			 System.out.println("Move1 from"+from+" to "+to);
		 }else {
			 func(N-1,from,help,to);
			 System.out.println("Move"+N+" from "+ from +"to"+to);
			 func(N-1,help,to,from);
		 }
	}
    public static void main(String[] args) {
		hanio(3);
	}
}
