class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode rest = reverseList(nextNode);
        // 这里是nextNode而不是rest，因为nextNode才是紧邻head的那个node，rest是经过反转后的头节点，不是尾节点，不可以rest.next = head!!!
        nextNode.next = head;
        head.next = null;
        return rest;
    }
}

// iteration
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
