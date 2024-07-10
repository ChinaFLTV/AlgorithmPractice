package day103

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/10 AM 10:44:36
 * @version 1.0.0
 * @description 只出现一次的数字
 * @filename SingleNumber.kt
 *
 */

/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/7/10 AM 11:03:44
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/single-number/solutions/2361995/136-zhi-chu-xian-yi-ci-de-shu-zi-wei-yun-iyd0/?envType=study-plan-v2&envId=top-interview-150">只出现一次的数字（位运算，清晰图解）</a>
     * @filename SingleNumber.kt
     *
     */
    fun singleNumber_answer_1(nums: IntArray): Int {

        return nums.reduce(Int::xor)

    }


}