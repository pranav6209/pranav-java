/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 *
 */
public class Z1_Jump_Game {
  public static boolean canJump(int[] nums) {

    int lastGoodIndex = nums.length - 1;

    for (int i = nums.length - 1; i >= 0; i--) {

      if (i + nums[i] >= lastGoodIndex) {

        lastGoodIndex = i;

      }

    }
    return lastGoodIndex == 0;
  }

  public static void main(String[] args) {

    int[] nums = { 2, 3, 1, 0, 4 };
    System.out.println(canJump(nums));
  }
}
