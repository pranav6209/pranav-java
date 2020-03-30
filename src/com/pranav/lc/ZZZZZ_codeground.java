/**
 * 
 */
package com.pranav.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class ZZZZZ_codeground {

  static int shortestWordEditPath(String source, String target, String[] words) {

    for (int i = 0; i < words.length; i++) {

      if (!Arrays.asList(words)
        .contains(target))
        return -1;

    }

    List<String> links = new ArrayList<>();
    String currentSource = source;

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int diff = 0;
      if (currentSource.equals(target))
        break;
      for (int j = 0; j < word.length(); j++) {
        if (word.charAt(j) != currentSource.charAt(j))
          diff++;
      }

      if (diff == 1) {
        links.add(word);
        currentSource = word;
      }

    }

    links.forEach(link -> System.out.print(link + ","));
    if (links.size() == 0)
      return -1;
    return links.size();

  }

  public static void main(String[] args) {

    // String source = "bit", target = "dog";
    // String[] words = { "but", "put", "big", "pot", "pog", "dog", "lot" };
    // System.out.println(shortestWordEditPath(source, target, words));

    // String source = "abc", target = "ab";
    // String[] words = { "abc", "ab" };
    // System.out.println(shortestWordEditPath(source, target, words));

    String source = "bit", target = "pog";
    String[] words = { "but", "put", "big", "pot", "pog", "pig", "dog", "lot" };
    System.out.println(shortestWordEditPath(source, target, words));

  }
}
