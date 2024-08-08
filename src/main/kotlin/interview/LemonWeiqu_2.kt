package interview

import java.util.*

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/8/6 18:18
 * @version 1.0.0
 * @description 柠檬微趣-笔试-2-实现简单的正则表达式匹配
 * @filename LemonWeiqu_2.kt
 *
 */


fun main() {

    val scanner = Scanner(System.`in`)


    if (scanner.hasNext()) {

        var count = scanner.nextInt()

        while (scanner.hasNextLine()) {


            val input = scanner.nextLine()

            if (input.trim() == "")
                continue

            val testStr = input.split(" ")[0]
            val patternStr = input.split(" ")[1]

            println(Regex(patternStr).matches(testStr))

            count--

            if (count == 0)
                return

        }

    }

}