/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/n-queens/
 * 
 * https://www.youtube.com/watch?v=xouin83ebxE
 * 
 * video no 63
 * https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O
 * 
 * 
 * @author pranavpatel
 *
 */
public class A1_N_Queens {
  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new LinkedList<>();
    if (n <= 0) {
      return res;
    }
    // build chessboard @mat(=matrix)
    char[][] mat = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = '.';
      }
    }
    helper(mat, 0, res);
    return res;
  }

  private static void helper(char[][] mat, int row, List<List<String>> res) {
    // reach solution
    if (row == mat.length) {
      res.add(builder(mat));
      return;
    }
    for (int i = 0; i < mat.length; i++) {
      // try
      mat[row][i] = 'Q';
      // if possible
      if (isValid(mat, row, i)) {
        helper(mat, row + 1, res);
      }
      // un-try
      mat[row][i] = '.';
    }
    return;
  }

  private static boolean isValid(char[][] mat, int x, int y) {
    // only check rows above current one
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < mat.length; j++) {
        // not need to check current position
        if (i == x && j == y) {
          continue;
        }
        // if 'Q' in the same col or the diagonal line, return false
        if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && mat[i][j] == 'Q') {
          return false;
        }
      }
    }
    return true;
  }

  // build solution from temporary chessboard
  private static List<String> builder(char[][] mat) {
    List<String> tmp = new LinkedList<>();
    for (int i = 0; i < mat.length; i++) {
      String t = new String(mat[i]);
      tmp.add(t);
    }
    return tmp;
  }

  public static void main(String[] args) {

    List<List<String>> res = solveNQueens(4);

    for (List<String> str : res) {

      // for (String str1 : str) {

      System.out.println(str);
      // }

    }

  }

}
