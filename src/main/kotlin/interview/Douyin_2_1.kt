package interview

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/22 PM 2:51:39
 * @version 1.0.0
 * @description
 * @filename Douyin_2_1.kt
 *
 */


fun maxProfit(prices: IntArray): Int {

    var minPrice = Int.MAX_VALUE
    var profit = Int.MIN_VALUE

    for (i in 1..<prices.size) {

        minPrice = min(minPrice, prices[i - 1])
        profit = max(profit, prices[i] - minPrice)

    }

    return profit

}