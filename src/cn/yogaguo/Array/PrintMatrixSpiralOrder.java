package cn.yogaguo.Array;
/**
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
例如： 1 2 3 4 
  5 6 7 8
  9 10 11 12 
 13 14 15 16
  打印结果为：1，2，3，4，8，12，16，15，14，13，9，
5，6，7，11， 10
【要求】 额外空间复杂度为O(1)
 * @author LENOVO
 *
 */
public class PrintMatrixSpiralOrder {
   public static void spiralOrderPrint(int[][] matrix) {
	   int row1 = 0;
	   int col1 = 0;
	   int row2 = matrix.length - 1;
	   int col2 = matrix[0].length - 1;
	   while(row1 <= row2 && col1 <= col2) {
		   printEdge(matrix,row1++,col1++,row2--,col2--);
	   }
   }

  private static void printEdge(int[][] matrix, int row1, int col1, int row2, int col2) {
	 if(row1 == row2) {
		 for(int i = col1;i <= col2;i++) {
			 System.out.println(matrix[row1][i]+" ");
		 } 
	 }else if(col1 == col2) {
		for(int i = row1;i <= row2;i++) {
				System.out.println(matrix[i][col1]+" ");	 
		 }
	 }else {
		 int curR = row1;
		 int curC = col1;
		 while(curC != col2) {
			 System.out.println(matrix[row1][curC] + " ");
			 curC++;
		 }
		 while(curR != row2) {
			 System.out.println(matrix[curR][row2] + "");
			 curR++;
		 }
		 while(curC != col1) {
			 System.out.println(matrix[row2][curC] + " ");
			 curC--;
		 }
		 while(curR != row1) {
			 System.out.println(matrix[curR][row1]+ " ");
			 curR--;
		 }
	 }
}
  public static void main(String[] args) {
	  int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

}
}
