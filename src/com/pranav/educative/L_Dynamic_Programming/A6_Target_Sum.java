/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         Time and Space complexity of O(N*S)
 *         
 *         looks for playlist under descriptions 
 *         
 *         https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12&ab_channel=AdityaVerma
 *
 */
public class A6_Target_Sum {
  
  
  // this problem is different in leetcode as it has non negative integers where in educative, 
  // it says positive non zeros 
  public int findTargetSubsets(int[] num, int s) {

    int totalSum = 0;
    for (int i = 0; i < num.length; i++)
      totalSum = totalSum + num[i];

    System.out.println("Total Sum : " + totalSum);
    
    
   // subset1 - subset2 = diff ---1 s == diff
   // subset1 + subset2 = totalSum ----2

   //add 1 and 2 to get  below 
    int sumS1 = (totalSum + s) / 2;

    // if totalSum + s is odd we can not find subset with (s + totalSum) /2
    
   if ((totalSum + s) % 2 != 0 || totalSum < s)
      
     return 0;
   
    return countSubsets(num, sumS1);

  }

  static int countSubsets(int[] num, int sum) {

    int n = num.length;

    int[][] dp = new int[n][sum + 1];

    // https://leetcode.com/problems/target-sum/discuss/295929/Java-2ms-easy-to-understand-dp-solution-with-explanation
    
    
    // To initialize a first column, it is true that it is always possible to get sum 0 with an empty set
    // but we also have to count 0.  
    
    // now if at the oth index of nums[], if it is 0, we can get sum 0  with an empty set and with 0 
    // 2 way and if it is not 0 just one way like other problem 
   
    if (num[0] == 0) dp[0][0] = 2; else dp[0][0] = 1; 
    
    // now to initiate first column
    for (int i = 1; i < n; i++)
     // if at current index we have 0, since we can include and exclude 0 and we have same answer 
      // multiply with 2
      if(num[i]==0) {
        dp[i][0] = 2* dp[i-1][0];
      } else {
        dp[i][0] = dp[i-1][0];
      }

    // with only one number, we can form a subset only when the required sum is
    // equal to its value
    for (int s = 1; s <= sum; s++) {
      if (num[0] == s)
        dp[0][s] = 1;
      else
        dp[0][s] = 0;

      // dp[0][s] = (num[0] == s ? 1 : 0);
    }

    // process all subsets for all sums
    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
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
    A6_Target_Sum ts = new A6_Target_Sum();
    int[] num = { 1, 1, 2, 3 };
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[] { 1, 2, 7, 1 };
    System.out.println(ts.findTargetSubsets(num, 9));
    num = new int[] { 0,0,0,0,0,0,0,0,1};
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[] { 1,0};
    System.out.println(ts.findTargetSubsets(num, 1));

  }

}
