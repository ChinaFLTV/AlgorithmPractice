package day129

/**
 *
 * @author <a href="https://juejin.cn/user/430664289102471/posts">胡哥有话说</a>
 * @date 2024/10/16 PM 5:19:11
 * @version 1.0.0
 * @description <a href="https://juejin.cn/post/6844904143753052168">《剑指Offer》- 连续子数组的最大和或最小和</a>
 * @filename MinSubArraySum.kt
 *
 */

fun getMaxSubArraySum(nums: IntArray): Int {

    if (nums.isEmpty())
        return 0

    var sum = nums[0]
    var max = nums[0]

    for (i in 1..<nums.size) {

        if (sum < 0)
            sum = nums[i]
        else
            sum += nums[i]

        max = maxOf(max, sum)

    }

    return max

}


fun getMinSubArraySum(nums: IntArray): Int {

    if (nums.isEmpty())
        return 0

    var sum = nums[0]
    var min = nums[0]

    for (i in 1..<nums.size) {

        if (sum > 0)
            sum = nums[i]
        else
            sum += nums[i]

        min = minOf(min, sum)

    }

    return min

}


fun main() {

    val nums = intArrayOf(3, -2, 1, 2, 4, -6, 5)
    println(getMaxSubArraySum(nums))
    println(getMinSubArraySum(nums))

}