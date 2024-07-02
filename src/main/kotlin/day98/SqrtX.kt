package day98

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/2 AM 9:59:22
 * @version 1.0.0
 * @description x 的平方根
 * @filename SqrtX.kt
 *
 */

/*给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。*/

class Solution {


    private var originX: Int = -1


    /**
     *
     * @author <a href="https://leetcode.cn/u/loafer/">loafer</a>
     * @date 2024/7/2 AM 11:08:15
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/sqrtx/solutions/7568/niu-dun-die-dai-fa-by-loafer/?envType=study-plan-v2&envId=top-interview-150">牛顿求根法</a>
     * @filename SqrtX.kt
     *
     */
    fun mySqrt(x: Int): Int {

        originX = x

        return sqrt(x.toDouble()).toInt()

    }


    private fun sqrt(x: Double): Double {

        return if (x == 0.0 || x == 1.0)
            x
        else {

            val temp = (x + originX / x) / 2
            if (temp == x)
                x
            else
                sqrt(temp)

        }

    }


}