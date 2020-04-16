/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * https://www.youtube.com/watch?v=gREVHiZjXeQ
 *
 *
 *time complexity O(n)
 *space complexity O(n), if we do not count o/p array O(1)
 */
public class W_Product_of_Array_Except_Self {

  public static int[] productExceptSelf(int[] nums) {

    int arrayLength = nums.length;

    // output array
    int[] opArray = new int[arrayLength];

    // initially making an o/p array with cumulative multiplication. so [1,2,3,4] becomes [1,2,6,24]
    opArray[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {

      opArray[i] = opArray[i - 1] * nums[i];

    }

    System.out.println("Oputput Array-1");
    System.out.println(Arrays.toString(opArray));

    // update o/p array in reverse order
    
    // two boundary conditions 
    //  first opArray[arrayLength - 1] which will be opArray[arrayLength - 2]
    opArray[arrayLength - 1] = opArray[arrayLength - 2];
    int product = nums[arrayLength - 1];

    // for rest of the elements value to the left * product is new value
    // keep updating product value
    for (int i = arrayLength - 2; i > 0; i--) {

 
      opArray[i] = opArray[i - 1] * product;
      product = product * nums[i];

    }

    // second opArray[0]= product
    opArray[0] = product;
    return opArray;
  }

  public static void main(String[] args) {

    int[] nums = { 1, 2, 3, 4 };
    // int[] nums = { 1, 2, 3, 0 };

    System.out.println(Arrays.toString(productExceptSelf(nums)));
  }

}
