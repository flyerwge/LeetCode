/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resNode = new ListNode();
        ListNode ansNode = resNode;

        while (head != null) {
            ListNode tempNode = head;
            ListNode tailNode = head;
            for (int i = 0; i < k; i++) {
                if (tempNode == null) {
                    resNode.next = tailNode;
                    return ansNode.next;
                }
                tempNode = tempNode.next;
            }

            ListNode childNode = new ListNode(head.val);
            head = head.next;
            for (int i = 1; i < k; i++) {
                ListNode newNode = new ListNode(head.val);
                head = head.next;
                newNode.next = childNode;
                childNode = newNode;
            }

            resNode.next = childNode;
            while (resNode.next != null) {
                resNode = resNode.next;
            }
        }

        return ansNode.next;

    }
}
// @lc code=end
