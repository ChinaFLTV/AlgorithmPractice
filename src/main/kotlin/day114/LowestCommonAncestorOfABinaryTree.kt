package day114

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/14 PM 3:26:17
 * @version 1.0.0
 * @description 二叉树的最近公共祖先
 * @filename LowestCommonAncestorOfABinaryTree.kt
 *
 */

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
示例 2：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1*/

class Solution2 {


    /**
     *
     * @author <a href="https://leetcode.cn/u/bing-bao-zhi-hai-zi-pu-tao/">冰暴之海紫葡萄</a>
     * @date 2024/8/14 PM 3:30:42
     * @version 1.0.0
     * @description 看了不少教程，都是在介绍晦涩的递归和回溯概念，对小白很不友好。其实按照解决思路写写下来，自然就完成了。(https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/comments/2257221)
     * @filename LowestCommonAncestorOfABinaryTree.kt
     *
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null || root == p || root == q)
            return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left == null)
            return right

        if (right == null)
            return left

        return root

    }


}