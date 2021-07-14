/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansNode = new ListNode();
        ListNode resNode = ansNode;
        int cin = 0; // 进位

        while (l1 != null && l2 != null) {
            if (l1.val + l2.val >= 10) {
                ListNode newNode = new ListNode((l1.val + l2.val + cin) % 10);
                cin = (l1.val + l2.val + cin) / 10;
                ansNode.next = newNode;
                ansNode = ansNode.next;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                ListNode newNode = new ListNode((l1.val + l2.val + cin) % 10);
                cin = (l1.val + l2.val + cin) / 10;
                ansNode.next = newNode;
                ansNode = ansNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        // 当有一个链表先为空时
        while (l1 != null) {
            ListNode newNode = new ListNode((l1.val + cin) % 10);
            cin = (l1.val + cin) / 10;
            ansNode.next = newNode;
            ansNode = ansNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode newNode = new ListNode((l2.val + cin) % 10);
            cin = (l2.val + cin) / 10;
            ansNode.next = newNode;
            ansNode = ansNode.next;
            l2 = l2.next;
        }

        if (cin != 0) {
            ansNode.next = new ListNode(cin);
        }
        return resNode.next;
    }
}
// @lc code=end
