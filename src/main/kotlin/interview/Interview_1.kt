package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/16 PM 2:42:03
 * @version 1.0.0
 * @description 微派网络-面试1-1-翻转数字
 * @filename Interview_1.kt
 *
 */

fun invertInt(num: Int): Int {

    try {

        var tempNum = num
        var reversedNum = 0


        while (tempNum > 0) {

            val bitNum = tempNum % 10
            reversedNum = reversedNum * 10 + bitNum
            tempNum /= 10

        }

        return reversedNum

    } catch (e: Exception) {

        throw Exception("数字溢出")

    }


}


fun main() {

    println("开始测试")
    println(invertInt(1234))

}