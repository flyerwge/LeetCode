/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;

        ListNode curNode = new ListNode();
        ListNode preNode = curNode;
        ListNode resNode = preNode;
        // resNode.next = new ListNode(head.val);

        label: while (head != null) {
            ListNode newNode = new ListNode(head.val);
            // if (curNode == null) {
            // curNode.next = newNode;
            // preNode = curNode;
            // curNode = curNode.next;
            // head = head.next;
            // } else if (head.val >= curNode.val) {
            // curNode.next = newNode;
            // preNode = curNode;
            // curNode = curNode.next;
            // head = head.next;
            // } else if (head.val < curNode.val) {
            // // if (preNode == null || head.val >= preNode.val) {
            // // newNode.next = curNode;
            // // preNode.next = newNode;
            // // preNode = newNode;
            // // head = head.next;
            // // } else if (head.val < preNode.val) {
            // ListNode tempNode = resNode;
            // while (tempNode.next != null) {
            // if (tempNode.next.val > head.val) {
            // newNode.next = tempNode.next;
            // tempNode.next = newNode;
            // head = head.next;
            // break;
            // } else {
            // tempNode = tempNode.next;
            // }
            // }
            // // }

            // }

            ListNode tempNode = resNode;

            while (tempNode.next != null) {
                if (tempNode.next.val >= head.val) {
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    head = head.next;
                    continue label;
                } else {
                    tempNode = tempNode.next;
                }
            }

            tempNode.next = newNode;
            head = head.next;

        }

        return resNode.next;

    }
}
// @lc code=end
