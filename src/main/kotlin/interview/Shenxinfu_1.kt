package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/18 PM 7:07:24
 * @version 1.0.0
 * @description 深信服-笔试-1-一条路上依次排着N个七色豆，七种颜色分别用字符abcdefg表示。一个机器小人沿着这条路往前捡豆豆
 * @filename Shenxinfu_1.kt
 *
 */

import java.util.*

var count = 0
lateinit var beans: String
lateinit var directives: String

fun main() {

    val scanner = Scanner(System.`in`)
    beans = scanner.nextLine().trim()
    directives = scanner.nextLine().trim()

    action(0, 0)

    println(count)

}


fun action(beanIdx: Int, directiveIdx: Int) {

    if (beanIdx >= beans.length || directiveIdx >= directives.length)
        return

    val bean = beans[beanIdx]
    val directiveBean = directives[directiveIdx]

    if (directiveBean == '*') {

        val prevDirectiveBean = if (directiveIdx == 0) 'h' else directives[directiveIdx - 1]
        var curBean = bean
        var delta = 0

        while (curBean == prevDirectiveBean) {

            count++
            delta++

            if (beanIdx + delta >= beans.length)
                return

            curBean = beans[beanIdx + delta]

        }

        action(beanIdx + delta, directiveIdx + 1)

    } else {

        if (bean == directiveBean) {

            count++
            action(beanIdx + 1, directiveIdx + 1)

        } else {

            action(beanIdx, directiveIdx + 1)

        }

    }

}
