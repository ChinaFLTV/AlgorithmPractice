package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/10 PM 8:45:19
 * @version 1.0.0
 * @description 兴业数金-笔试1-从水管中切割出至少k个长度都为m的水管
 * @filename Xingyeshujin_1.kt
 *
 */

/**
 *
 * @author ChatGPT
 * @date 2024/8/10 PM 8:48:17
 * @version 1.0.0
 * @description
 * @filename Xingyeshujin_1.kt
 *
 */
fun maxPipeLength(pipes: IntArray, k: Int): Int {

    // 辅助函数：检查是否可以从水管中切割出至少 k 根长度为 m 的水管
    fun canCut(m: Int): Boolean {

        var count = 0
        for (pipe in pipes) {

            count += pipe / m

        }
        return count >= k

    }

    // 二分查找
    var left = 1
    var right = pipes.maxOrNull() ?: 0
    var result = 0

    while (left <= right) {

        val mid = (left + right) / 2

        if (canCut(mid)) {

            result = mid
            left = mid + 1

        } else {

            right = mid - 1

        }

    }

    return result

}

// 测试代码
fun main() {

    val pipes = intArrayOf(1, 2, 3, 4, 5)
    val k = 3
    println(maxPipeLength(pipes, k))  // 输出: 3

}