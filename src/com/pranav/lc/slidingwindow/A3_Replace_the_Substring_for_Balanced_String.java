/**
 * 
 */
package com.pranav.lc.slidingwindow;

/**
 * @author pranavpatel
 *
 *
 *https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class A3_Replace_the_Substring_for_Balanced_String {

  public static int balancedString(String s) {
    int[] count = new int[128];
    char[] arr = s.toCharArray();

    // 1) count number of QWER chars
    for (char c : arr) {
      count[c]++;
    }

    int need = arr.length / 4;

    // Sliding window
    int left = 0;
    int right = 0;
    int min = arr.length; // min substring length
    while (right <= arr.length) {
      // Move right while any of char count in string more than 'need'
      if (count['Q'] > need || count['W'] > need || count['E'] > need || count['R'] > need) {
        if (right >= arr.length)
          break;
        char rightCh = arr[right];
        count[rightCh]--;
        right++;
        continue;
      }
      min = Math.min(min, right - left);
      if (min == 0)
        break;
      char leftCh = arr[left];
      count[leftCh]++;
      left++;
    }
    return min;
  }
  
  public static void main(String[] args) {
    
    System.out.println(balancedString("QQQQ"));
    
  }

}
