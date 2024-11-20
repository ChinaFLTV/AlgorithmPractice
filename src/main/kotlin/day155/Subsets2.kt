package day155

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/20 PM 7:35:57
 * @version 1.0.0
 * @description 90. 子集 II
 * @filename Subsets2.kt
 *
 */

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
子集
（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10*/

class Solution2 {


    private val res = mutableListOf<List<Int>>()
    private lateinit var visited: Array<Boolean>

    /**
     *
     * @author <a href="https://leetcode.cn/u/hxz1998/">CHerrY</a>
     * @date 2024/11/20 PM 8:22:09
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/subsets-ii/solutions/690866/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/comments/864235">送上一个Java版本的。</a>
     * @filename Subsets2.kt
     *
     */
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {

        visited = Array(nums.size) { false }
        Arrays.sort(nums)

        dfs(nums, 0, mutableListOf())

        return res

    }


    private fun dfs(nums: IntArray, start: Int, subRes: MutableList<Int>) {

        res.add(subRes.toList())

        for (i in start..<nums.size) {

            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
                continue

            visited[i] = true
            subRes.add(nums[i])
            dfs(nums, i + 1, subRes)
            subRes.removeLast()
            visited[i] = false

        }

    }


}