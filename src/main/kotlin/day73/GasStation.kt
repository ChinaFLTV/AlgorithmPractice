package day73

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/6 PM 7:13:20
 * @version 1.0.0
 * @description 加油站
 * @filename GasStation.kt
 *
 */

/*
在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。*/

class Solution {


    /*fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        if (gas.size == 1)
            return 0

        val netGas = IntArray(gas.size)
        var start = -1

        for (i in gas.indices) {

            netGas[i] = gas[i] - cost[i]
            if (start == -1 && netGas[i] > 0) {

                start = i

            }

        }

        if (start == -1)
            return -1
        else {

            var count = 0
            var curGas = 0
            var temp = start

            while (count < gas.size) {

                curGas += netGas[temp]
                count++
                temp = (++temp) % 7

                if ((curGas == 0 && count != gas.size) || (curGas < 0))
                    return -1

            }

        }

        return start

    }*/


    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var totalNetSum = 0
        var curNetSum = 0
        var start = 0

        for (i in gas.indices) {

            totalNetSum += (gas[i] - cost[i])
            curNetSum += (gas[i] - cost[i])

            if (curNetSum < 0) {

                start = (i + 1) % gas.size
                curNetSum = 0

            }

        }


        if (totalNetSum < 0)
            return -1

        return start

    }


}