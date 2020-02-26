/**
 * 
 */
package com.pranav.ctci.arrayString;

import java.util.Arrays;

/**
 * @author pranavpatel
 * two scan approach. 
 * 1. first scan get the no of space/s.Based on no of spaces, count newLength. 
 * 2. second scan is in reverse order. Edit the String. Whenever there is a 
 *    space in original string, replace it with %20.
 *
 */
public class C_Urlify {

  public static String urilify(String str, int truelength) {

    char[] charArray = str.toCharArray();

    int spaceCount = 0;
    
    for (char ch : charArray) {

      if (ch == ' ')
        spaceCount++;
    }

    int newLength = truelength + spaceCount * 2;

    System.out.println(newLength);

    char[] newStringArray = new char[newLength];

    for (int i = truelength - 1; i >= 0; i--) {

      if (charArray[i] != ' ') {

        newStringArray[newLength - 1] = charArray[i];
        newLength--;
        //System.out.println("1"+Arrays.toString(newStringArray));
      } else {

        newStringArray[newLength - 1] = '0';
        newStringArray[newLength - 2] = '2';
        newStringArray[newLength - 3] = '%';
        newLength = newLength - 3;
        
      }
    }
    
    return Arrays.toString(newStringArray);
  }

  public static void main(String[] args) {

    System.out.println(urilify("Mr John Smith", 13));

  }

}
