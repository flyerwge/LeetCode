import java.util.List;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode dummyHeaad = new ListNode(0);
        dummyHeaad.next = head;

        ListNode preNode = head, curNode = head.next;

        while (curNode != null) {
            if (preNode.val <= curNode.val) {
                preNode = preNode.next;
            } else {
                ListNode tempNode = dummyHeaad;
                while (tempNode.next.val < curNode.val) {
                    tempNode = tempNode.next;
                }

                preNode.next = curNode.next;
                curNode.next = tempNode.next;
                tempNode.next = curNode;

            }
            curNode = preNode.next;
        }

        return dummyHeaad.next;

    }
}
// @lc code=end
