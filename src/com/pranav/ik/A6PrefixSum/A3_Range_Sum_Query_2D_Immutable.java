/**
 * 
 */
package com.pranav.ik.A6PrefixSum;

/**
 * @author pranavpatel
 *
 */
public class A3_Range_Sum_Query_2D_Immutable {

  /*
   * 
   * here it is not possible use same array as we have to get values from original
   * matrix
   * 
   * time to build prefixSum array
   * 
   * 
   * time : O(m * n) space : O(m * n)
   * 
   * time query O(1)
   * 
   * look at the notes from slides. prefix sum floater
   * 
   */
  int[][] prefixSum;

  public A3_Range_Sum_Query_2D_Immutable(int[][] matrix) {
      
      
      int m = matrix.length;
      int n = matrix[0].length;
      
      if(m == 0 || n == 0) return; 
      

  
      prefixSum = new int[m][n];    
  
       
      prefixSum[0][0] = matrix[0][0];
      
      // populate first col
      for(int row = 1 ; row < m ;row++){
          
          prefixSum[row][0] = prefixSum[row-1][0] + matrix[row][0];
      }
      
      // populate first row
      for(int col = 1 ; col < n ;col++){
          
          prefixSum[0][col] = prefixSum[0][col-1] + matrix[0][col];
      }
      
      for(int row =1 ; row < m ; row++){
          
          for(int col = 1; col < n ;col++){
              
              prefixSum[row][col] = prefixSum [row-1][col] + prefixSum [row][col-1] - prefixSum [row-1][col-1] +  matrix[row][col] ;   
          }   
      }  
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {

    int m = prefixSum.length;
    int n = prefixSum[0].length;

    // for(int row =0 ; row < m ; row++){

    // for(int col = 0; col < n ;col++){

    // System.out.print(prefixSum[row][col]);
    // System.out.print(",");
    // }
    // System.out.println();
    // }

    // empty matrix
    if (m == 0 || n == 0)
      return 0;

    if (row1 == 0 && col1 == 0)
      return prefixSum[row2][col2];

    else if (row1 == 0) {

      return prefixSum[row2][col2] - prefixSum[row2][col1 - 1];

    } else if (col1 == 0) {

      return prefixSum[row2][col2] - prefixSum[row1 - 1][col2];
    }

    else {
      return prefixSum[row2][col2] - prefixSum[row2][col1 - 1] - prefixSum[row1 - 1][col2]
      + prefixSum[row1 - 1][col1 - 1];
    }

  }
}
