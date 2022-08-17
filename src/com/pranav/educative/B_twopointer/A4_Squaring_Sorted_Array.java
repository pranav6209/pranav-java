/**
 * 
 */
package com.pranav.educative.B_twopointer;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
 * 
 * also have different solution in leetcode
 * 
 * time : O(N)
 * space : O(n) considering o/p array
 * do it from IK
 */
public class A4_Squaring_Sorted_Array {

  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n];
    int highestSquareIdx = n - 1;
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];
      if (leftSquare > rightSquare) {
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }
    return squares;
  }

  public static void main(String[] args) {

    int[] result = A4_Squaring_Sorted_Array.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = A4_Squaring_Sorted_Array.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

  }
}
