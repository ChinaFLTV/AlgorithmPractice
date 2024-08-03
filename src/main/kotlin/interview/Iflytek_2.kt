package interview

import java.util.*

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/8/3 20:03
 * @version 1.0.0
 * @description 科大讯飞-笔试2-东八区，协调时间
 * @filename Iflytek_2.kt
 *
 */

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    if (scanner.hasNext()) {

        var count = scanner.nextInt()

        while (scanner.hasNext()) {


            val input = scanner.nextLine()

            if (input.trim() == "")
                continue

            val hour = input.split(":")[0].toInt()
            val minute = input.split(":")[1]

            val standardHour = (hour + 24 - 8) % 24

            val standardHourStr = standardHour.toString().padStart(2, '0')

            println("$standardHourStr:$minute")

            count--

            if (count == 0)
                return

        }

    }

}