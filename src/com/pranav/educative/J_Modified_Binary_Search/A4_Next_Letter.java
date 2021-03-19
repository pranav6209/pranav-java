/**
 * 
 */
package com.pranav.educative.J_Modified_Binary_Search;

/**
 * @author pranavpatel
 * 
 *         Time : O(logN) Space : O(1)
 * 
 *         https://leetcode.com/problems/find-smallest-letter-greater-than-target
 * 
 *
 */
public class A4_Next_Letter {
  public static char searchNextLetter(char[] arr, char target) {

    int start = 0;
    int end = arr.length - 1;
    int n = arr.length;

    if (target > arr[end] || target < arr[start])
      return arr[0];

    while (start <= end) {

      int mid = start + (end - start) / 2;
      System.out.println("mid:-"+mid);
      
      // here, we are not doing that as do not want to return the target but wants to return next element of it
      //if(target == arr[mid]) return arr[mid];

      // if there is a duplicate, we want to go right so, >= 'e','e' case from below
      if (target >= arr[mid])
        start = mid +1;

      else
        end = mid - 1;
    }
    System.out.println(start);
    //('arr = [a', 'c', 'f', 'h'] and target = h), start will be at 4, here there is nothing at index 4 but 
    // we are returning first index , in this case, start will be perfect divisible by n so, it will return 0
    // in other cases there will be a reminder which will be equal to start that we are getting.
    return arr[start % n];
  }

  public static void main(String[] args) {
    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'c', 'f', 'j' }, 'c'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'a', 'z' }, 'y'));
//    System.out.println(A4_Next_Letter.searchNextLetter(new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' }, 'e'));
  }
}
