package day107

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/28 PM 1:12:50
 * @version 1.0.0
 * @description 子集
 * @filename Subsets.kt
 *
 */

/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/

class Solution {


    private val res = ArrayList<ArrayList<Int>>()
    private val tempList = ArrayList<Int>()


    fun subsets(nums: IntArray): List<List<Int>> {

        for (i in 0..nums.size) {

            backTrack(i, 0, nums)

        }

        return res

    }


    private fun backTrack(num: Int, start: Int, nums: IntArray) {

        if (num == 0) {

            @Suppress("UNCHECKED_CAST")
            res.add(tempList.clone() as ArrayList<Int>)
            return

        }

        for (i in start..nums.size - num) {

            tempList.add(nums[i])
            backTrack(num - 1, i + 1, nums)
            tempList.removeLast()

        }

    }


}