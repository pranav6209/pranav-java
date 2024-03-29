/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/target-sum/
 * 
 *         Time and Space complexity of O(N*S)
 * 
 * 
 * 
 *         This is essentially the same problem as count no of subset with given
 *         difference. here we are trying to assign sign but we are if combine
 *         -ve and +ve subsets we are essentially creating two subsets
 * 
 *         and target is difference we want to achieve
 * 
 *         s1 - s2 = target(diff) s1 + s2 = totalSum
 * 
 *         s1 = target + totalSum/2
 * 
 *         now this problem is count no of subset with given sum
 *         
 *         here in this version of leetcode nums[i] is between 0 to 1000 so we have to think abt that scenario. In equal subset nums[i] is 1 to 100 
 * 
 *         https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12&ab_channel=AdityaVerma
 *
 */
public class A7_Target_Sum {

  // this problem is different in leetcode as it has non negative integers(means 0
  // in array) where in educative
  // it says positive non zeros
  public int findTargetSubsets(int[] num, int targetSum) {

    int totalSum = 0;
    for (int i = 0; i < num.length; i++)
      totalSum = totalSum + num[i];

    System.out.println("Total Sum : " + totalSum);

    // subset1 - subset2 = diff ---1 s == diff
    // subset1 + subset2 = totalSum ----2

    // add 1 and 2 to get below
    int sumS1 = (totalSum + targetSum) / 2;

    // if totalSum + s is odd we can not find subset with (s + totalSum) /2

    if ((totalSum + targetSum) % 2 != 0 || totalSum < targetSum)

      return 0;

    return countSubsets(num, sumS1);

  }

  // do not worry abt edge case where one of the element is 0. first just write code ignoring tht
  static int countSubsets(int[] num, int sum) {

    int n = num.length;

    int[][] dp = new int[n+1][sum + 1];

    // https://leetcode.com/problems/target-sum/discuss/295929/Java-2ms-easy-to-understand-dp-solution-with-explanation
    
    
    // To initialize a first column, it is true that it is always possible to get sum 0 with an empty set
    // but we also have to count 0.  
    
    // if nums[0], we have 0, we can get sum 0  with an empty set and with 0 
    // 2 way and if it is not 0 just one way like other problem 
   
    if (num[0] == 0) dp[0][0] = 2; else dp[0][0] = 1; 
    
    // now to initiate first column
    for (int i = 1; i <= n; i++)
     // if at index i we have 0, since we can include and exclude 0 and we have same answer 
      // multiply with 2
      if(num[i]==0) {
        dp[i][0] = 2* dp[i-1][0];
      } else {
        dp[i][0] = dp[i-1][0];
      }

    // with only one number, we can form a subset only when the required sum is
    // equal to its value
    for (int j = 1; j <= sum; j++) {
        dp[0][j]=0;
    }

    // process all subsets for all sums
    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        if (num[i-1] <= s)
          dp[i][s] = dp[i-1][s] + dp[i - 1][s - num[i-1]];
        else 
          dp[i][s] = dp[i-1][s];
      }
    }
    // the bottom-right corner will have our answer.
    return dp[n][sum];

  }

  public static void main(String[] args) {
    A7_Target_Sum ts = new A7_Target_Sum();
    int[] num = { 1, 1, 2, 3 };
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[] { 1, 2, 7, 1 };
    System.out.println(ts.findTargetSubsets(num, 9));
    num = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[] { 1, 0 };
    System.out.println(ts.findTargetSubsets(num, 1));

  }

}
