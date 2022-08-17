/**
 * 
 */
package com.pranav.lc.slidingwindow;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 * 
 * 
 *  Time O(N)
 *  Space O(1)
 *
 */
public class A2_Number_of_Substrings_Containing_All_Three_Characters {

  public static int numberOfSubstrings(String s) {
    int count[] = new int[3], res = 0, left = 0, n = s.length();
    for (int right = 0; right < n; right++) {
      System.out.println(s.charAt(right));
      count[s.charAt(right) - 'a']++;

      //increase the left only if we have all 3 chars a,b,c
      while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
        System.out.println(s.charAt(right));
        count[s.charAt(left) - 'a']--; // get the index // remove the count of outgoing element
        left++;
      }
      // debug continue to show process.

      for (int k = 0; k < right; k++) {

        System.out.println("############# l=" + right + " k=" + k + " r=" + left);
        System.out.println(s.substring(k, left + 1));

      }

      res += left;
    }
    return res;
  }

  public static void main(String[] args) {

    System.out.println(numberOfSubstrings("abcabc"));

  }

}
