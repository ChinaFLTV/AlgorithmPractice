package interview

import kotlin.random.Random

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/8 PM 4:24:43
 * @version 1.0.0
 * @description
 * @filename Xiaomi_1.kt
 *
 */

class Obj(val idx: Int, val weight: Int)

val random = Random(666)

fun generateIndex(objs: List<Obj>): Int {

    var totalWeight = 0
    for (obj in objs) {

        totalWeight += obj.weight

    }

    val randomNum = random.nextInt(0, totalWeight)

    var curWeight = 0
    for (obj in objs) {

        curWeight += obj.weight

        if (curWeight > randomNum) {

            return obj.idx

        }

    }

    return -1


}