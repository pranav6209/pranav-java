/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         Time and Space complexity of O(N*S), where ‘N’ represents total
 *         items, and ‘C’ is the maximum capacity
 *         
 *         
 *         https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8&ab_channel=AdityaVerma
 *         
 *         educative for matrix
 *         
 *         if only one array given consider it as a capacity array in previous knapsack problem 
 *         also we are making choice here that we include or exclude element. so it follows knapsack 
 *         approach and we can solve using same approach 
 *
 */
public class A2_Subset_Sum {
  public boolean subSetSum(int[] num, int sum) {

    int n = num.length;

    boolean[][] dp = new boolean[n][sum + 1];

    // it is always possible to get 0 sum with an empty subset(excluding the num at current index). Initialize col-1 with true
    for (int i = 0; i < num.length; i++)
      dp[i][0] = true;
    
    // initialize first row with below conditions. 
    for (int s = 1; s <= sum; s++) {
      if (num[0] == s) {
        dp[0][s] = true;
      } else {
        dp[0][s] = false;
      }
    }

   // remaining cells logic
    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        // include the current index number and exclude it(choice diagram). In either of the scenarios
        // if we get true, we can form a subset with those numbers.
        
        // this is similar like 0/1 knapsack where we do Math.max(profit1,profit2)
        // since we are filling matrix here with boolean, we can do or condition
        // means excluding or including number either is true return true. see video.
        
        if(num[i]<=s) {
          dp[i][s] = dp[i - 1][s - num[i]] || dp[i - 1][s];
        } else {
          // else exclude the no and fill current cell.
          dp[i][s] = dp[i - 1][s];
        }
       
      }
    }

    return dp[n - 1][sum];

  }

  public static void main(String[] args) {
    A2_Subset_Sum ss = new A2_Subset_Sum();
    int[] num = { 1, 2, 3, 7 };
    System.out.println(ss.subSetSum(num, 6));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ss.subSetSum(num, 10));
    num = new int[] { 1, 3, 4, 8 };
    System.out.println(ss.subSetSum(num, 6));
  }

}
