/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *   https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 *         Time and Space complexity of O(N*S)
 *
 */
public class A5_Minimum_Subset_Sum_Difference {
  public int canPartition(int[] num) {

    int n = num.length;
    if (n == 0)
      return 0;

    int sum = 0, totalSum = 0, sum1 = 0, sum2 = 0;

    for (int i = 0; i < n; i++)
      totalSum += num[i];

    // System.out.println("totalSum:- " + totalSum);

    // sum to create dp array for
    sum = totalSum / 2;

    // System.out.println(sum+"sum");
    
    // This is subset sum code now.

    // array of index and sum
    boolean[][] dp = new boolean[n][sum + 1];

    // populate first column with true
    for (int i = 0; i < n; i++)
      dp[i][0] = true;

    // populate first row
    for (int s = 1; s <= sum; s++) {
      if (num[0] == s)
        dp[0][s] = true;
      else
        dp[0][s] = false;
    }

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        if(num[i]<=s) {
          dp[i][s] = dp[i - 1][s - num[i]] || dp[i - 1][s];
        } else {
          // else exclude the no and fill current cell.
          dp[i][s] = dp[i - 1][s];
        }

      }
    }

    // iterate last row to find true
    for (int s = sum; s >= 0; s--) {

      if (dp[n - 1][s] == true) {

        sum1 = s;

        break;

      }

    }

    // System.out.println("sum1:- "+sum1);

    sum2 = totalSum - sum1;

    return Math.abs(sum1 - sum2);
  }

  public static void main(String[] args) {
    A5_Minimum_Subset_Sum_Difference ps = new A5_Minimum_Subset_Sum_Difference();
    int[] num = { 1, 2, 3, 9 };
    System.out.println(ps.canPartition(num));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ps.canPartition(num));
    num = new int[] { 1, 3, 100, 4 };
    System.out.println(ps.canPartition(num));
  }

}
