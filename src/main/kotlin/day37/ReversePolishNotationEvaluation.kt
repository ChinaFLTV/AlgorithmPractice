package day37

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/27 PM 9:58:17
 * @version 1.0.0
 * @description
 * @filename ReversePolishNotationEvaluation.kt
 *
 */

/*
给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

请你计算该表达式。返回一个表示表达式值的整数。

注意：

有效的算符为 '+'、'-'、'*' 和 '/' 。
每个操作数（运算对象）都可以是一个整数或者另一个表达式。
两个整数之间的除法总是 向零截断 。
表达式中不含除零运算。
输入是一个根据逆波兰表示法表示的算术表达式。
答案及所有中间计算结果可以用 32 位 整数表示。*/

class Solution {


    fun evalRPN(tokens: Array<String>): Int {

        if (tokens.size == 1) {

            return tokens[0].toInt()

        }

        val stack = ArrayDeque<Int>()

        for (token in tokens) {

            when (token) {

                "+" -> stack.addLast(stack.removeLast() + stack.removeLast())
                "-" -> stack.addLast(-stack.removeLast() + stack.removeLast())
                "*" -> stack.addLast(stack.removeLast() * stack.removeLast())
                // "/" -> stack.addLast(1 / (stack.removeLast() / stack.removeLast()))
                "/" -> {

                    val second = stack.removeLast()
                    val first = stack.removeLast()

                    stack.addLast(first / second)

                }

                else -> stack.addLast(token.toInt())

            }

        }

        return stack.removeLast()

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/27 PM 10:28:17
     * @version 1.0.0
     * @param tokens 中缀表达式，如 ["3","+","4","*","5"] --> 345*+
     * @description 自己附加的题(生成逆波兰表达式)
     * @filename ReversePolishNotationEvaluation.kt
     *
     */
    fun generateRPN(tokens: Array<String>): Array<String> {

        // TODO...
        return Array<String>(6) { _ -> "" }

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/27 PM 10:54:33
     * @version 1.0.0
     * @description 计算中缀表达式
     * @filename ReversePolishNotationEvaluation.kt
     *
     */
    fun evalInfixExpression(tokens: Array<String>): Int {

        if (tokens.size == 1) {

            return tokens[0].toInt()

        }

        val numStack = ArrayDeque<Int>()
        val operatorStack = ArrayDeque<String>()

        fun eval(type: String, num1: Int, num2: Int): Int {

            return when (type) {

                "+" -> num2 + num1
                "-" -> num2 - num1
                "*" -> num2 * num1
                "/" -> num2 / num1
                else -> -1

            }

        }

        for (token in tokens) {

            when (token.trim()) {

                "+", "-", "*", "/" -> operatorStack.addLast(token)
                "(" -> {}
                ")" -> numStack.addLast(eval(operatorStack.removeLast(), numStack.removeLast(), numStack.removeLast()))
                else -> numStack.addLast(token.toInt())

            }

        }

        return eval(operatorStack.removeLast(), numStack.removeLast(), numStack.removeLast())

    }


}


fun main() {

    val infixExpression = arrayOf("(", "4", "+", "2", ")", "*", "8")
    val result1 = Solution().evalInfixExpression(infixExpression)
    println(result1)

}