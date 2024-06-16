package day82

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/16 PM 6:56:04
 * @version 1.0.0
 * @description 赎金信
 * @filename RansomNote.kt
 *
 */

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。*/

class Solution {


    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        if (magazine.length < ransomNote.length)
            return false

        val map = HashMap<Char, Int>()

        for (i in magazine.indices) {

            map.compute(magazine[i]) {

                    _, v ->

                if (v == null)
                    1
                else
                    v + 1

            }

        }


        for (i in ransomNote.indices) {

            if (map.containsKey(ransomNote[i]) && map[ransomNote[i]]!! >= 1) {

                map[ransomNote[i]] = map[ransomNote[i]]!! - 1

            } else {

                return false

            }

        }

        return true

    }


}