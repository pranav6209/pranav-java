/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;
import java.util.List;

import com.pranav.company.A_Veeva;

/**
 * @author pranavpatel
 *
 */
public class U_Count_Elements {

  public static int countElements(int[] arr) {

    int res = 0;
    int i = 0;
    int j = 1;
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    
    while (i < arr.length && j < arr.length) {
      while (j < arr.length) {
        if (arr[j] == 1 + arr[i]) {

          res = res + j - i;
          i = j;
        }
        
        if(arr[j] > 1 + arr[i]) {
          i=j;
        }
          
        j++;
      }

    }
    return res;
  }

  public static void main(String[] args) {
    
    int[] arr = { 1, 2, 3 };
    int[] arr1 = { 1, 1, 3, 3, 5, 5, 7, 7 };
    int[] arr2 = { 1, 3, 2, 3, 5, 0 };
    int[] arr3 = { 1, 1, 2 };
    int[] arr4 = {2,9,0,7,6,2,7,7,0};

    System.out.println(countElements(arr4));

  }

}
