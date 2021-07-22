/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * time complexity O(2^N*N) : 2^N for recursive call and for recursive call checking palindrome which is O(N)
 * space complexity O(N)
 *
 */
public class B2_Palindrome_Partitioning {

  public static List<List<String>> partition(String s) {

    List<List<String>> res = new ArrayList<>();

    if (s == null || s.isEmpty())
      return res;

    dfs(res, new ArrayList<>(), s, 0);

    return res;
  }

  private static void dfs(List<List<String>> res, List<String> slate, String str, int idx) {
    // str.length() not -1, to include last  char of String see recursion tree
    if (idx == str.length()) {
      res.add(new ArrayList<>(slate));
    }

    for (int i = idx; i < str.length(); i++) {

      String tempString = str.substring(idx, i + 1);

      if (isPlalindrome(tempString)) {

        slate.add(tempString);
        dfs(res, slate, str, i + 1);
        slate.remove(slate.size() - 1);
      }

    }

  }

  private static boolean isPlalindrome(String s) {

    int i = 0, j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    List<List<String>> res = partition("aab");

    for (List<String> str : res) {

      System.out.println(str);

    }

  }
}
