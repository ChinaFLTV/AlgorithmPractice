package day135

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/24 PM 1:42:23
 * @version 1.0.0
 * @description 反转字符串
 * @apiNote 题目来源 : https://mp.weixin.qq.com/s/r5EAdx5uogNKBbzkzloXfw
 * @filename ReverseString.kt
 *
 */


fun reverseString(chs: Array<Char>): Array<Char> {

    var left = 0
    var right = chs.size - 1

    while (left < right) {

        val temp = chs[left]
        chs[left] = chs[right]
        chs[right] = temp

        left++
        right--

    }

    return chs

}


fun main() {

    println(String(reverseString("能不能给我一首歌的时间".toCharArray().toTypedArray()).toCharArray()))

}