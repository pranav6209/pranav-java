/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/submissions/
 * 
 * this is the leetcode version of the problem
 */

public class B4_P5_N_Queens {

  static List<List<String>> find_all_arrangements(int n) {
    List<List<String>> finalRes = new ArrayList<>();
    helper(0, n, new ArrayList<>(), finalRes);
    return finalRes;
  }

  private static void formatResponse(List<Integer> currentRes, int n, List<List<String>> finalRes) {

    char[][] resArray = new char[n][n];
    // this will hold all the Strings for current res
    List<String> temp = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        resArray[i][j] = '.';
      }
    }

    // from current Res get the value of queen from each row and add it to a
    // specific col and row
    for (int j = 0; j < currentRes.size(); j++) {
      resArray[j][currentRes.get(j)] = 'Q';
    }

    // from the res array creates list of string iterating over each row
    for (char[] row : resArray) {

      temp.add(new String(row));

    }

    finalRes.add(temp);

  }

  // index and n are subproblem definition
  // we are giving a subordinate from which queen they are working on
  // also if let's say if we say subordinate is working on index 2,he/she also
  // working on 2nd row as we each row will have one queen.
  private static void helper(int index, int n, List<Integer> slate, List<List<String>> finalRes) {

    // backtracking case

    // checking for col conflicts, rows are already different so no need to check
    // that

    // last q position that we have just appended to slate

    int lastQ = slate.size() - 1;

    // get col for all the ealier q and check if is not the same with lastQ
    for (int earlierQ = 0; earlierQ < lastQ; earlierQ++) {
      if (slate.get(earlierQ) == slate.get(lastQ))
        return;

      // check for diagonal conflicts

      int rowDiff = Math.abs(lastQ - earlierQ);
      int colDiff = Math.abs(slate.get(lastQ) - slate.get(earlierQ));

      if (rowDiff == colDiff)
        return;

    }

    // base case
    if (n == index) {
      // res.add(new ArrayList<>(slate));
      // System.out.println(slate);
      // format the response of a current slate and add it to res
      formatResponse(new ArrayList<>(slate), n, finalRes);
      return;
    }

    // we are checking all the possible col and not ignoring the col that are
    // previously used
    // optimize it later
    for (int col = 0; col < n; col++) {
      slate.add(col);
      helper(index + 1, n, slate, finalRes);
      slate.remove(slate.size() - 1);
    }

  }

  public static void main(String[] args) {
    System.out.println(find_all_arrangements(4));
  }

}