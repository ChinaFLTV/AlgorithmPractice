package day57

import day38.TreeNode
import kotlin.math.abs

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/20 PM 10:48:08
 * @version 1.0.0
 * @description 二叉搜索树的最小绝对差
 * @filename MinimumAbsoluteDifferenceOfBinarySearchTree.kt
 *
 */

/*给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。*/

class Solution {


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/5/20 PM 11:15:21
     * @version 1.0.0
     * @description 只考虑了相邻节点的差值。。。
     * @filename MinimumAbsoluteDifferenceOfBinarySearchTree.kt
     *
     */
    /*fun getMinimumDifference(root: TreeNode?): Int {

        if (root == null) return Int.MAX_VALUE

        val leftDiff = if (root.left != null) abs(root.`val` - root.left!!.`val`) else Int.MAX_VALUE
        val rightDiff = if (root.right != null) abs(root.`val` - root.right!!.`val`) else Int.MAX_VALUE

        val leftSubDiff = getMinimumDifference(root.left)
        val rightSubDiff = getMinimumDifference(root.right)

        return minOf(leftDiff, rightDiff, leftSubDiff, rightSubDiff)

    }*/


    private val list = ArrayList<Int>()


    fun getMinimumDifference(root: TreeNode?): Int {

        traversal(root)

        var minDiff = list[1] - list[0]

        for (i in 2..<list.size) {

            minDiff = minOf(minDiff, abs(list[i] - list[i - 1]))

        }

        return minDiff

    }


    private fun traversal(root: TreeNode?) {

        if (root == null) return

        traversal(root.left)
        list.add(root.`val`)
        traversal(root.right)

    }


    private var prevNum = -1
    private var minDiff = Int.MAX_VALUE


    /**
    *
    * @author <a href="https://leetcode.cn/u/wjw66/">wjw66</a>
    * @date 2024/5/21 AM 12:00:25
    * @version 1.0.0
    * @description 中序遍历+记录前一个节点值
    * @filename MinimumAbsoluteDifferenceOfBinarySearchTree.kt
    *
    */
    private fun getMinimumDifference_answer_1(root: TreeNode?): Int {

        if (root == null) return -1
        getMinimumDifference_answer_1(root.left)

        if (prevNum != -1) minDiff = minOf(minDiff, root.`val` - prevNum)
        prevNum = root.`val`

        getMinimumDifference_answer_1(root.right)

        return minDiff

    }


}