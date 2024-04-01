package day10

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/31 下午 10:20:07
 * @version 1.0.0
 * @description 单词拆分
 * @filename WordSplitting.kt
 *
 */

/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。*/

class Solution {


    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val words = wordDict.toSet()


        val dp: Array<Boolean> = Array(s.length + 1) { false }

        dp[0] = true

        for (i in 1..s.length) {

            for (j in 1..<i) {

                if (words.contains(s.subSequence(j, i + 1)) && dp[j - 1]) {



                }

            }

        }

        return dp[wordDict.size - 1]

    }


}