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
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        //重点：不可以直接判断fast.next.next ！= null，因为fast.next就有可能是null了
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            if(slow.val == fast.val) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
