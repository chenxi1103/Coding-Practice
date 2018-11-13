/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     * 注意head = dummy的含义，还有dummy （val = 0）这个node其实一直在向后移动指向下一个需要处理的node
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null&&head.next.next!=null){
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dummy.next;
    }
}
