package day105

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/12 AM 9:23:09
 * @version 1.0.0
 * @description 数字范围按位与
 * @filename BitwiseAndOfNumbersRange.kt
 *
 */

/*
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。*/

class Solution {


    /*fun rangeBitwiseAnd(left: Int, right: Int): Int {

        var res = left

        for (i in left + 1..right) {

            res = res and i

        }

        return res

    }*/


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935">睡不醒的鲤鱼</a>
     * @date 2024/7/12 PM 12:42:22
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range/solutions/385466/ju-hao-li-jie-de-wei-yun-suan-si-lu-by-time-limit/?envType=study-plan-v2&envId=top-interview-150">巨好理解的位运算思路</a>
     * @filename BitwiseAndOfNumbersRange.kt
     *
     */
    fun rangeBitwiseAnd_answer_1(left: Int, right: Int): Int {

        var res = 0

        for (i in 0..31) {

            if (left shr i == right shr i) {

                res = left shr i shl i
                break

            }

        }

        return res

    }


}