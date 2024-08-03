package interview

import java.util.*

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/8/3 20:53
 * @version 1.0.0
 * @description 米哈游-笔试1-数组的价值，最大的相邻数字的乘积
 * @filename miHoYo_1.kt
 *
 */


fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    if (scanner.hasNextInt()) {

        val count = scanner.nextInt()

        scanner.nextLine()

        val input = scanner.nextLine()

        val nums = input.split(" ").map { it.toInt() }.sorted()

        println(nums[count - 2] * nums[count - 1])

    }

}