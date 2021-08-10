/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 第一次循环，判断是否为环形链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        // 第二次循环，相遇点即为环形链表入口
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    /*
     * public ListNode detectCycle(ListNode head) { if (head == null) { return null;
     * }
     * 
     * ListNode slow = head, fast = head; while (fast != null) { slow = slow.next;
     * if (fast.next != null) { fast = fast.next.next; } else { return null; }
     * 
     * if (slow == fast) { ListNode ptr = head; while (slow != ptr) { slow =
     * slow.next; ptr = ptr.next; } return ptr; } }
     * 
     * return null; }
     */
}
// @lc code=end
