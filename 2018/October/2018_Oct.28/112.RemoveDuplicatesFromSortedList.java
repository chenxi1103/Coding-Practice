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
     * @param head: head is the head of the linked list
     * @return: head of linked list
     * 这道题的重点是，如果发现后面的值和当前的值重复了，不需要head = head.next，只需要留在原地
     * check下一个结点是不是还和当前节点一样就好，直到不一样的时候再head = head.next！
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next!=null){
           if(head.val == head.next.val){
               head.next = head.next.next;
           }else{
               head = head.next;
           }
        }
        return dummy.next;
    }
}
