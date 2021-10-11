/**
 * 
 */
package com.pranav.company;

import java.util.ArrayList;
import java.util.List;

/*

Customer is sending us a text file which has numbers embedded inside strings. For e.g. "

Write a function to return the first integer you find in such a string. In the example above, the first integer is 1230.
Try not to use inbuilt functions like Integer.parseInt(). Try to assemble the return value as you process the string. 


asdfasfd1230sadfsafd430asdfsaf
^.          

int d = c - '0';
 
 */
public class Bill {

  private static int PaeseString(String str) {

    int res = 0;
    boolean flag = false;
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {

      char ch = str.charAt(i);
      int num = ch - '0';

      if (num >= 0 && num <= 9) {
        res = res * 10 + num;
        flag = true;
      }
      if (flag && (num > 9)) {
       
        list.add((res));
        res =0;
        flag = false;
      }

    }
    System.out.println(list);
    return -1;// if we do not have num in files
  }

  public static void main(String[] args) {
    System.out.println(PaeseString("asdfasfd1230sadfsafd430asdfsaf"));
  }
}
