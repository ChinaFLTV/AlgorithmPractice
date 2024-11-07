package day144

import day38.TreeNode


/**
 * @author Lenovo/LiGuanda
 * @date 2024/11/7 PM 1:47:42
 * @version 1.0.0
 * @description 二叉树的层序遍历
 * @filename BinaryTreeLevelOrderTraversal.java
 */

/*给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]


提示：

树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000*/

class Solution2 {


    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null)
            return arrayListOf()

        val res = arrayListOf<List<Int>>()

        val deque = ArrayDeque<TreeNode>()
        deque.addLast(root)
        var count = 1

        while (count > 0) {

            var tempCount = 0
            val subRes = arrayListOf<Int>()

            for (i in 1..count) {

                val curNode = deque.removeFirst()
                subRes.add(curNode.`val`)
                curNode.left?.let {

                    deque.addLast(it)
                    tempCount++

                }
                curNode.right?.let {

                    deque.addLast(it)
                    tempCount++

                }

            }

            count = tempCount
            res.add(subRes)

        }

        return res

    }


}