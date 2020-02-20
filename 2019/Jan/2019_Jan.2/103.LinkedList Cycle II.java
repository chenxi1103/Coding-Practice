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
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        //重点是这里，快慢指针相遇后，让head和slow.next左比较，如果不同，每个只往后走一步，
        //注意是和slow.next做比较而不是slow本身！！！
        while(head!=slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
