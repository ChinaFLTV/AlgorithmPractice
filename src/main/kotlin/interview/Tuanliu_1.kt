package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/28 PM 2:22:37
 * @version 1.0.0
 * @description 湍流信息科技-面试-1
 * @filename Tuanliu_1.kt
 *
 */

val n = 5
val bad = 4


fun isBadVersion(ver: Int) = ver >= bad

fun findMinBadVersion(n: Int): Int {

    var left = 1
    var right = n

    while (left < right) {

        val pivot = (left + right) / 2

        if (isBadVersion(pivot))
            right = pivot - 1
        else
            left = pivot + 1

    }

    return left

}


fun main() {

    println("-----------------------------------------------------------------");
    println(findMinBadVersion(n))

}