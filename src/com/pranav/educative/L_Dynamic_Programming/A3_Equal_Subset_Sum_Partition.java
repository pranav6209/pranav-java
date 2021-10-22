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

    boolean[][] dp = new boolean[n + 1][sum + 1];

    // it is always possible to get 0 sum with an empty subset
    // initialize first col with true
    for (int i = 0; i <= n; i++)

      dp[i][0] = true;

    // with empty array we can only achieve sum 0 so keeping j = 0 true which was
    // set in above for loop and then set remaining to false first row false except (0,0)
    for (int j = 1; j <= sum; j++)
      dp[0][j] = false;

    // remaining cells logic
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        // include the current index number and exclude it(choice diagram). In either of
        // the scenarios
        // if we get true, we can form a subset with those numbers.

        // this is similar like 0/1 knapsack where we do Math.max(profit1,profit2)
        // since we are filling matrix here with boolean, we can do or condition
        // means excluding or including number either is true return true. see video.

        // num[i-1] at index 1 we have 0th index value
        if (nums[i-1] <= j) {
          dp[i][j] = dp[i - 1][j - nums[i-1]] || dp[i - 1][j];
        } else {
          // else exclude the no and fill current cell.
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    return dp[n][sum];
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
