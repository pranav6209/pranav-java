/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *         https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 *         Time and Space complexity of O(N*S)
 *  
 *        from educative 
 *        
 *        Let’s assume ‘S’ represents the total sum of all the numbers. So what we are trying to achieve in this 
 *        problem is to find a subset whose sum is as close to ‘S/2’ as possible, 
 *        
 *        if we can partition the given set into two subsets of an equal sum, we get the minimum difference i.e. zero. 
 *        
 *        This transforms our problem to Subset Sum, where we try to find a subset whose sum is equal to a given number -- ‘S/2’ in our case. 
 *        
 *        If we can’t find such a subset, then we will take the subset which has the sum closest to ‘S/2’. This is easily 
 *        possible, as we will be calculating all possible sums with every subset.
 *        
 *        
 *        look at the educative matrix and from it 
 *        
 *        The above visualization tells us that it is not possible to find a subset whose sum is equal to ‘7’. 
 *        So what is the closest subset we can find? We can find such a subset if we start moving backward in the last row 
 *        from the bottom right corner to find the first ‘T’. The first “T” in the above diagram is the sum ‘6’,
 *         which means we can find a subset whose sum is equal to ‘6’. This means the other set will have a sum of ‘9’, 
 *         and the minimum difference will be ‘3’.
 * 
 * 
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
    boolean[][] dp = new boolean[n + 1][sum + 1];

    // populate first column with true
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    // populate first row
    for (int j = 1; j <= sum; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (num[i-1] <= j) {
          dp[i][j] = dp[i - 1][j - num[i-1]] || dp[i - 1][j];
        } else {
          // else exclude the no and fill current cell.
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    // iterate last row to find true
    for (int s = sum; s >= 0; s--) {

      if (dp[n][s] == true) {

        sum1 = s;

        break;

      }

    }

    // System.out.println("sum1:- "+sum1);

    sum2 = totalSum - sum1;

    return Math.abs(sum1 - sum2);
  }

  public int canPartitionEducative(int[] num) {

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
        if (num[i] <= s) {
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
