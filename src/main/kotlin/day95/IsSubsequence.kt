package day95

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/29 PM 4:17:12
 * @version 1.0.0
 * @description 判断子序列
 * @filename IsSubsequence.kt
 *
 */

/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

致谢：

特别感谢 @pbrother 添加此问题并且创建所有测试用例。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/6/29 PM 4:52:05
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/is-subsequence/solutions/1658262/by-jyd-zeph/?envType=study-plan-v2&envId=top-interview-150">题解</a>
     * @filename IsSubsequence.kt
     *
     */
    fun isSubsequence_answer_1(s: String, t: String): Boolean {

        if (s.isBlank())
            return true

        var p1 = 0
        var p2 = 0

        while (p1 < s.length && p2 < t.length) {

            if (s[p1] == t[p2]) {

                p1++
                p2++

            } else {

                p2++

            }

            if (p1 == s.length)
                return true

        }

        return false

    }


}