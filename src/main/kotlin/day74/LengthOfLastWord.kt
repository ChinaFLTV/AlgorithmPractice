package day74

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/6/7 19:36
 * @version 1.0.0
 * @description 最后一个单词的长度
 * @filename LengthOfLastWord.kt
 *
 */

/*
给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大
子字符串
。*/

class Solution {


    fun lengthOfLastWord(s: String): Int {

        return s.split(Regex("\\s+")).last { it.isNotEmpty() }.length

    }


    fun lengthOfLastWord_answer_1(s: String): Int {

        var isMatching = false
        var count = 0

        for (i in s.length - 1 downTo 0) {

            if (s[i] != ' ') {

                if (!isMatching)
                    isMatching = true
                count++

            } else {

                if (isMatching)
                    return count

            }

        }

        return count

    }


}


fun main() {

    println(Solution().lengthOfLastWord("luffy is still joyboy"))

}