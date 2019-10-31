package cn.yogaguo.Array;
/**
 *请按照  “ 之 ” 字型顺序打印出二维数组
 * @author LENOVO
 *
 */
public class ZigZagPrintMatrix {
       public static void printMatrixZigZag(int[][] Matrix) {
    	  int row1 = 0;
    	  int col1 = 0;
    	  int row2 = 0;
    	  int col2 = 0;
    	  int endR = Matrix.length - 1;
    	  int endC = Matrix[0].length - 1;
    	  boolean flag = false;
    	  while(row1 != endR + 1 ) {
    		  printLevel(Matrix, row1, col1, row2, col2, flag);
    		  row1 = col1 == endC ? row1 +1 : row1;
    		  col1 = col1 == endC ? col1 :col1 + 1;
    		  row2 = row2 == endR ? row2 : row2 + 1;
    		  col2 = row2 == endR ? col2 + 1 : col2;
    		  flag = !flag;
    	  }
    	  System.out.println();
       }
      public static void printLevel(int[][]m,int row1,int col1,int row2,int col2,boolean f ) {
    	   if(f) {
    		   while(row1 != row2 + 1) {
    			   System.out.println(m[row1++][col1--] + " ");
    		   }
    	   }else {
    		   while(row2 !=  row1-1) {
    			   System.out.println(m[row2--][col2++] + " ");
    		   }
    	   }
       }
     public static void main(String[] args) {
    	   int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
   		  printMatrixZigZag(matrix);
	}
}
