package day86

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/20 PM 6:39:38
 * @version 1.0.0
 * @description 字母异位词分组
 * @filename GroupAnagrams.kt
 *
 */

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。*/

class Solution {


    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val res = mutableListOf<List<String>>()
        val map = mutableMapOf<String, ArrayList<String>>()

        for (str in strs) {

            val sortedStr = sortStr(str)
            if (map.containsKey(sortedStr)) {

                map[sortedStr]!!.add(str)

            } else {

                map[sortedStr] = ArrayList()
                map[sortedStr]!!.add(str)

            }

        }

        for (entry in map.entries) {

            res.add(entry.value)

        }

        return res

    }


    private fun sortStr(str: String): String {

        val res = str.toCharArray()
        Arrays.sort(res)
        return String(res)

    }


}