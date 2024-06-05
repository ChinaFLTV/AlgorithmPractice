package day62

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/26 PM 10:21:01
 * @version 1.0.0
 * @description 组合
 * @filename Combination.kt
 *
 */

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。*/

class Solution {


    private val result: ArrayList<ArrayList<Int>> = ArrayList()
    private val tempList = ArrayList<Int>()


    fun combine(n: Int, k: Int): List<List<Int>> {

        for (i in 1..n) {

            tempList.add(i)
            backTrack(n, k - 1, i + 1)
            tempList.removeLast()

        }

        return result

    }


    private fun backTrack(n: Int, k: Int, start: Int) {

        if (k == 0) {

            result.add(ArrayList(tempList))
            return

        }

        for (i in start..n) {

            tempList.add(i)
            backTrack(n, k - 1, i + 1)
            tempList.removeLast()

        }

    }


}


fun main() {


    Solution().combine(1, 1)

}