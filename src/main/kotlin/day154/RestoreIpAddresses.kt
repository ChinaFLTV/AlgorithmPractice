package day154

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/18 PM 12:00:23
 * @version 1.0.0
 * @description 93. 复原 IP 地址
 * @filename RestoreIpAddresses.kt
 *
 */

/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

1 <= s.length <= 20
s 仅由数字组成*/

class Solution {


    private val res = mutableListOf<String>()


    /**
     *
     * @author <a href="https://leetcode.cn/u/liweiwei1419/">liweiwei1419</a>
     * @date 2024/11/18 PM 1:42:31
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/restore-ip-addresses/solutions/100433/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/">回溯算法（画图分析剪枝条件）</a>
     * @filename RestoreIpAddresses.kt
     *
     */
    fun restoreIpAddresses(s: String): List<String> {

        if (s.length < 4 || s.length > 12)
            return res

        dfs(s, 0, 4, mutableListOf())
        return res

    }


    private fun dfs(s: String, start: Int, residue: Int, subRes: MutableList<String>) {

        if (start == s.length) {

            if (residue == 0) {

                res.add(subRes.joinToString("."))

            }
            return

        }

        for (i in start..start + 2) {

            if (i >= s.length)
                break

            if (residue * 3 < s.length - i)
                continue

            if (isIpSegment(s, start, i)) {

                subRes.add(s.substring(start, i + 1))
                dfs(s, i + 1, residue - 1, subRes)
                subRes.removeLast()

            }

        }

    }


    private fun isIpSegment(s: String, start: Int, end: Int): Boolean {

        val len = end - start + 1

        if (len > 1 && s[start] == '0')
            return false

        var num = 0

        for (i in start..end) {

            num = num * 10 + (s[i].digitToInt())

        }

        return num in 0..255

    }


}