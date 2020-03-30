/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 *
 */
public class R_Guess_Number_Higer_Lower {

  public static int guess(int num) {

    int myNumber =6;
    if (num == myNumber)
      return 0;
    else if(myNumber<num)
      return -1;
    else return 1;
  }

  public static int guessNumber(int n) {

    int l = 0;
    // don't do n-1, as we are dealing with no and not index
    int r = n;

    while (l <= r) {

      int mid = l + (r - l) / 2;

      int val = guess(mid);

      if (val == 0)
        return mid;

      if (val == 1)
        l = mid + 1;

      else
        r = mid - 1;

    }

    return -1;
  }

  public static void main(String[] args) {

    System.out.println(guessNumber(10));
  }

}
