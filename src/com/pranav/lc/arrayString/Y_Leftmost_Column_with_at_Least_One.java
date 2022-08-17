/**
 *
 */
package com.pranav.lc.arrayString;

import java.util.List;

/**
 * @author pranavpatel
 * Problem from lettcode challenge 
 *  https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
 *
 *  https://leetcode.com/discuss/interview-question/341247/facebook-leftmost-column-index-of-1
 *
 * solution 
 *
 * https://www.youtube.com/watch?v=K2E5fMMAf5U
 *
 *  Time complextity O(R+C)
 *
 */

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */
public class Y_Leftmost_Column_with_at_Least_One {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        List<Integer> dim = binaryMatrix.dimensions();
        // length-1 for 0th index
        int row = dim.get(0) - 1;
        int col = dim.get(1) - 1;
        int result = -1;

        while (row >= 0 && col >= 0) {
            // if current row,col value is 1 keep going left(decreasing col)
            // to check 1
            if (binaryMatrix.get(row, col) == 1) {
                result = col;
                col = col - 1;
            }
            // if value is 0 decrement the row
            else
                row = row - 1;
        }
        return result;

    }
}
