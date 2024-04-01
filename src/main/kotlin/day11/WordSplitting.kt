package day11

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/1 下午 10:33:04
 * @version 1.0.0
 * @description 单词拆分
 * @filename WordSplitting.kt
 *
 */

/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。*/

class Solution {


    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val dp = Array(s.length + 1) { false }
        dp[0] = true

        val wordSet = wordDict.toSet()

        for (i in s.indices) {

            for (j in i downTo 0 step 1) {

                if (wordSet.contains(s.substring(j, i + 1)) && dp[j]) {

                    dp[i + 1] = true
                    break

                }

            }

        }

        return dp[s.length]

    }

}