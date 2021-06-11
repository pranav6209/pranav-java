/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/sort-colors/
 *         https://www.educative.io/courses/grokking-the-coding-interview/RMBxV6jz6Q0
 *         
 *         same problem like Segregate even and odd
 *         
 *         Quick sort algorithm Hoare's partitioning. try to this problem using 
 *         Lamuto's partitioning explained in class.Using Lamuto's we can extend this 
 *         for more partition.
 *
 */
public class PP3_Dutch_National_Flag {

  static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
    // Write your code here.

    int low = 0;
    int high = balls.size() - 1;

    // i <= high as after high all the elements are already swapped and those are 'B'
    for (int i = 0; i <= high;) {

      // System.out.println("balls.get(i)"+balls.get(i));

      if (balls.get(i) == 'R') {

        Collections.swap(balls, i, low);
        /*
         here we have already process previous element so we are sure that after swap
         the element coming is 'G' only so we can increment i
         */
        i++;
        low++;

      } else if (balls.get(i) == 'G') {
        i++;
      } else {
        // for char B
        Collections.swap(balls, i, high);
        // only decrement high as after swap the number here may be R B or G
        high--;

      }
      // System.out.println("balls"+balls);
    }

    return balls;
  }

  public static void main(String[] args) {

    ArrayList<Character> list = new ArrayList<>();

    list.add('G');
    list.add('B');
    list.add('G');
    list.add('G');
    list.add('R');
    list.add('B');
    list.add('R');
    list.add('G');

    System.out.println(dutch_flag_sort(list));
  }

}
