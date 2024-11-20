package day155

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/20 PM 6:58:08
 * @version 1.0.0
 * @description 78. 子集
 * @filename SubSets.kt
 *
 */

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
子集
（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同*/

class Solution {


    private val res = mutableListOf<List<Int>>()


    fun subsets(nums: IntArray): List<List<Int>> {

        dfs(nums, 0, mutableListOf())
        return res

    }


    private fun dfs(nums: IntArray, start: Int, subRes: MutableList<Int>) {

        res.add(subRes.toList())

        for (i in start..<nums.size) {

            subRes.add(nums[i])
            dfs(nums, i + 1, subRes)
            subRes.removeLast()

        }

    }


}