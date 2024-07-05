package day101

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/5 AM 10:26:04
 * @version 1.0.0
 * @description 颠倒二进制位
 * @filename ReverseBits.kt
 *
 */

/*
颠倒给定的 32 位无符号整数的二进制位。

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/mmmmmy/">mmmmmy</a>
     * @date 2024/7/5 AM 10:35:45
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/reverse-bits/description/comments/860189">位运算</a>
     * @filename ReverseBits.kt
     *
     */
    // you need treat n as an unsigned value
    fun reverseBits_answer_1(n: Int): Int {

        var tempN = n
        var res = 0

        for (i in 0..31) {

            res = res or ((tempN and 1) shl (31 - i))
            tempN = tempN ushr 1

        }

        return res

    }


}