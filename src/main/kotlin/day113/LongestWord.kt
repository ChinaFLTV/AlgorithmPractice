package day113

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/13 PM 1:58:18
 * @version 1.0.0
 * @description 最长单词
 * @filename LongestWord.kt
 *
 */

/*
给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。

示例：

输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
输出： "dogwalker"
解释： "dogwalker"可由"dog"和"walker"组成。
提示：

0 <= len(words) <= 200
1 <= len(words[i]) <= 100*/

class Solution {


    private lateinit var set: MutableSet<String>


    /**
     *
     * @author <a href="https://leetcode.cn/u/a-fei-8/">阿飞</a>
     * @date 2024/8/13 PM 2:51:15
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-word-lcci/solutions/811199/a-fei-suan-fa-mian-shi-ti-1715-zui-chang-c3vr/">【阿飞算法】面试题 17.15. 最长单词（回溯/动态规划/字典树）</a>
     * @filename LongestWord.kt
     *
     */
    fun longestWord(words: Array<String>): String {

        set = mutableSetOf(*words)

        words.sortWith(compareByDescending<String> { it.length }.thenBy { it })

        for (word in words) {

            set.remove(word)
            if (dfs(word, 0))
                return word
            set.add(word)

        }

        return ""

    }


    private fun dfs(word: String, start: Int): Boolean {

        if (start == word.length)
            return true

        for (i in start..<word.length) {

            val left = word.substring(start, i + 1)

            if (set.contains(left) && dfs(word, i + 1))
                return true

        }

        return false

    }


}
