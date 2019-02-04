public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if(node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode insert = new ListNode(x);
        ListNode first = node;
        ListNode prev = null;
        do {
            prev = first;
            first = first.next;
            if(prev.val <= x && first.val >= x) break;
            if(prev.val > first.val && (x < first.val || x > prev.val)) break;
        }while(node != first);
        insert.next = first;
        prev.next = insert;
        return insert;
    }
}
