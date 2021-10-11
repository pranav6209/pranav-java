/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/meeting-rooms/
 *
 */
public class A3_C3_Attend_Meetings {

  /*
   * 
   * 
   * 
   *  
   * optimal solution
   * option -1 sort interval and if interval1 end > interval2 start we have overlap
   * 
   * Time : O(NlogN) + O(N) = NlogN for sorting  and for one pass to interval where 
   * n is number of interval 
   * 
   * space : O(1)
   * 
   */
  public static int can_attend_all_meetings(List<List<Integer>> intervals) {

    Collections.sort(intervals,(l1, l2) -> l1.get(0) - l2.get(0));
    
    // i < intervals.size() -1
    for (int i = 0; i < intervals.size() - 1; i++) {

      List<Integer> interval1 = intervals.get(i);
      List<Integer> interval2 = intervals.get(i + 1);

      if (interval1.get(1) > interval2.get(0))
        return 0;

    }

    return 1;
  }

  public static int can_attend_all_meetings_brute_force(List<List<Integer>> intervals) {

    int[] startArr = new int[intervals.size()];
    HashMap<Integer, Integer> intervalMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < intervals.size(); i++) {
      List<Integer> interval = intervals.get(i);
      int start = interval.get(0);
      int end = interval.get(1);
      // if start is already in the map we have a dups and return false;
      if (intervalMap.containsKey(start))
        return 0;
      intervalMap.put(start, end);
      startArr[i] = start;
    }

    Arrays.sort(startArr);
    for (int i = 1; i < startArr.length; i++) {
      int prevEnd = intervalMap.get(startArr[i - 1]);
      if (prevEnd > startArr[i])
        return 0;
    }
    return 1;

  }

}
