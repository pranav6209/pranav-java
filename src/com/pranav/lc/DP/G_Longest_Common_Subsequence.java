/**
 * 
 */
package com.pranav.lc.DP;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * https://www.youtube.com/watch?v=NnD96abizww
 * 
 * https://leetcode.com/problems/longest-common-subsequence/discuss/398711/ALL-4-ways-Recursion-greater-Top-down-greaterBottom-Up-greater-Efficient-Solution-O(N)-including-VIDEO-TUTORIAL
 *
 */

// not contiguous subsequence here 


// time complexity - O(m*n)
// space complexity - O(m*n)
public class G_Longest_Common_Subsequence {

  public static int lcs(String String1, String String2) {

    // on the 0th index, storing 0s for row and columns so length+1

    int[][] grid = new int[String1.length() + 1][String2.length() + 1];

    for (int row = 1; row < grid.length; row++) {
      for (int col = 1; col < grid[0].length; col++) {

        // no need to do this as when created grid initiate with all zero
        // if (row == 0 || col == 0)
        // grid[row][col] = 0;

        if (String1.charAt(row - 1) == String2.charAt(col - 1))
          // +1 bse we have one matching char + match from before
          grid[row][col] = grid[row - 1][col - 1] + 1;
        else
          grid[row][col] = Math.max(grid[row - 1][col], grid[row][col-1]);
      }

    }

    return grid[String1.length()][String2.length()];

  }

  public static void main(String[] args) {

    String String1 = "bl";
    String String2 = "yby";

    System.out.println(lcs(String1, String2));

  }

}
