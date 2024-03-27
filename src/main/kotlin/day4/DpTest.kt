package day4

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/24 下午 10:16:30
 * @version 1.0.0
 * @description 测试DP
 * @filename DpTest.kt
 *
 */

fun main() {

    val array = IntArray(100)
    val end = 15
    array[0] = 0

    for (i in 1..end) {

        var cost = Int.MAX_VALUE
        if (i - 1 >= 0) cost = min(cost, array[i - 1] + 1)
        if (i - 5 >= 0) cost = min(cost, array[i - 5] + 1)
        if (i - 11 >= 0) cost = min(cost, array[i - 11] + 1)
        array[i] = cost
        println("array[$i] = $cost")

    }

    println("-----------------------------------------------------------------")

    val nums = intArrayOf(1, 5, 3, 4, 6, 9, 7, 8)
    val array1 = IntArray(nums.size) {

        if (it == 0) {

            1

        } else {

            0

        }

    }

    for (x in nums.indices) {

        for (y in 0..<x) {

            if (nums[y] < nums[x]) {

                array1[x] = max(array1[x], array1[y] + 1)

            }

        }

    }


    for ((index, value) in array1.withIndex()) {

        println("array1[$index] = $value")

    }


}
