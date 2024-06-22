package day88

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/22 PM 6:38:03
 * @version 1.0.0
 * @description 存在重复元素 II
 * @filename ContainsDuplicateLi.kt
 *
 */

/*
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/guanpengchn/">画手大鹏</a>
     * @date 2024/6/22 PM 7:16:07
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/contains-duplicate-ii/solutions/13564/hua-jie-suan-fa-219-cun-zai-zhong-fu-yuan-su-ii-by/?envType=study-plan-v2&envId=top-interview-150">画解算法：219. 存在重复元素 II</a>
     * @filename ContainsDuplicateLi.kt
     *
     */
    fun containsNearbyDuplicate_answer_1(nums: IntArray, k: Int): Boolean {

        val set = LinkedHashSet<Int>(k)

        for ((index, num) in nums.withIndex()) {

            if (set.contains(num))
                return true
            else {

                set.add(num)
                if (set.size > k)
                    set.remove(nums[index - k])

            }

        }

        return false

    }


}


fun main() {

    Solution().containsNearbyDuplicate_answer_1(intArrayOf(1, 2, 3, 1, 2, 3), 3)

}