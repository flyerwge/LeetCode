/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempHeadA = headA, tempHeadB = headB;
        while (tempHeadA != tempHeadB) {
            tempHeadA = tempHeadA != null ? tempHeadA.next : headB;
            tempHeadB = tempHeadB != null ? tempHeadB.next : headA;
        }

        return tempHeadA;

    }
}
// @lc code=end
