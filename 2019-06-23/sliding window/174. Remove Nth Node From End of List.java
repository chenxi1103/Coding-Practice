//非常明显的同向双指针
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDeleted = dummy;
        while (n != 0) {
            if (head == null) return null;
            head = head.next;
            n--;
        }
        while (head != null) {
            head = head.next;
            preDeleted = preDeleted.next;
        }
        preDeleted.next = preDeleted.next.next;
        return dummy.next;
    }
}
