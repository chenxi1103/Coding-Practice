class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode merged = mergeTwoLists(l1.next, l2);
        if (merged.val >= l1.val) {
            l1.next = merged;
            return l1;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = merged;
        while(merged.next!= null) {
            if(merged.next.val >= l1.val) {
                l1.next = merged.next;
                merged.next = l1;
                return dummy.next;
            }
            merged = merged.next;
        }
        merged.next = l1;
        return dummy.next;
    }
}
