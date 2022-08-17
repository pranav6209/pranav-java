/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         brute force if we do 2 pointer Time : O(N2^)
 * 
 *         recursion.
 * 
 *         get all the subsets and see if any of the subset equals to sum
 *         return true (similar problem in recursion)
 * 
 *         Time and Space complexity of O(N*S), where ‘N’ represents total
 *         items, and ‘C’ is the maximum capacity
 * 
 * 
 *         https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8&ab_channel=AdityaVerma
 * 
 *         educative for matrix
 *         
 *         
 *         
 *         num/sum 0  1  2  3  4  5   6   
 *    {}    0      T  F  F  F  F  F   F    
 *    {1}   1      T  T  F  F  F  F   F   -- i = 1 and j 1 -> 6 here considering array of {1} which is at index 0 so going n-1 
 *  {1,2}   2      T  T  T  T  F  F   F
 * {1,2,3}  3      T  T  T  T  T  T   T  
 * {1,2,3,7}4      T  T  T  T  T  T   T 
 * 
 * 
 *         if only one array given consider it as a capacity array in previous
 *         knapsack problem also we are making choice here that we include or
 *         exclude element. so it follows knapsack approach and we can solve
 *         using same approach
 *
 */
public class A2_Subset_Sum {

  // dp array [n+1][sum+1] - leetcode and Aditya approach
  // dp array [n][sum+1] below commented code -- educative approach 
  public boolean subSetSum(int[] num, int sum) {

    int n = num.length;

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
        if (num[i-1] <= j) {
          dp[i][j] = dp[i - 1][j - num[i-1]] || dp[i - 1][j];
        } else {
          // else exclude the no and fill current cell.
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    return dp[n][sum];

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
