/**
 * 
 */
package com.pranav.lc;

import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/move-zeroes/
 *
 */
public class G_move_zeroes {
  public static void moveZeroes(int[] nums) {

    int i = 0;

    for (int j = 0; j < nums.length; j++) {

      // put all the non zero number at the front of array, using slow index(i)
      if (nums[j]!= 0) {
        
        // swap the number using temp variables and put them at fast index(j)
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
        i++;
      }

    }
    System.out.println(Arrays.toString(nums));
  }

  public static void main(String[] args) {

    int[] nums = { 0, 1, 0, 3, 12 };

    moveZeroes(nums);
  }

}
