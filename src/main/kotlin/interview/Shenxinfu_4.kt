package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/18 PM 8:12:59
 * @version 1.0.0
 * @description 深信服-笔试-4-请你来设计一个算法来快速完成访问关系的策略匹配
 * @filename Shenxinfu_4.kt
 *
 */

import java.util.*
import kotlin.math.pow

fun mapStringToLong(ip: String): Long {

    val ipSegments = ip.split(".").map { it.toInt() }.toIntArray()

    var res = 0L
    for (i in ipSegments.size - 1 downTo 0) {

        res += (ipSegments[i] * 10.0.pow(ipSegments.size - 1 - i).toLong())

    }

    return res

}


class Strategy {


    val srcIP: LongArray = longArrayOf(0L, 0L)
    val srcPort: IntArray = intArrayOf(0, 0)
    val destIP: LongArray = longArrayOf(0L, 0L)
    val destPort: IntArray = intArrayOf(0, 0)
    var protocol: Int = 0


    constructor(srcIpStr: String, srcPortStr: String, destIpStr: String, destPortStr: String, protocolStr: String) {

        if (srcIpStr.contains('-')) {

            this.srcIP[0] = mapStringToLong(srcIpStr.split("-")[0])
            this.srcIP[1] = mapStringToLong(srcIpStr.split("-")[1])

        } else {

            this.srcIP[0] = mapStringToLong(srcIpStr)

        }


    }


}

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val input1 = scanner.nextLine()
    val strategyNum = input1.split(" ")[0].toInt()
    val sampleNum = input1.split(" ")[1].toInt()

    for (i in 0..<strategyNum) {


    }

}