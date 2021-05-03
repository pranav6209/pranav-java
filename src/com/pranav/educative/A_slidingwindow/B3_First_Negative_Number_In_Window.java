
/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 * https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4&ab_channel=AdityaVerma
 *
 */
public class B3_First_Negative_Number_In_Window {

  public static int[] firstNegativeNumber(int[] array, int k) {

    int[] res = new int[array.length - k + 1];
    int window_start = 0;
    Queue<Integer> queue = new LinkedList<Integer>();

    for (int window_end = 0; window_end < array.length; window_end++) {

      if (array[window_end] < 0)
        queue.add(array[window_end]);

      if (window_end - window_start + 1 == k) {

        if (queue.isEmpty()) {
          res[window_start] = 0;
        } else {
          res[window_start] = queue.peek();
        }

        if (!queue.isEmpty()) {
          if (array[window_start] == queue.peek()) {
            queue.remove();
          }
        }

        window_start++;

      }

    }

    return res;
  }

  public static void main(String[] args) {

    int[] A = { -8, 2, 3, -6, 10 };
    int[] B = { 12, -1, -7, 8, -15, 30, 16, 28 };
    System.out.println(Arrays.toString(firstNegativeNumber(A, 2)));
    System.out.println(Arrays.toString(firstNegativeNumber(B, 3)));
  }
}
