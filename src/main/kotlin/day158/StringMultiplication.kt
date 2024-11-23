package day158

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/23 AM 10:45:11
 * @version 1.0.0
 * @description 字符串乘法 , 输出2的1000次方
 * @filename StringMultiplication.kt
 *
 */

class Solution {


    /**
     *
     * @author <a href="https://blog.csdn.net/wumy09">wumy09</a>
     * @date 2024/11/23 AM 11:12:56
     * @version 1.0.0
     * @description <a href="https://blog.csdn.net/wumy09/article/details/118053245">计算2的1000次方（java实现，原理都一样）</a>
     * @filename StringMultiplication.kt
     *
     */
    fun calculate2pow1000(): String {

        val nums = mutableListOf<Int>()
        nums.add(2)

        for (i in 1..999) {

            var carry = 0

            for (j in nums.indices) {

                val temp = nums[j] * 2 + carry

                nums[j] = temp % 10
                carry = temp / 10

            }

            if (carry > 0)
                nums.add(carry)

        }

        return nums.reversed().joinToString("")

    }


}


fun main() {

    println(Solution().calculate2pow1000())

}