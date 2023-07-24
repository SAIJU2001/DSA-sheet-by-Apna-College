//alpha

/*      121. Best Time to Buy and Sell Stock
Easy
26.8K
853
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

import java.util.*;

//leetcode solution
class Solution 
{
    public int maxProfit(int[] prices) 
    {    
        int maxProfit=0,profit=0;
        int buyPrice=Integer.MAX_VALUE;
        for( int i=0 ; i<prices.length ; i++ )
        {
            if( buyPrice<prices[i] )
            {
                profit=prices[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }
            else
            {
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
}

//driver code
public class BestTimeToBuyAndSellStock
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int n=Sc.nextInt();     //enter the length of the array
        int prices[]=new int[n];
        for( int i=0 ; i<n ; i++ )
        {
            //enter the elements of the array
            prices[i]=Sc.nextInt();
        }
        Solution sl=new Solution();
        System.out.print( sl.maxProfit( prices) );
    }
}