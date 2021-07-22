/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/pascals-triangle/
 *
 */
public class A2_Pascal_Tringle {

  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> triangle = new ArrayList<>();

    /*
     * triangle is initialized with 1 so no need to do base case of storing apex and
     * left and right side with 1
     */
    
    for (int row = 0; row < numRows; row++) {
      triangle.add(new ArrayList<>());
      // in a particular row,col is always 1 more than row 
      // row 0 - 1 col
      // row 1 - 2 col
      for (int col = 0; col < row + 1; col++) {
        triangle.get(row).add(1);
      }
    }
    
    //System.out.println(triangle);
    

    // start with row 2. first 2 row only have one and those are initialized above
    for(int row =2 ;row < numRows;row++) {
      // col start from 1 and goes till current row size -1 as last element is initialized
      // as 1 above
      for(int col =1 ;col< triangle.get(row).size()-1;col++) {
        
        // val at this point in triangle is addition of top left(row-1)(col-1)
        // and top right (row)(col)
        int val = triangle.get(row-1).get(col-1) +triangle.get(row-1).get(col); 
        triangle.get(row).set(col,val);
        
      }
    }
    
    
    return triangle;
    
    
  }

  public static void main(String[] args) {
    System.out.println(generate(5));
  }
}
