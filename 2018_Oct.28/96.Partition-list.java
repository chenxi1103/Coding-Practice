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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     * 日期：2018-10-28-1:33pm
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode saveNodes1 = new ListNode(0);
        ListNode saveNodes2 = new ListNode(0);
        dummy1.next = saveNodes1;
        dummy2.next = saveNodes2;
        while(head!=null){
            if(head.val<x){
                saveNodes1.next = new ListNode(head.val);
                saveNodes1 = saveNodes1.next;
                head = head.next;
            }else{
                saveNodes2.next = new ListNode(head.val);
                saveNodes2 = saveNodes2.next;
                head = head.next;
            }
        }
        saveNodes1.next = dummy2.next.next;
        return dummy1.next.next;
    }
}
