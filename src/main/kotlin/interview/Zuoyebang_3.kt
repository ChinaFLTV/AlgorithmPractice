package interview

import java.util.*

fun main(args: Array<String>) {

    val read = Scanner(System.`in`)
    if (read.hasNextLine()) {

        var ipStr: String = read.nextLine()

        if (ipStr.length < 4 || ipStr.length > 9)
            println(emptyArray<String>())

        val ipInt = ipStr.toInt()

    }

}