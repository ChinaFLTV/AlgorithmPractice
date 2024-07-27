package day106

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/24 16:21
 * @version 1.0.0
 * @description 实现 Trie (前缀树)
 * @filename ImplementTriePrefixTree.kt
 *
 */

/*
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。*/

/**
 *
 * @author <a href="https://leetcode.cn/u/monstersamarua/">Samarua</s>
 * @date 2024/7/24 16:51
 * @version 1.0.0
 * @description <a href="https://blog.csdn.net/m0_46202073/article/details/107253959">模板+变式——带你彻底搞懂字典树(Trie树)</a>
 * @filename ImplementTriePrefixTree.kt
 *
 */
class Trie {


    private val root = TreeNode()


    fun insert(word: String) {

        internalInsert(word, root, 0)

    }


    private fun internalInsert(word: String, parent: TreeNode, pos: Int) {

        val idx = word[pos] - 'a'

        if (pos == word.length - 1) {

            if (parent.childs[idx] == null) {

                parent.childs[idx] = TreeNode()

            }
            parent.childs[idx]!!.isPresent = true
            return

        }

        if (parent.childs[idx] == null)
            parent.childs[idx] = TreeNode()

        internalInsert(word, parent.childs[idx]!!, pos + 1)

    }


    fun search(word: String): Boolean {

        return internalSearch(word, root, 0)

    }


    private fun internalSearch(word: String, parent: TreeNode, pos: Int): Boolean {

        val idx = word[pos] - 'a'

        if (pos == word.length - 1)
            return parent.childs[idx] != null && parent.childs[idx]!!.isPresent


        if (parent.childs[idx] == null)
            return false

        return internalSearch(word, parent.childs[idx]!!, pos + 1)

    }


    fun startsWith(prefix: String): Boolean {

        return internalStartsWith(prefix, root, 0)

    }


    private fun internalStartsWith(prefix: String, parent: TreeNode, pos: Int): Boolean {

        val idx = prefix[pos] - 'a'

        if (pos == prefix.length - 1)
            return parent.childs[idx] != null

        if (parent.childs[idx] == null)
            return false

        return internalStartsWith(prefix, parent.childs[idx]!!, pos + 1)

    }


    class TreeNode(var isPresent: Boolean = false, val childs: Array<TreeNode?> = Array(26) { null })


}


fun main() {

    val trie = Trie()

    /*trie.insert("app")
    trie.insert("apple")
    trie.insert("beer")
    trie.insert("add")
    trie.insert("jam")
    trie.insert("rental")

    println(trie.startsWith("jan"))*/

    trie.insert("a")
    trie.startsWith("a")

}