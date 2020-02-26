/**
 * 
 */
package com.pranav.ctci.arrayString;

/**
 * @author pranavpatel
 *
 */
public class D_OneEditAway {

  public static boolean oneEditAway(String s1, String s2) {

    if (s1.length() == s2.length())
      return oneEditReplace(s1, s2);
    if (s1.length() == s2.length()+1)
      return oneEditInsertRemove(s1, s2);
    if (s1.length() == s2.length()-1)
      return oneEditInsertRemove(s2, s1);

    return false;
  }

  private static boolean oneEditReplace(String s1, String s2) {

    boolean changeCounter = false;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (changeCounter)
          return false;
        changeCounter = true;
      }

    }
    return true;
  }

  private static boolean oneEditInsertRemove(String s1, String s2) {

    // s1 longer
    // s2 shorter

    int index1 = 0;
    int index2 = 0;

    while (index1 < s1.length() && index2 < s2.length()) {

      if (s1.charAt(index1) != s2.charAt(index2)) {

        index1++;
        // if un-matching and one of the string reaches at end
        if(index1==s1.length() || index2==s2.length()) return false;
      } else {
        index1++;
        index2++;

      }

    }
    return true;
  }

  public static void main(String[] args) {
    // System.out.println(oneEditAway("bale", "pale")); // replace
     System.out.println(oneEditAway("ple", "pale")); // insert
    //System.out.println(oneEditAway("pale", "pae")); // removal
  }

}
