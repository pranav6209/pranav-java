/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
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
    int r = n - 1;
    int mid;
    while (l <= r) {

      mid = l + (r - l) / 2;

      if (isBadVersion(mid)) {

        r = mid - 1;
      } else
        l = mid + 1;

    }
    return l;
  }
  
  public static void main(String[] args) {
    System.out.println(firstBadVesrions(5));
  }

}
