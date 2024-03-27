package day3

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/23 下午 5:21:30
 * @version 1.0.0
 * @description 买卖股票的最佳时机
 * @filename TheBestTimeToBuyAndSellStocks.kt
 *
 */

/*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。*/


class Solution {


    // 超时了~
    /*fun maxProfit(prices: IntArray): Int {

        var day = 0
        var profit = 0

        if (prices.size <= 1) return 0

        for (i in 0..<prices.size - 1) {

            val currentPrice = prices[i]
            prices[i] = -1
            val maxPrice = prices.max()
            if ((maxPrice - currentPrice) > profit) {

                day = i
                profit = maxPrice - currentPrice

            }

        }

        return profit

    }*/


    /**
     *
     * @author 代码随想录
     * @date 2024/3/23 下午 8:02:43
     * @version 1.0.0
     * @description 贪心算法(双指针)
     * @filename TheBestTimeToBuyAndSellStocks.kt
     *
     */
    fun maxProfit_answer_1(prices: IntArray): Int {

        if (prices.size <= 1) return 0

        var left = 0
        var right = prices.size - 1
        var leftMinPrice = Int.MAX_VALUE
        var leftMinPriceIndex = -1
        var rightMaxPrice = 0
        var rightMaxPriceIndex = prices.size

        while (left < right && left < prices.size && right >= 0) {

            if (leftMinPriceIndex < rightMaxPriceIndex) {

                if (leftMinPrice > prices[left]) {

                    leftMinPriceIndex = left
                    leftMinPrice = prices[left++]

                }

                if (rightMaxPrice < prices[right]) {

                    rightMaxPriceIndex = right
                    rightMaxPrice = prices[right--]

                }

            }

        }

        /*if (prices.size % 2 == 1) {

            leftMinPrice = min(leftMinPrice, prices[left])
            rightMaxPrice = max(prices[right], rightMaxPrice)

        }*/

        return if (rightMaxPrice - leftMinPrice > 0) rightMaxPrice - leftMinPrice else 0

    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/23 下午 8:30:03
     * @version 1.0.0
     * @description 一次遍历
     * @filename TheBestTimeToBuyAndSellStocks.kt
     *
     */
    fun maxProfit_answer_2(prices: IntArray): Int {

        if (prices.size <= 1) return 0

        var minPrice = prices[0]
        var maxProfit = 0

        for (i in 1..<prices.size) {

            val currentProfit = prices[i] - minPrice
            if (currentProfit > maxProfit) {

                maxProfit = currentProfit

            }
            minPrice = min(minPrice, prices[i])

        }

        return maxProfit

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/3/25 下午 11:09:31
     * @version 1.0.0
     * @description 动态规划(超时了~呜呜呜)
     * @filename TheBestTimeToBuyAndSellStocks.kt
     *
     */
    fun maxProfit_answer_3(prices: IntArray): Int {

        val array = IntArray(prices.size) { 0 }
        var minPrice = Int.MAX_VALUE

        for (x in prices.indices) {

            for (y in 0..<x) {

                array[x] = max(array[y], prices[x] - minPrice)

            }
            minPrice = min(minPrice, prices[x])

        }

        return array.max()

    }


}