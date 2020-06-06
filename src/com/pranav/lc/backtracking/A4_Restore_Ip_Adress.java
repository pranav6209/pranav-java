/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/restore-ip-addresses/
 * 
 * 
 *         https://www.youtube.com/watch?v=KU7Ae2513h0
 * 
 *         https://leetcode.com/problems/restore-ip-addresses/discuss/31113/Java-recursive-backtracking-easy-to-read.
 *    
 *         time complexity O(N) but video says 0(1) space complexity O(1)( we cant 
 *
 */
public class A4_Restore_Ip_Adress {
  public static List<String> restoreIpAddresses(String s) {
    List<String> ret = new ArrayList<>();
    int[] path = new int[4];
    System.out.println(s);
    helper(ret, s, 0, path, 0);
    return ret;
  }

  static void helper(List<String> acc, String s, int idx, int[] path, int segment) {
    
    
    
    // from video our Goal // base case
    if (segment == 4 && idx == s.length()) {
      acc.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
      return;
    } else if (segment == 4 || idx == s.length()) {
      System.out.println("possible segments");
      System.out.println(path[0]+","+path[1]+","+path[2]+","+path[3]);
      return;
    }

    
    // idx tell as where we are in the string and from there we are making string of len 1to3
   
    for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
      int val = Integer.parseInt(s.substring(idx, idx + len));
      
      
      // 2. our goal
      // range check, leading zeros in the IPv4 is invalid. For example, the address
      // 172.16.254.01 is invalid.
      if (val > 255 || (len >= 2 && s.charAt(idx) == '0'))
        break;

      // 3. our choice
      path[segment] = val;
      // new index is index + len as we start taking snapshot of new segments from there
      helper(acc, s, idx + len, path, segment + 1);
      // path[segment] = -1; // for debug.
    }

  }

  public static void main(String[] args) {

    List<String> ips = restoreIpAddresses("25525511135");

    for (String str : ips) {
      System.out.println(str);
    }

  }
}
