package day83

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/17 AM 9:49:02
 * @version 1.0.0
 * @description 同构字符串
 * @filename IsomorphicStrings.kt
 *
 */

/*
给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/6/17 AM 10:50:37
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/isomorphic-strings/solutions/1645867/by-jyd-i4wt/?envType=study-plan-v2&envId=top-interview-150">题解</a>
     * @filename IsomorphicStrings.kt
     *
     */
    fun isIsomorphic_answer_1(s: String, t: String): Boolean {

        val map1 = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()

        for (i in s.indices) {

            if (map1.containsKey(s[i])) {

                if (map1[s[i]] != t[i])
                    return false

            } else {

                map1[s[i]] = t[i]

            }

            if (map2.containsKey(t[i])) {

                if (map2[t[i]] != s[i])
                    return false

            } else {

                map2[t[i]] = s[i]

            }

        }

        return true

    }


}