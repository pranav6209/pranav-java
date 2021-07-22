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
public class A3_Tringle {

  public static int minimumTotal(List<List<Integer>> triangle) {
    
   List<List<Integer>> res = new ArrayList<>();
    for(int row=0;row<triangle.size();row++) {
      res.add(new ArrayList<>());
      for(int col=0;col<row+1;col++) {
        res.get(row).add(1);
      }
    }
    
    System.out.println(res);
    
    // base case apex
   
    res.get(0).set(0, triangle.get(0).get(0));
    
    System.out.println(res);
    
    // base case left & right col
    
    // row = 1 as apex is already set in row = 0
    for(int row=1;row<res.size();row++) {
      
      // left val
      int leftVal = triangle.get(row).get(0)+res.get(row-1).get(0);
      res.get(row).set(0,leftVal);
      
      int resLastCol = res.get(row-1).size()-1;
      int triangleLastCol = triangle.get(row).size()-1;
      
      int rightVal = triangle.get(row).get(triangleLastCol)+res.get(row-1).get(resLastCol);
      
      // insert into res current row last col
      res.get(row).set(res.get(row).size()-1,rightVal);
      
    }
    
    for(int row =2; row <res.size();row++) {
      // as last col is already set we go one col less
      for(int col=1;col<res.get(row).size()-1;col++) {
        
        int val = triangle.get(row).get(col)+Math.min(res.get(row-1).get(col-1), res.get(row-1).get(col));
        
          res.get(row).set(col, val);
        
      }
      
      
    }
      
    
    System.out.println("res"+res);
    
    //get the last row of res
    
    List<Integer> lastRow = res.get(res.size()-1);
    
    int min = Integer.MAX_VALUE;
    for(int i=0;i<lastRow.size();i++) {
      
      if (lastRow.get(i)<min) {
        min = lastRow.get(i);
      }
     
    }
    
    return min;
  }

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    
    List<Integer> list1 = new ArrayList<>();
    list1.add(2);
    triangle.add(list1);
    
    List<Integer> list2 = new ArrayList<>();
    list2.add(3);
    list2.add(4);
    triangle.add(list2);
    
    List<Integer> list3 = new ArrayList<>();
    list3.add(6);
    list3.add(5);
    list3.add(7);
    triangle.add(list3);
    
    List<Integer> list4 = new ArrayList<>();
    list4.add(4);
    list4.add(1);
    list4.add(8);
    list4.add(3);
    triangle.add(list4);

    System.out.println(triangle);
    System.out.println(minimumTotal(triangle));
  }
}
