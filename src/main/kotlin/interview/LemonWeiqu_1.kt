package interview

import java.util.*

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/8/6 18:09
 * @version 1.0.0
 * @description 柠檬微趣-1-排序链表
 * @filename LemonWeiqu_1.kt
 *
 */


fun main() {

    val scanner = Scanner(System.`in`)

    if (scanner.hasNext()) {

        val input = scanner.nextLine()
        val nums = input.split(" ").map { it.toInt() }.sorted().joinToString()
        println(nums)

    }

}