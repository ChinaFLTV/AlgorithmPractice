package interview

import java.util.Arrays

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/15 AM 11:13:23
 * @version 1.0.0
 * @description
 * @filename Lingyuekeji_2.kt
 *
 */


val res1 = mutableListOf<List<Int>>()

fun findCombination(nums: IntArray, k: Int, target: Int): List<List<Int>> {

    if (nums.isEmpty())
        return mutableListOf()

    Arrays.sort(nums)
    dfs(nums, 0, k, target, mutableListOf())

    return res1

}


private fun dfs(nums: IntArray, start: Int, k: Int, target: Int, subNums: MutableList<Int>) {

    if (target == 0) {

        res1.add(ArrayList(subNums))
        return

    }

    if (subNums.size >= k) {

        return

    }

    for (i in start..<nums.size) {

        if (target - nums[i] < 0)
            break

        subNums.add(nums[i])
        dfs(nums, start, k, target - nums[i], subNums)
        subNums.removeLast()

    }


}