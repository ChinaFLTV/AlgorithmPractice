package day64

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/28 PM 9:28:14
 * @version 1.0.0
 * @description 组合总和
 * @filename CombinationSummation.kt
 *
 */

/*
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

对于给定的输入，保证和为 target 的不同组合数少于 150 个。*/

class Solution {


    private val result = ArrayList<ArrayList<Int>>()
    private val tempList = ArrayList<Int>()


    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        candidates.sort()

        for (i in candidates.indices) {

            tempList.add(candidates[i])
            backTrack(candidates[i], i, candidates, target)
            tempList.removeLast()

        }

        return result

    }

    private fun backTrack(tempCount: Int, startIndex: Int, candidates: IntArray, target: Int) {

        if (tempCount > target) return
        if (tempCount == target) {

            result.add(ArrayList(tempList))
            return

        }

        for (i in startIndex..<candidates.size) {

            if (tempCount + candidates[i] > target) {

                break

            }

            tempList.add(candidates[i])
            backTrack(tempCount + candidates[i], i, candidates, target)
            tempList.removeLast()

        }


    }


}