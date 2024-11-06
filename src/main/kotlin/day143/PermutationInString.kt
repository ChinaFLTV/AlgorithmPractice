package day143

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/6 PM 2:55:48
 * @version 1.0.0
 * @description 字符串的排列
 * @filename PermutationInString.kt
 *
 */

/*
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的
排列
。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。



示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false


提示：

1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母*/

class Solution {


    fun checkInclusion(s1: String, s2: String): Boolean {

        var cur = 0

        val s1map = mutableMapOf<Char, Int>()
        for (c in s1.toCharArray()) {

            s1map.compute(c) { _, v ->

                if (v == null) {

                    1

                } else {

                    v + 1

                }

            }

        }

        while (cur < s2.length) {

            if (s1map.contains(s2[cur])) {

                val curLoopStartIdx = cur

                while (cur < s2.length && s1map.contains(s2[cur])) {

                    s1map.compute(s2[cur]) { _, v ->

                        v!! - 1

                    }
                    if (s1map[s2[cur]]!! <= 0)
                        s1map.remove(s2[cur])
                    cur++

                    if (s1map.isEmpty())
                        return true

                }

                s1map.clear()
                for (c in s1.toCharArray()) {

                    s1map.compute(c) { _, v ->

                        if (v == null) {

                            1

                        } else {

                            v + 1

                        }

                    }

                }
                cur = curLoopStartIdx + 1

            } else {

                cur++

            }

        }

        return false

    }


}