class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        //这道题的重点是这里，root的leftchild的next是rightchild，而root的rightchild
        //的next是root.next.left，要注意理清楚关系
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null && root.right != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
