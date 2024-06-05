package day56

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/19 PM 5:44:21
 * @version 1.0.0
 * @description 二叉树的锯齿形层序遍历
 * @filename SawtoothSequenceTraversalOfBinaryTrees.kt
 *
 */

/*
给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。*/

class Solution {


    private var isForward = true
    private val deque = ArrayDeque<TreeNode>()
    private var count = 0
    private val list = ArrayList<List<Int>>()


    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) return list

        deque.addLast(root)
        count = 1

        while (count > 0) {

            var tempCount = 0
            val subList = ArrayList<Int>()


            /*for (i in 1..count) {

                val parent = deque.removeFirst()
                parent.left?.run {

                    deque.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    deque.addLast(this)
                    tempCount++

                }
                subList.add(parent.`val`)

            }

            if (isForward)
                list.add(subList)
            else {

                subList.reverse()
                list.add(subList)

            }*/

            if (isForward) {

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
                    subList.add(parent.`val`)

                }

            } else {

                for (i in 1..count) {

                    val parent = deque.removeLast()
                    parent.right?.run {

                        deque.addFirst(this)
                        tempCount++

                    }
                    parent.left?.run {

                        deque.addFirst(this)
                        tempCount++

                    }
                    subList.add(parent.`val`)

                }

            }

            list.add(subList)

            isForward = !isForward
            count = tempCount

        }

        return list

    }


}