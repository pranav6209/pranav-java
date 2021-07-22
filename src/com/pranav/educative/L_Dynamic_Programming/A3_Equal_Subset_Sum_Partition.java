/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/partition-equal-subset-sum/
 *         https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8&ab_channel=AdityaVerma
 *         Time and Space complexity of O(N*S), where ‘N’ represents total
 *         items, and ‘C’ is the maximum capacity
 *
 */

// please look at A3_Subset_sum first, it has detailed explanations

public class A3_Equal_Subset_Sum_Partition {

  private boolean canPartition(int[] nums) {

    int n = nums.length;
    int sum = 0;

    /*
     * Assume that S represents the total sum of all the given numbers. Then the two
     * equal subsets must have a sum equal to S/2. This essentially transforms our
     * problem to: “Find a subset of the given numbers that has a total sum of S/2”.
     */

    // if array is empty return true ?
    if (n == 0)
      return true;

    // find the total sum
    for (int i = 0; i < n; i++)
      sum += nums[i];

    // if 'sum' is a an odd number, we can't have two subsets with same total
    if (sum % 2 != 0)
      return false;

    sum /= 2;

    return subSetSum(nums, sum);
  }

  public boolean subSetSum(int[] nums, int sum) {

    int n = nums.length;

    boolean[][] dp = new boolean[n][sum + 1];

    // it is always possible to get 0 sum with an empty set. Initialize col-1 with
    // true
    for (int i = 0; i < nums.length; i++)
      dp[i][0] = true;

    // initialize first row with below conditions.
    for (int s = 1; s <= sum; s++) {
      dp[0][s] = nums[0] == s ? true : false;
    }

    // remaining cells logic
    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        // if nums[i] is smaller, we have an option to include or exclude
        // and either of is true we want to fill true.
        if (nums[i] <= s) {
          dp[i][s] = dp[i - 1][s - nums[i]] || dp[i - 1][s];
        } else {
          // else exclude the no and fill current cell.
          dp[i][s] = dp[i - 1][s];
        }

      }
    }
    
   // System.out.println(dp);
    return dp[n - 1][sum];
  }

  public static void main(String[] args) {
    A3_Equal_Subset_Sum_Partition ps = new A3_Equal_Subset_Sum_Partition();
    int[] num = { 1, 2, 3, 4 };
    System.out.println(ps.canPartition(num));
    
   /* num = new int[] { 1, 1, 3, 4, 7 };
    System.out.println(ps.canPartition(num));
    num = new int[] { 2, 3, 4, 6 };
    System.out.println(ps.canPartition(num));
    num = new int[] { 1, 5, 3 };
    System.out.println(ps.canPartition(num));
    */
  }
}
