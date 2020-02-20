//bst的处理，依然还是首先比较root和node的val谁大，如果node的val小于root的val，那需要改变的只有root的left part
//所以可以用递归root.left = insertNode(root.left, node);反之亦然
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        if(root.val > node.val){
            root.left = insertNode(root.left, node);
        }else{
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
///////////////////Non - recursion version (重点是存一下parent，因为最后currNode会变成null的)////////////////////
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        TreeNode parent = null;
        TreeNode currNode = root;
        while(currNode != null){
            parent = currNode;
            if(currNode.val > node.val){
                currNode = currNode.left;
            }else{
                currNode = currNode.right;
            }
        }
        if(parent.val > node.val){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return root;
    }
}
