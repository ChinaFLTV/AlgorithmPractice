package day58

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/21 PM 11:14:28
 * @version 1.0.0
 * @description 二叉搜索树中第K小的元素
 * @filename TheKthSmallestElementInABinarySearchTree.kt
 *
 */

/*给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。*/

class Solution {


    private var rank = 0
    private var kthMin = -1


    private fun kthSmallest(root: TreeNode?, k: Int): Int {

        if (rank == k) return kthMin

        if (root == null) return -1

        kthSmallest(root.left, k)

        if (rank < k) {

            rank++
            kthMin = root.`val`

        }

        kthSmallest(root.right, k)

        return kthMin

    }


}