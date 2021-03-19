/**
 * 
 */
package com.pranav.educative.I_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 *  Educative for Time and Space
 */
public class A6_Unique_Generalize_Abbreviations {
  public static List<String> generateGeneralizedAbbreviation(String word) {
    List<String> result = new ArrayList<String>();
    // here we are using StringBuilder instead of char [] because, in the case 
    // we are generating 3, our index is at 3 and we do not want to put 3 at index 3 rather 
    // we want to generate "3".if we use char array it will generate "  3"(2space and then 3)
    generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
    return result;
  }

  private static void generateAbbreviationRecursive(String word, StringBuilder abWord, int index, int count,
      List<String> result) {

    if (index == word.length()) {
      if (count != 0)
        abWord.append(count);
      result.add(abWord.toString());
    } else {
      // continue abbreviating by incrementing the current abbreviation count
      generateAbbreviationRecursive(word, new StringBuilder(abWord), index + 1, count + 1, result);

      // restart abbreviating, append the count and the current character to the string
      if (count != 0)
        abWord.append(count);
      generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(index)), index + 1, 0, result);
    }
  }

  public static void main(String[] args) {
    List<String> result = A6_Unique_Generalize_Abbreviations.generateGeneralizedAbbreviation("BAT");
    System.out.println("Generalized abbreviation are: " + result);

    result = A6_Unique_Generalize_Abbreviations.generateGeneralizedAbbreviation("code");
    System.out.println("Generalized abbreviation are: " + result);
  }
}
