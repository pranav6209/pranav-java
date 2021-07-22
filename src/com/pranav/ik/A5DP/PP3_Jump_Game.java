/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * from the solution of 
 * 
 * https://uplevel.interviewkickstart.com/resource/editorial/rc-codingproblem-23489-226073-57-1601
 * 
 * dp solution 
 *
 */
public class PP3_Jump_Game {

  static Boolean can_reach_last_house(ArrayList<Integer> maximum_jump_lengths) {

    int len = maximum_jump_lengths.size();

    int[] dp = new int[maximum_jump_lengths.size()];

    dp[len - 1] = 1;

    for (int i = len - 2; i >= 0; i--) {
      
      // get the no of jump at this current index and iterate through if we can reach to 1.
      // if we can reach 1, it is a good index(1) else bad index 
      int val = maximum_jump_lengths.get(i);
      for (int j = 0; j < val; j++) {
        if (dp[i + j + 1] == 1) {
          dp[i] = 1;
          break;
        }
      }
    }

    return dp[0] == 1;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(2);
    list.add(3);
    list.add(1);
    list.add(0);
    list.add(4);
    list.add(7);

    System.out.println(can_reach_last_house(list));
  }

}
