package day75

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/8 PM 10:02:16
 * @version 1.0.0
 * @description 反转字符串中的单词
 * @filename ReverseWordsInAString.kt
 *
 */

/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。*/

class Solution {


    private val words = ArrayList<String>()


    fun reverseWords(s: String): String {

        val words = s.split(Regex("\\s+"))
            .filter { it.isNotEmpty() }
            .reversed()
            .toTypedArray()

        return words.joinToString(" ")

    }


    fun reverseWords_answer_1(s: String): String {

        var need = false
        var left = -1
        var right = 0
        val res = StringBuilder("")

        var i = 0
        while (i < s.length) {

            if (s[i] == ' ') {

                if (need) {

                    while (s[i] != ' ') {

                        i++

                    }
                    res.append(' ')
                    --i

                }

            } else {

                if (!need) {

                    need = true

                }

                if (left == null) {

                    left = i

                }


                while (s[i] != ' ') {

                    i++

                }

                --i
                right = i
                swap(s, res, left, right)

            }


        }

        return ""

    }


    private fun swap(s: String, res: StringBuilder, left: Int, right: Int) {

        for (i in right..left) {

            res.append(s[i])

        }

    }


    fun reverseWords_answer_2(s: String): String {

        val res = StringBuilder("")

        var i = s.length - 1
        var shouldAdd = false

        while (i >= 0) {

            if (s[i] != ' ') {

                if (shouldAdd)
                    res.append(' ')

                val right = i
                while (i >= 0 && s[i] != ' ') {

                    i--

                }

                for (j in i + 1..right) {

                    res.append(s[j])

                }

                shouldAdd = true

            } else {

                i--

            }

        }

        return res.toString()

    }


}


fun main() {

    println(Solution().reverseWords_answer_2("the sky is blue"))

}