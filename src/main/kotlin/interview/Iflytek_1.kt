package interview

import java.util.*

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/8/3 19:50
 * @version 1.0.0
 * @description 科大讯飞-笔试1-牛牛工作问题
 * @filename Iflytek_1.kt
 *
 */


fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    if (scanner.hasNext()) {

        var count = scanner.nextInt()

        while (scanner.hasNextLine()) {

            val input = scanner.nextLine()
            if (input.trim() == "")
                continue

            val data = input.split(" ")
            val A = data[0].toInt()
            val B = data[1].toInt()

            println(B + A * B)
            count--

            if (count == 0)
                return

        }

    }

}