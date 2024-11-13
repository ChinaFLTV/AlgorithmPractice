package day149

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/12 PM 3:35:50
 * @version 1.0.0
 * @description 20. 有效的括号
 * @filename ValidParentheses.kt
 *
 */

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"

输出：true

示例 2：

输入：s = "()[]{}"

输出：true

示例 3：

输入：s = "(]"

输出：false

示例 4：

输入：s = "([])"

输出：true



提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成*/

class Solution {


    fun isValid(s: String): Boolean {

        val stack = Stack<Char>()

        for (c in s.toCharArray()) {

            when (c) {

                '(', '[', '{' -> stack.push(c)

                ')' -> {

                    if (!stack.empty() && stack.peek() == '(')
                        stack.pop()
                    else
                        return false

                }

                ']' -> {

                    if (!stack.empty() && stack.peek() == '[')
                        stack.pop()
                    else
                        return false

                }

                '}' -> {

                    if (!stack.empty() && stack.peek() == '{')
                        stack.pop()
                    else
                        return false

                }

            }

        }

        return stack.isEmpty()

    }


}


fun main() {

    println(Solution().isValid("()[]{}"))

}