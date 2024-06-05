package day63

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/27 PM 11:16:40
 * @version 1.0.0
 * @description 全排列
 * @filename FullPermutation.kt
 *
 */

/*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。*/

class Solution {


    private val result = ArrayList<ArrayList<Int>>()
    private val tempSet = LinkedHashSet<Int>()


    fun permute(nums: IntArray): List<List<Int>> {

        backTrack(nums.size, linkedSetOf(*nums.toTypedArray()))

        return result

    }


    private fun backTrack(num: Int, nums: LinkedHashSet<Int>) {

        if (num == 0) {

            result.add(ArrayList(tempSet))
            return

        }

        val diff = nums.subtract(tempSet)

        for (i in diff) {

            tempSet.add(i)
            backTrack(num - 1, nums)
            tempSet.remove(i)

        }

    }


}