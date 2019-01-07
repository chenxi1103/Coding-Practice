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
     * @param node: the node in the list should be deletedt
     * @return: nothing
     * 这道题的重点是，没给起点，只给了要删除的点，那就不能走到这个点的前一点进行删除
     * 所以要copy下一个点的值，再做.next = .next.next
     */
    public void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
