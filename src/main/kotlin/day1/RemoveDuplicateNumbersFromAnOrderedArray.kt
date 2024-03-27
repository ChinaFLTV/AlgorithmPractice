package day1

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/21 下午 7:20:05
 * @version 1.0.0
 * @description 80.删除有序数组中的重复项 II
 * @filename RemoveDuplicateNumbersFromAnOrderedArray.kt
 *
 */

/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



说明：

为什么返回数值是整数，但输出的答案是数组呢？

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}*/


class Solution2 {


    fun removeDuplicates(nums: IntArray): Int {

        val map: HashMap<Int, Int> = hashMapOf()// 记录每个num对应的已经遍历到的出现次数
        var movePointer: Int = -1// 记录当前元素应该要被移动到的索引
        for ((index, num) in nums.withIndex()) {

            val count = map.getOrDefault(num, 0)
            if (count == 2) {

                // 只有在指针为空时才去初始化指针，若已经被初始化过了，则无需再次初始化，因为这可能会在数组中产生空隙
                if (movePointer == -1) {

                    movePointer = index

                }

            } else {

                map[num] = count + 1

                if (movePointer != -1) {

                    nums[movePointer++] = nums[index]

                }

            }


        }

        return if (movePointer == -1) {

            nums.size

        } else {

            movePointer

        }

    }


    /**
     *
     * @author 刁子羊降临
     * @date 2024/3/22 下午 2:50:44
     * @version 1.0.0
     * @description 双指针+判相等变量
     * @filename RemoveDuplicateNumbersFromAnOrderedArray.kt
     *
     */
    fun removeDuplicates_answer_1(nums: IntArray): Int {

        var slow = 1
        var fast = 1
        var twice = false

        if (nums.size <= 2) {

            return nums.size

        }

        while (fast < nums.size) {

            if (nums[fast] != nums[fast - 1]) {

                nums[slow++] = nums[fast++]
                twice = false


            } else if (!twice) {

                nums[slow++] = nums[fast++]
                twice = true

            } else {

                fast++

            }

        }

        return slow

    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 2:58:50
     * @version 1.0.0
     * @description 双指针
     * @filename RemoveDuplicateNumbersFromAnOrderedArray.kt
     *
     */
    fun removeDuplicates_answer_2(nums: IntArray): Int {

        if (nums.size <= 2) {

            return nums.size

        }

        var slow = 2
        var fast = 2


        while (fast < nums.size) {

            if (nums[slow - 2] != nums[fast]) {

                nums[slow] = nums[fast]
                slow++

            }

            fast++

        }

        return slow

    }


}
