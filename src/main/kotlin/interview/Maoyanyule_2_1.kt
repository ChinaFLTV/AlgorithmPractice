package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/23 PM 3:11:54
 * @version 1.0.0
 * @description 猫眼娱乐-面试-2
 * @filename Maoyanyule_2_1.kt
 *
 */

class Maoyanyule_2_1 {


    fun findFirstDistinctCharacter(str: String): Int {

        val map = mutableMapOf<Char, Int>()
        val map2 = mutableMapOf<Char, Int>()


        for (i in str.indices) {

            var oldTimes = map.getOrDefault(str[i], 0)
            map[str[i]] = ++oldTimes
            map2[str[i]] = i

        }

        for (entry in map.entries) {

            if (entry.value == 1)
                return map2[entry.key]!!

        }

        return -1

    }


}


fun main() {

    println(Maoyanyule_2_1().findFirstDistinctCharacter("abcdafg"))

}