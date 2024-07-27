package interview

import java.util.*

fun main(args: Array<String>) {


    val read = Scanner(System.`in`)
    if (read.hasNextInt()) {

        val distance: Int = read.nextInt()

        val dp = IntArray(distance + 1)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        for (i in 3..distance) {

            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        }

        println(dp[distance])

    }


}



