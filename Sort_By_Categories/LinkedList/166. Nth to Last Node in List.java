/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head1.next = head;
        head2.next = head;
        for(int i = 0; i<n; i++){
            head1 = head1.next;
        }
        while(head1.next!=null){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head2.next;
    }
}
