/**
 * 
 */
package com.pranav.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class B_Print_All_Substring {

  static void printAllSubstring(String str) {

    for (int i = 0; i < str.length(); i++) {

      for (int j = i + 1; j <= str.length(); j++) {

        System.out.println(str.substring(i, j));

      }

    }

  }

  public static void main(String[] args) {

    String str = "abcdef";
    printAllSubstring(str);

  }
}
