/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * 
 * solution explanation 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/208241/Explanation-for-the-dummy-like-me.
 *  
 * // valley and peak algo
 *  time complexity 0(n)
 *  space complexity 0(1)
 *
 */
public class P2_Best_Time_Buy_Sell_2 {
  public static int maxProfit(int[] prices) {
        
    int i = 0, buy, sell, profit = 0, n = prices.length-1; // length-1 as we are doing i+1 below

    while (i < n) {

      // iterate through numbers till we see a dropping pattern and 
      // get the minimum value
      // buy first
      while (i < n && prices[i + 1] <= prices[i]) {
        i++;
        }
      buy = prices[i];
      // valley = price[i]

      
      // iterate through number till we see incresasing 
      //pattern 
      // sell and get the profit
      while (i < n && prices[i + 1] > prices[i]) {
        i++;
      }
      sell = prices[i];
      //peack = price[i]
      profit = profit + (sell - buy);

    }

    return profit;

  }
/*  
 * 
 * Don't understand yet
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/564729/Java-Simple-Code-DP
 * 
    public int maxProfit(int[] A) {                        
        int n = A.length, lastBuy = -A[0], lastSold = 0;
        if (n == 0) return 0;
                                
        for (int i = 1; i < n; i++) {
            int curBuy = Math.max(lastBuy, lastSold - A[i]);
            int curSold = Math.max(lastSold, lastBuy + A[i]);
            lastBuy = curBuy;
            lastSold = curSold;
        }
        
        return lastSold;
    }
}
*/
  public static void main(String[] args) {

    int[] prices = { 7, 1, 5, 3, 6, 4 };
    System.out.println(maxProfit(prices));
  }

}
