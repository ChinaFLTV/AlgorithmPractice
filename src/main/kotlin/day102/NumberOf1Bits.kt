package day102

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/9 PM 8:48:57
 * @version 1.0.0
 * @description 位1的个数
 * @filename NumberOf1Bits.kt
 *
 */

/*
编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。*/

class Solution {


    fun hammingWeight(n: Int): Int {

        var tempN = n
        var count = 0

        while (tempN > 0) {

            if (tempN and 1 == 1) {

                count++

            }

            tempN = tempN shr 1

        }

        return count

    }


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/7/9 PM 9:29:13
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/number-of-1-bits/solutions/2361978/191-wei-1-de-ge-shu-wei-yun-suan-qing-xi-40rw/?envType=study-plan-v2&envId=top-interview-150">位 1 的个数（位运算，清晰图解）</a>
     * @filename NumberOf1Bits.kt
     *
     */
    fun hammingWeight_answer_1(n: Int): Int {

        var tempN = n
        var count = 0

        while (tempN > 0) {

            count++

            tempN = tempN and (tempN - 1)

        }

        return count

    }


}