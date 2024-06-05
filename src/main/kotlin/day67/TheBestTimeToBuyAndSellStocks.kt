package day67

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/31 PM 5:41:44
 * @version 1.0.0
 * @description 买卖股票的最佳时机 II
 * @filename TheBestTimeToBuyAndSellStocks.kt
 *
 */

/*
给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/5/31 PM 6:15:40
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/12625/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/?envType=study-plan-v2&envId=top-interview-150">题解</a>
     * @filename TheBestTimeToBuyAndSellStocks.kt
     *
     */
    fun maxProfit(prices: IntArray): Int {

        if (prices.size <= 1) return 0

        var profit = 0

        for (d in 1..<prices.size) {

            if (prices[d] > prices[d - 1]) {

                profit += (prices[d] - prices[d - 1])

            }

        }

        return profit

    }


}