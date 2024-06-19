package day85

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/19 PM 6:44:49
 * @version 1.0.0
 * @description 有效的字母异位词
 * @filename ValidAnagram.kt
 *
 */

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。*/

class Solution {


    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length)
            return false

        val map = mutableMapOf<Char, Int>()

        for (c in s) {

            map.compute(c) {

                    _, v ->

                if (v != null) {

                    v + 1

                } else {

                    1

                }

            }

        }


        for (c in t) {

            if (!map.containsKey(c))
                return false

            map[c] = map[c]!! - 1

        }

        // return map.filter { it.value != 0 }.isEmpty()
        return !map.any { it.value != 0 }

    }


}