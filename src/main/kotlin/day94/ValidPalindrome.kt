package day94

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/28 PM 5:21:54
 * @version 1.0.0
 * @description 验证回文串
 * @filename ValidPalindrome.kt
 *
 */

/*
如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

字母和数字都属于字母数字字符。

给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。*/

class Solution {


    fun isPalindrome(s: String): Boolean {

        val processedStr = s.replace(Regex("[^a-zA-Z0-9]"), "").lowercase(Locale.getDefault())

        if (processedStr.length <= 1)
            return true

        var left = 0
        var right = processedStr.length - 1

        while (left < right) {

            if (processedStr[left] == processedStr[right]) {

                left++
                right--

            } else {

                return false

            }

        }

        return true

    }


}


fun main() {

    Solution().isPalindrome("A man, a plan, a canal: Panama")

}