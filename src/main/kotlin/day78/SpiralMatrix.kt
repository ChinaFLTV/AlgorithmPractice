package day78

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/12 PM 7:13:00
 * @version 1.0.0
 * @description 螺旋矩阵
 * @filename SpiralMatrix.kt
 *
 */

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。*/

class Solution {


    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val width = matrix[0].size
        val height = matrix.size

        var i = 0
        var curX = 0
        var curY = 0
        var direction = Direction.RIGHT

        val res = ArrayList<Int>(width * height)
        res.add(matrix[0][0])
        matrix[0][0] = -101

        while (res.size < width * height) {

            when (direction) {

                Direction.RIGHT -> {

                    if (curX + 1 < width && matrix[curY][curX + 1] != -101) {

                        i++
                        curX++
                        res.add(matrix[curY][curX])
                        matrix[curY][curX] = -101

                    } else {

                        direction = Direction.DOWN

                    }

                }

                Direction.DOWN -> {

                    if (curY + 1 < height && matrix[curY + 1][curX] != -101) {

                        i++
                        curY++
                        res.add(matrix[curY][curX])
                        matrix[curY][curX] = -101

                    } else {

                        direction = Direction.LEFT

                    }

                }

                Direction.LEFT -> {

                    if (curX - 1 >= 0 && matrix[curY][curX - 1] != -101) {

                        i++
                        curX--
                        res.add(matrix[curY][curX])
                        matrix[curY][curX] = -101

                    } else {

                        direction = Direction.UP

                    }

                }

                Direction.UP -> {

                    if (curY - 1 >= 0 && matrix[curY - 1][curX] != -101) {

                        i++
                        curY--
                        res.add(matrix[curY][curX])
                        matrix[curY][curX] = -101

                    } else {

                        direction = Direction.RIGHT

                    }

                }

            }

        }

        return res

    }


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/6/12 PM 8:28:02
     * @version 1.0.0
     * @description <a href="https://www.bilibili.com/video/BV1Bb4y1x7xX/?spm_id_from=333.337.search-card.all.click&vd_source=a679f9412ce63c7b14f8f881b2ff6fc2">模拟法</a>
     * @filename SpiralMatrix.kt
     *
     */
    fun spiralOrder_answer_1(matrix: Array<IntArray>): List<Int> {

        val width = matrix[0].size
        val height = matrix.size

        var left = 0
        var right = width - 1
        var top = 0
        var bottom = height - 1

        val res = ArrayList<Int>(width * height)

        while (true) {

            for (i in left..right) {

                res.add(matrix[top][i])

            }
            if (++top > bottom)
                break

            for (i in top..bottom) {

                res.add(matrix[i][right])

            }
            if (--right < left)
                break

            for (i in right downTo left) {

                res.add(matrix[bottom][i])

            }
            if (--bottom < top)
                break

            for (i in bottom downTo top) {

                res.add(matrix[i][left])

            }
            if (++left > right)
                break

        }

        return res

    }


}


enum class Direction {

    RIGHT, DOWN, LEFT, UP

}


fun main() {

    val matrix = Array<IntArray>(3) {

        when (it) {

            0 -> intArrayOf(1, 2, 3)
            1 -> intArrayOf(4, 5, 6)
            2 -> intArrayOf(7, 8, 9)
            else -> intArrayOf()

        }

    }

    Solution().spiralOrder(matrix)

}