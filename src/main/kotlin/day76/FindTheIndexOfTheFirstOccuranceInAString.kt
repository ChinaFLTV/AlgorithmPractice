package day76

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/10 PM 6:24:38
 * @version 1.0.0
 * @description 找出字符串中第一个匹配项的下标
 * @filename FindTheIndexOfTheFirstOccurrenceInAString.kt
 *
 */

/*
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。*/

class Solution {


    private lateinit var nextArray: IntArray


    fun strStr(haystack: String, needle: String): Int {

        initNextArray(needle)
        var i = 0
        var j = 0
        while (i < haystack.length) {

            if (haystack[i] == needle[j]) {

                i++
                j++

            } else if (j != 0 && haystack[i] != needle[j]) {

                j = nextArray[j - 1]

            } else {

                i++

            }

            if (j == needle.length) {

                return i - j

            }

        }

        return -1

    }


    private fun initNextArray(needle: String) {

        var now = 0
        nextArray = IntArray(needle.length)
        nextArray[0] = 0

        var i = 1
        while (i < nextArray.size) {

            if (needle[i] == needle[now]) {

                now++
                nextArray[i] = now
                i++

            } else if (now != 0 && needle[i] != needle[now]) {

                now = nextArray[now - 1]

            } else {

                nextArray[i] = 0
                i++

            }

        }


    }


}


fun main() {

    Solution().strStr("leetcode", "leeto")

}