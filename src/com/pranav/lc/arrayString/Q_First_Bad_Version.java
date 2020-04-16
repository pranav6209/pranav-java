/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/first-bad-version/
 * 
 * Explanation 
 * https://leetcode.com/problems/first-bad-version/solution/
 *
 */
public class Q_First_Bad_Version {

  public static boolean isBadVersion(int version) {

    if (version == 4)
      return true;
    else
      return false;

  }

  public static int firstBadVesrions(int n) {

    int l = 0;
    int r = n;
    int mid;
    while (l < r) {

      mid = l + (r - l) / 2;

      if (isBadVersion(mid)) {

        r = mid;
      } else
        l = mid + 1;

    }
    
    // here returning l as we want to return the first bad version and that will be at the beginning 
    // left
    return l;
  }
  
  public static void main(String[] args) {
    System.out.println(firstBadVesrions(5));
  }

}
