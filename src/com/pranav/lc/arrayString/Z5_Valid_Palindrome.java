/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/valid-palindrome/
 *
 */
public class Z5_Valid_Palindrome {

  // if spaces and case sensitivity is not in the input string (aba)
  public boolean isPalindrome1(String s) {
    int i = 0, j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

  
  // https://leetcode.com/problems/valid-palindrome/
  // to validate String with space and ignoring special chars 
  public boolean isPalindrome2(String s) {

    if (s != null && s.isEmpty())
      return true;

    StringBuffer s1 = new StringBuffer();
    StringBuffer s2 = new StringBuffer();

    for (int i = s.length() - 1; i >= 0; i--) {
      Character ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        s1.append(ch);

      }

    }

    for (int i = 0; i < s.length(); i++) {

      Character ch = s.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        s2.append(ch);
      }
    }

    System.out.println("s1:" + s1);
    System.out.println("s2:" + s2);

    return s2.toString()
      .equalsIgnoreCase(s1.toString());

  }
}
