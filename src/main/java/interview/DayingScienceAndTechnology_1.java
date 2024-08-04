package interview;


/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/2 PM 7:14:29
 * @description 大应科技测评-1-排序链表
 * @filename DayingScienceAndTechnology.kt
 */

public class DayingScienceAndTechnology_1 {


    class ListNode {


        public Integer val;
        public ListNode next;


        public ListNode(Integer val) {

            this.val = val;

        }


    }


    public static void main(String[] args) {


    }


    /**
     * @author Lenovo/LiGuanda
     * @date 2024/8/2 PM 7:17:34
     * @version 1.0.0
     * @description 排序链表
     * @filename DayingScienceAndTechnology.java
     */
    private ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        ListNode dummy = new ListNode(10_001);
        ListNode pointer = dummy;

        while (left != null && right != null) {

            if (left.val < right.val) {

                pointer.next = left;
                left = left.next;

            } else {

                pointer.next = right;
                right = right.next;

            }

            pointer = pointer.next;

        }


        if (left == null) {

            pointer.next = right;

        } else {

            pointer.next = left;

        }

        return dummy.next;

    }


}