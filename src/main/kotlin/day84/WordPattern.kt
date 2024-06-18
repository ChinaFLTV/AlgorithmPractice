package day84

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/18 AM 10:10:07
 * @version 1.0.0
 * @description 单词规律
 * @filename WordPattern.kt
 *
 */

/*
给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。*/

class Solution {


    fun wordPattern(pattern: String, s: String): Boolean {

        val words = s.split(' ')
            .filter {

                it.isNotEmpty()

            }

        if (pattern.length != words.size)
            return false

        val map1 = mutableMapOf<Char, String>()
        val map2 = mutableMapOf<String, Char>()

        for (i in words.indices) {

            if (map1.containsKey(pattern[i])) {

                if (map1[pattern[i]] != words[i])
                    return false

            } else {

                map1[pattern[i]] = words[i]

            }

            if (map2.containsKey(words[i])) {

                if (map2[words[i]] != pattern[i])
                    return false

            } else {

                map2[words[i]] = pattern[i]

            }

        }

        return true

    }


}