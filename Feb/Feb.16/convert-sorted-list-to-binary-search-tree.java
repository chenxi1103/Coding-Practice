class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        //注意fast是head.next而不是head
        //这样做的原因是，如果fast也是head的话，等fast走到头时，slow正好走到linkedlist的正中间，这样的不好表示linkedlist的左半边，就不好进行下次循环了
        //这一点非常重要！！！
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //注意新的root是slow的下一个
        ListNode currNode = slow.next;
        TreeNode root = new TreeNode(currNode.val);
        slow.next = null;
        TreeNode l = sortedListToBST(head);
        TreeNode r = sortedListToBST(currNode.next);
        root.left = l;
        root.right = r;
        return root;
    }
}
