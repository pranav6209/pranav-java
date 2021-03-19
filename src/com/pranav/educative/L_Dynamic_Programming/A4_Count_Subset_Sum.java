/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *        https://www.youtube.com/watch?v=MqYLmIzl8sQ&ab_channel=TECHDOSE
 *         Time and Space complexity of O(N*S)
 *         
 *         https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 *
 */
public class A4_Count_Subset_Sum {
  static int countSubsets(int[] num, int sum) {

    int n = num.length;

    int[][] dp = new int[n][sum + 1];

    // populate the sum=0 columns, as we will always have an empty set for zero sum
    for (int i = 0; i < n; i++)
      dp[i][0] = 1;

    // with only one number, we can form a subset only when the required sum is
    // equal to its value
    for (int s = 1; s <= sum; s++) {
      dp[0][s] = (num[0] == s ? 1 : 0);
    }

    // process all subsets for all sums
    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        // include the number, if it does not exceed the sum
        if (num[i] <= s)
          dp[i][s] = dp[i-1][s] + dp[i - 1][s - num[i]];
        else 
          dp[i][s] = dp[i-1][s];
      }
    }
    // the bottom-right corner will have our answer.
    return dp[n - 1][sum];

  }

  public static void main(String[] args) {
    int[] num = { 1, 1, 2, 3 };
    System.out.println(A4_Count_Subset_Sum.countSubsets(num, 4));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(A4_Count_Subset_Sum.countSubsets(num, 9));
    num = new int[] { 1, 2, 3 };
    System.out.println(A4_Count_Subset_Sum.countSubsets(num, 4));
  }

}
