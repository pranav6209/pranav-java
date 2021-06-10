/**
* 
*/
package com.pranav.educative.K_Top_K_Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * option -1 Choose every two possible intervals and check if they are overlapping or not. If any of the two intervals are found overlapping, attending all the meetings is not possible.
 * 
 *
 */
public class scratch {
  public static int can_attend_all_meetings(List<List<Integer>> intervals) {

    int[] startArr = new int[intervals.size()];
    HashMap<Integer, Integer> intervalMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < intervals.size(); i++) {
      List<Integer> interval = intervals.get(i);
      int start = interval.get(0);
      int end = interval.get(1);
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
  
  public static int can_attend_all_meetings2(List<List<Integer>> intervals) {
    intervals.sort((l1, l2) -> l1.get(0) - l2.get(0));
    System.out.println("intervals"+intervals);
    for (int i=1;i<intervals.size();i++){
        if (intervals.get(i).get(0) < intervals.get(i-1).get(1)){
            return 0;
        }
    }
    return 1;
}

  public static void main(String[] args) {
    List<Integer> input1 = new ArrayList<Integer>();
    List<Integer> input2 = new ArrayList<Integer>();
    List<Integer> input3 = new ArrayList<Integer>();
    List<List<Integer>> input10 = new ArrayList<>();
    
    input1.add(1);
    input1.add(5);
    System.out.println(input1);
    input10.add(input1);
    input2.add(5);
    input2.add(8);
    input10.add(input2);
    input3.add(10);
    input3.add(15);
    input10.add(input3);
    
 
    
    System.out.println(input10);
    
    System.out.println(can_attend_all_meetings2(input10));

  }
}
