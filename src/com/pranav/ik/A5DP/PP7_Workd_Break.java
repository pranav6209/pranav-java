/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         leet code problem is just true false
 *         https://leetcode.com/problems/word-break/
 *
 */
public class PP7_Workd_Break {
  public static boolean wordBreakCount(List<String> dictionary, String txt) {
    System.out.println(txt.length());
    HashSet<String> dict = new HashSet<>();

    for (String word : dictionary) {
      dict.add(word);
    }

    int[] dp = new int[txt.length() + 1];
    dp[txt.length()] = 1;

    for (int i = txt.length() - 1; i >= 0; i--) {
      int count = 0;
      for (int j = i + 1; j <= txt.length(); j++) {
        System.out.println(txt.substring(i, j));
        if (dict.contains(txt.substring(i, j))) {
          count += dp[j];
          count %= 1000000007;
        }
      }

      dp[i] = count;
    }
    return dp[0] > 0;
  }

  public static int wordBreakCount1(List<String> dictionary, String txt) {
    // Write your code here
    
    HashSet<String> dict = new HashSet<String>();
    int ml = 0;
    
   for(String s :dictionary)
   {
       dict.add(s);
       ml=Math.max(ml, s.length());
   }
    
    int[] dp = new int[txt.length()+1];
    dp[0] = 1;
    
    for(int i=1;i<txt.length();i++)
    {
        for(int j = i+1;j<=txt.length();j++)
        {   
          System.out.println(txt.substring(i,j));
            if(dict.contains(txt.substring(i,j)))
            {
                dp[j] = dp[j]+dp[i];
                dp[j] %= 1000000007;
            }
        }
    }
    return dp[txt.length()];
}

  public static void main(String[] args) {
    // “kick", "start", "kickstart", "is", "awe", "some", "awesome
    List<String> list = new ArrayList<>();
    list.add("kick");
    list.add("start");
    list.add("kickstart");
    list.add("is");
    list.add("awe");
    list.add("some");
    list.add("awesome");

    // wordBreakCount(list, "kickstartisawesome");
    System.out.println(wordBreakCount1(list, "kickstartisawesome"));

  }
}
