package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/18 PM 7:36:52
 * @version 1.0.0
 * @description 深信服-笔试-2-在一个神秘的森林中，住着一群聪明的小动物，每只动物都有一个独特的魔法数字
 * @filename Shenxinfu_2.kt
 *
 */

import java.util.*
import kotlin.math.max

fun main() {


    val scanner = Scanner(System.`in`)

    val input1 = scanner.nextLine().trim()
    val input2 = scanner.nextLine().trim()

    val length = input1.split(" ")[0].toInt()
    val k = input1.split(" ")[1].toInt()
    val nums = input2.split(" ").map { it.toInt() }.toIntArray()

    val dp = nums.copyOf()


    for (i in k..<length) {

        for (j in 0..i - k) {

            dp[i] = max(dp[i], nums[i] + dp[j])

        }

    }

    println(dp.max())

}