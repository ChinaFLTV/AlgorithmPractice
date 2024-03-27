package day2

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/22 下午 8:21:44
 * @version 1.0.0
 * @description 轮转数组
 * @filename RotateArray.kt
 *
 */

/*给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。*/

class Solution4 {


    fun rotate(nums: IntArray, k: Int) {

        val rotatedNums = IntArray(nums.size)
        var index = 0

        val n = if (k > nums.size) k % nums.size else k

        for (i in nums.size - n..<nums.size) {

            rotatedNums[index++] = nums[i]

        }

        for (i in 0..nums.size - 1 - n) {

            rotatedNums[index++] = nums[i]

        }

        for (i in nums.indices) {

            nums[i] = rotatedNums[i]

        }

    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 9:25:34
     * @version 1.0.0
     * @description 使用额外的数组
     * @filename RotateArray.kt
     *
     */
    fun rotate_answer_1(nums: IntArray, k: Int) {

        val newNums = IntArray(nums.size)

        for (i in nums.indices) {

            newNums[(i + k) % nums.size] = nums[i]

        }

        System.arraycopy(newNums, 0, nums, 0, nums.size)

    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 10:11:39
     * @version 1.0.0
     * @description 环状替换
     * @filename RotateArray.kt
     *
     */
    fun rotate_answer_2(nums: IntArray, k: Int) {

        var count = 0
        var start = 0
        var next = 0
        var prev: Int
        var temp: Int
        val n = k % nums.size

        if (nums.size == 1 || k == 0 || k == nums.size) return

        prev = nums[next]

        while (++count <= nums.size) {

            next = (next + n) % nums.size
            temp = nums[next]
            nums[next] = prev
            prev = temp

            if (next == start) {

                start++
                next = start
                prev = nums[next]

            }

        }


    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 9:35:25
     * @version 1.0.0
     * @description 数组翻转
     * @filename RotateArray.kt
     *
     */
    fun rotate_answer_3(nums: IntArray, k: Int) {

        nums.reverse()
        nums.reverse(0, k % nums.size)
        nums.reverse(k % nums.size, nums.size)

    }


}