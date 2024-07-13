package LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode L) {
        this.val = val;
        this.next = L;
    }
}
