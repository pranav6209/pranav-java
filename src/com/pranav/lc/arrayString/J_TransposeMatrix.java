/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/transpose-matrix/
 *
 */
public class J_TransposeMatrix {

  public static void transposeMatrix(int[][] A) {

    int row = A.length;
    int col = A[0].length;
    int traMatrix[][] = new int[col][row];
    System.out.println("Transpose Matrix");

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {

        traMatrix[j][i] = A[i][j];

      }

    }

    printMultiArray(traMatrix);
  }

  public static void printMultiArray(int[][] Array) {
    // row
    for (int i = 0; i < Array.length; i++) {

      // col
      for (int j = 0; j < Array[0].length; j++) {
        System.out.print(Array[i][j]);
        System.out.print(" ");

      }

      System.out.println();
    }

  }

  public static void main(String[] args) {

    // int [][] A = new int [3][4];
    //int[][] A = { { 1, 2,3 }, { 4, 5,6}, { 7, 8,9} };
    int[][] A = { { 1, 2,3 }, { 4, 5,6} };

    // A[0][0] = 1;
    // A[0][1] = 2;
    // A[0][2] = 3;
    // A[1][0] = 4;
    // A[1][1] = 5;
    // A[1][2] = 6;
    // A[2][0] = 7;
    // A[2][1] = 8;
    // A[2][2] = 9;

    printMultiArray(A);

    transposeMatrix(A);

  }

}
