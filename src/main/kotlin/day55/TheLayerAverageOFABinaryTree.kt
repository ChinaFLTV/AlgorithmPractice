package day55

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/18 PM 5:03:34
 * @version 1.0.0
 * @description 二叉树的层平均值
 * @filename TheLayerAverageOFABinaryTree.kt
 *
 */

/*
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。*/


class Solution2 {


    private val list = ArrayList<Double>()
    private val deque = ArrayDeque<TreeNode>()
    private var count = 0


    fun averageOfLevels(root: TreeNode?): DoubleArray {

        if (root == null) return DoubleArray(0)

        deque.addLast(root)
        count = 1

        while (count > 0) {

            var tempCount = 0
            var sum = 0.0

            for (i in 1..count) {

                val parent = deque.removeFirst()
                parent.left?.run {

                    deque.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    deque.addLast(this)
                    tempCount++

                }

                sum += parent.`val`

            }

            list.add(sum / count)

            count = tempCount

        }

        return list.toDoubleArray()

    }


}
