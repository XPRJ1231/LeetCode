package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        // 23. 合并 K 个升序链表
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            pre.next = new ListNode(cur.val);
            pre = pre.next;
            if (cur.next != null) {
                minHeap.add(cur.next);
            }
        }

        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        //234.回文链表
        ListNode mid = getMiddle(head);
        ListNode reversed = reverse(mid);
        ListNode head1 = head;
        ListNode head2 = reversed;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 160 相交链表
        ListNode p = headA, q = headB;

        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
