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
     * @return: Head node.
     * 略有小bug需要注意，链表题真的容易错
     * Nov.5th 4:36pm
     */
    public ListNode removeDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        set.add(head.val);
        while(head.next!= null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
                continue;
            }else{
                set.add(head.next.val);
                head = head.next;
            }
        }
        return dummy.next;
    }
}
