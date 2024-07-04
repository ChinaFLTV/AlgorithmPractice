package day99

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/3 AM 11:00:08
 * @version 1.0.0
 * @description Pow(x,n)
 * @filename PowXN.kt
 *
 */

/*
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/7/3 AM 11:11:28
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/powx-n/solutions/241471/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/?envType=study-plan-v2&envId=top-interview-150">快速幂</a>
     * @filename PowXN.kt
     *
     */
    fun myPow_answer_1(x: Double, n: Int): Double {

        if (x == 0.0)
            return 0.0

        var tempX = x
        var tempN: Long = n.toLong()
        var res = 1.0

        if (n < 0) {

            tempN = -tempN
            tempX = 1.0 / tempX

        }

        while (tempN > 0) {

            if (tempN and 1 == 1L)
                res *= tempX

            tempX *= tempX
            tempN = tempN shr 1

        }

        return res

    }


}