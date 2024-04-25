package day34

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/24 PM 10:32:00
 * @version 1.0.0
 * @description LRU
 * @filename LRUCache.kt
 *
 */

/*
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。*/

class LRUCache(val capacityProv: Int) {


    private val map = HashMap<Int, Entry>(capacityProv)
    private val dummy_head = Entry(0, 0, null, null)
    private var dummy_tail = Entry(0, 0, null, null)
    private var count = 0
    private var capacity = 0

    init {

        capacity = capacityProv
        dummy_head.next = dummy_tail
        dummy_tail.prev = dummy_head

    }

    fun get(key: Int): Int {

        if (map.containsKey(key)) {

            val current_entry = map[key]!!

            val left_entry = current_entry.prev
            val right_entry = current_entry.next

            left_entry!!.next = right_entry
            right_entry!!.prev = left_entry

            val actual_head = dummy_head.next

            current_entry.prev = dummy_head
            current_entry.next = actual_head
            dummy_head.next = current_entry
            actual_head!!.prev = current_entry

            return current_entry.value

        } else {

            return -1

        }

    }


    fun put(key: Int, value: Int) {

        if (map.containsKey(key)) {

            map[key]!!.value = value
            get(key)

        } else {

            val actual_head = dummy_head.next
            val temp = Entry(key, value, dummy_head, actual_head)
            dummy_head.next = temp
            actual_head!!.prev = temp

            map[key] = temp
            count++

            if (count > capacity) {

                val actual_tail = dummy_tail.prev
                val new_actual_tail = actual_tail!!.prev

                actual_tail.prev = null
                actual_tail.next = null

                new_actual_tail!!.next = dummy_tail
                dummy_tail.prev = new_actual_tail

                map.remove(actual_tail.key)

                count--

            }

        }

    }

}


class Entry(val key: Int, var value: Int, var prev: Entry?, var next: Entry?)

fun main() {

    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.get(1)
    lruCache.put(3, 3)
    lruCache.get(2)
    lruCache.put(4, 4)
    lruCache.get(1)
    lruCache.get(3)
    lruCache.get(4)

}