package day17

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/7 下午 11:08:56
 * @version 1.0.0
 * @description 交错字符串
 * @filename InterleaveString.kt
 *
 */

/*
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空
子字符串
：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
注意：a + b 意味着字符串 a 和 b 连接。*/

class Solution {


    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        if ((s1.length + s2.length) != s3.length) return false

        if (s1 == s3 || s2 == s3) return true

        val dp = Array(s1.length + 1) {

            BooleanArray(s2.length + 1) { false }

        }

        for (x in 0..s2.length){


        }

        for (y in 1..s1.length) {

            for (x in 1..s2.length) {

                /*if (s1[y] == s3[]) {

                    dp[y][x] = dp[y - 1][x]

                } else if (s2[x] == s3[]) {


                } else {

                    return false

                }*/

            }

        }

        return dp[s1.length][s2.length]

    }


}