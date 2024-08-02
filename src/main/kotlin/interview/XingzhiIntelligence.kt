package interview

import kotlin.math.max

fun findLongestSubstring(nums: IntArray): Int {


    if (nums.size <= 1) {

        return nums.size

    }

    val dp = IntArray(nums.size)

    dp[0] = 1
    for (i in 1..<nums.size) {

        var tempMax = 0
        for (j in 0..<i) {

            if (nums[i] > nums[j]) {

                tempMax = max(tempMax, dp[j] + 1)

            }

        }

        dp[i] = tempMax

    }

    return dp.max()

}