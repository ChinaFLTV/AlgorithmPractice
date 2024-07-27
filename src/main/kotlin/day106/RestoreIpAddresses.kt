package day106

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/24 14:28
 * @version 1.0.0
 * @description 复原IP地址
 * @filename RestoreIpAddresses.kt
 *
 */

/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。*/

class Solution {


    private val res: MutableList<String> = mutableListOf()


    private fun isValid(s: String, startIndex: Int, endIndex: Int): Boolean {

        if (endIndex < startIndex || endIndex - startIndex + 1 > 3)
            return false

        val ipSeg = s.substring(startIndex, endIndex + 1)

        val ipSegInt = ipSeg.toInt()

        return (!ipSeg.startsWith("0") && ipSegInt in 1..255) || ipSeg == "0"

    }



    /**
     *
     * @author <a href="https://space.bilibili.com/525438321?spm_id_from=333.337.search-card.all.click">代码随想录</a>
     * @date 2024/7/24 16:03
     * @version 1.0.0
     * @description <a href="https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0093.%E5%A4%8D%E5%8E%9FIP%E5%9C%B0%E5%9D%80.md">题解</a>
     * @filename RestoreIpAddresses.kt
     *
     */
    fun restoreIpAddresses(s: String): List<String> {

        val builder = StringBuilder(s)
        backtrack(builder, 0, 0)
        return res

    }


    private fun backtrack(builder: StringBuilder, startIndex: Int, dotCount: Int) {

        if (dotCount == 3) {

            if (isValid(builder.toString(), startIndex, builder.length - 1)) {

                res.add(builder.toString())

            }

            return

        }


        for (i in startIndex..<builder.length) {

            if (isValid(builder.toString(), startIndex, i)) {

                builder.insert(i + 1, ".")
                backtrack(builder, i + 2, dotCount + 1)
                builder.deleteCharAt(i + 1)

            } else {

                break

            }

        }

    }


}


fun main() {

    val ipAddresses = Solution().restoreIpAddresses("25525511135")
    for (ip in ipAddresses)
        println(ip)

}