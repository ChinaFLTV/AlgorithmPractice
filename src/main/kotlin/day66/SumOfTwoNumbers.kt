package day66

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/30 PM 8:11:22
 * @version 1.0.0
 * @description 两数之和 II - 输入有序数组
 * @filename SumOfTwoNumbers.kt
 *
 */

/*
给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

你所设计的解决方案必须只使用常量级的额外空间。*/

class Solution {


    fun twoSum(numbers: IntArray, target: Int): IntArray {

        val result = IntArray(2)

        for (i in numbers.indices) {

            for (j in i + 1..<numbers.size) {

                if (numbers[i] + numbers[j] == target) {

                    result[0] = i + 1
                    result[1] = j + 1
                    return result

                }

            }

        }

        return result

    }


    fun twoSum2(numbers: IntArray, target: Int): IntArray {

        val result = IntArray(2)

        for (i in numbers.indices) {

            for (j in i + 1..<numbers.size) {

                if (numbers[i] + numbers[j] == target) {

                    result[0] = i + 1
                    result[1] = j + 1
                    return result

                } else if (numbers[i] + numbers[j] > target) {

                    break

                }

            }

        }

        return result

    }


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/5/30 PM 8:38:12
     * @version 1.0.0
     * @description
     * @filename SumOfTwoNumbers.kt
     *
     */
    fun twoSum_answer_1(numbers: IntArray, target: Int): IntArray {

        var left = 0
        var right = numbers.size - 1

        while (left < right) {

            if (numbers[left] + numbers[right] < target) {

                left++

            } else if (numbers[left] + numbers[right] == target) {

                return intArrayOf(left + 1, right + 1)

            } else if (numbers[left] + numbers[right] > target) {

                right--

            }

        }

        return intArrayOf()

    }


}