package day134

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/22 PM 3:16:47
 * @version 1.0.0
 * @description 循环顺序执行三个线程的题，输出ABCABCABCABC…
 * @apiNote 方案来源 : https://mp.weixin.qq.com/s/K999rPqL4TOe6kSIDd86QA
 * @filename ExecuteThreeThreadsInALoopSequence.kt
 *
 */

val lock = Object()
var count = 1

fun main() {


    val printer1 = Thread(CharPrinter('A', 1))
    val printer2 = Thread(CharPrinter('B', 2))
    val printer3 = Thread(CharPrinter('C', 3))

    printer1.start()
    printer2.start()
    printer3.start()

}


class CharPrinter(private val ch: Char, private val order: Int) : Runnable {


    override fun run() {

        for (i in 1..10) {

            synchronized(lock) {

                while (count != order)
                    lock.wait()

                println(ch)
                count++

                if (count > 3) {

                    count = 1

                }

                lock.notifyAll()

            }

        }

    }


}