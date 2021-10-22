/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *         https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11&ab_channel=AdityaVerma
 * 
 * 
 *         int [] arr = {1,1,2,3}
 * 
 *         count no of subset whose difference between to subset should be 1
 * 
 *         [1,3] [1,2] we have two 1s 
 *         [1,3] [1,2] choosing other 1s 
 *         [1,1,2] [3]
 * 
 *         answer is 3
 * 
 *         sum(s1) - sum(s2) = diff 
 *         
 *         sum(s1) + sum(s2) = totalSum(sum of array)
 * 
 *         2Sum(s1) = diff + totalSum
 * 
 *         Sum(s1) = diff + totalSum/2
 * 
 *         then this follow count subset sum
 */
public class A6_Count_No_Of_Subset_with_given_difference {

}
