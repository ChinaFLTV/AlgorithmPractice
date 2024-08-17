package day117

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/17 PM 5:46:16
 * @version 1.0.0
 * @description 相同的树
 * @filename SameTree.kt
 *
 */

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。



示例 1：


输入：p = [1,2,3], q = [1,2,3]
输出：true
示例 2：


输入：p = [1,2], q = [1,null,2]
输出：false
示例 3：


输入：p = [1,2,1], q = [1,1,2]
输出：false


提示：

两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/rin-4/">Tohsaka</a>
     * @date 2024/8/17 PM 5:52:08
     * @version 1.0.0
     * @description 兄弟们 第一次不看答案 写出来的递归 鼓励一下啊(https://leetcode.cn/problems/same-tree/description/comments/255783)
     * @filename SameTree.kt
     *
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        if (p == null && q == null)
            return true

        if (p == null || q == null)
            return false

        return if (p.`val` == q.`val`)
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        else
            false

    }


}