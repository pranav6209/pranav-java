/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author pranavpatel 
 * 
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 *  polish national flag problem here two colors R and G and pair R and G [R,G,R,G,G,G,R]
 *  
 *  or array with [0,0,1,0,1,1,0,0]
 *  
 *  partition using quick sort 
 *  
 *  1. choose pivot 
 *  2. less than pivot goes on left and 
 *  3. greater than pivot right 
 *  
 *   
 *   Lomuto's both pointer start from left 
 *   Hore's  1st pointer start from left and 2nd start from right 
 * 
 */
public class PP1_Segregate_Even_Odd {

  static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {

    int evenIndex = 0;

    for (int j = 0; j < numbers.size(); j++) {

      if (numbers.get(j) % 2 == 0) {

        Collections.swap(numbers, evenIndex, j);
        evenIndex++;
      }

    }

    return numbers;
  }

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    
    System.out.println(segregate_evens_and_odds(list));
  }

}
