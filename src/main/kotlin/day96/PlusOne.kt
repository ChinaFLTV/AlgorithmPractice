package day96

import java.math.BigInteger

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/30 PM 5:43:10
 * @version 1.0.0
 * @description 加一
 * @filename PlusOne.kt
 *
 */

/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。*/

class Solution {


    fun plusOne(digits: IntArray): IntArray {

        var sum = BigInteger(digits.joinToString(separator = ""))

        sum = sum.add(BigInteger("1"))

        return sum.toString().toCharArray().map { Character.getNumericValue(it) }.toIntArray()

    }


    /**
     *
     * @author <a href="https://leetcode.cn/u/yhhzw/">YHHZW</a>
     * @date 2024/6/30 PM 6:44:23
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/plus-one/solutions/4481/java-shu-xue-jie-ti-by-yhhzw/?envType=study-plan-v2&envId=top-interview-150">题解</a>
     * @filename PlusOne.kt
     *
     */
    fun plusOne_answer_1(digits: IntArray): IntArray {

        for (i in digits.size - 1 downTo 0) {

            digits[i] = ++digits[i] % 10

            if (digits[i] != 0)
                return digits

        }

        return IntArray(digits.size + 1) {

            if (it == 0)
                1
            else
                0

        }

    }


}


fun main() {

    Solution().plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))

}