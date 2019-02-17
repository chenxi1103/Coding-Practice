class Solution {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    private ListNode swap(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode second = node.next;
        ListNode third = second.next;
        second.next = node;
        node.next = swap(third);
        return second;
    }
}
