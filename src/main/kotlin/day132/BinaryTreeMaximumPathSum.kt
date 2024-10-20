package day132

import day38.TreeNode
import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/20 PM 3:02:24
 * @version 1.0.0
 * @description 二叉树中的最大路径和
 * @filename BinaryTreeMaximumPathSum.kt
 *
 */

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。



示例 1：


输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：


输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42


提示：

树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000*/

class Solution {


    private var maxPathSum = Int.MIN_VALUE


    /**
     *
     * @author <a href="https://leetcode.cn/u/cheney-2/">cheney</a>
     * @date 2024/10/20 PM 4:02:34
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/18040/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/comments/313184">思路一致，但是感觉我的注释更好理解~</a>
     * @filename BinaryTreeMaximumPathSum.kt
     *
     */
    fun maxPathSum(root: TreeNode?): Int {

        if (root == null)
            return 0

        dfs(root)

        return maxPathSum

    }


    private fun dfs(node: TreeNode?): Int {

        if (node == null)
            return 0

        val leftMaxPathSum = max(0, dfs(node.left))
        val rightMaxPathSum = max(0, dfs(node.right))

        maxPathSum = max(maxPathSum, leftMaxPathSum + node.`val` + rightMaxPathSum)

        return node.`val` + max(leftMaxPathSum, rightMaxPathSum)

    }


}