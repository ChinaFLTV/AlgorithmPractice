package day97

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/1 PM 4:13:22
 * @version 1.0.0
 * @description 阶乘后的零
 * @filename FactorialTrailingZeroes.kt
 *
 */

/*
给定一个整数 n ，返回 n! 结果中尾随零的数量。

提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1*/

class Solution {


    /*fun trailingZeroes(n: Int): Int {

        var factorialN = factorial(n)

        var res = 0

        while (factorialN > 0) {

            if (factorialN % 10 == 0) {

                res++
                factorialN /= 10

            } else
                break

        }

        return res

    }


    private fun factorial(num: Int): Int {

        if (num <= 2)
            return num

        return num * factorial(num - 1)

    }*/


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/7/1 PM 4:31:26
     * @version 1.0.0
     * @description 质因数统计
     * @filename FactorialTrailingZeroes.kt
     *
     */
    fun trailingZeroes(n: Int): Int {

        var res = 0
        var tempN = n

        while (tempN > 0) {

            res += tempN / 5
            tempN /= 5

        }

        return res

    }


}