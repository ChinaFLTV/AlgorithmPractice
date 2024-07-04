package day100

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/4 AM 10:03:16
 * @version 1.0.0
 * @description 二进制求和
 * @filename AddBinary.kt
 *
 */

/*给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。*/

class Solution {


    fun addBinary(a: String, b: String): String {

        var tempA = a
        var tempB = b

        if (a.length > b.length) {

            tempB = b.padStart(a.length, '0')

        } else {

            tempA = a.padStart(b.length, '0')

        }

        var isCarryBit = false

        var res = ""

        for (i in tempA.length - 1 downTo 0) {

            val curABit = Character.getNumericValue(tempA[i])
            val curBBit = Character.getNumericValue(tempB[i])

            val carryBit = if (isCarryBit) 1 else 0
            val curBit = curABit xor curBBit xor carryBit
            val curSum = curABit + curBBit + carryBit

            res = "$curBit$res"
            isCarryBit = curSum >= 2

        }

        if (isCarryBit)
            res = "1$res"

        return res

    }


}


fun main() {

    Solution().addBinary("11", "1")

}