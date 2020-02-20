/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String str : left){
            String path = root.val + "->" + str;
            result.add(path);
        }
        for(String str : right){
            String path = root.val + "->" + str;
            result.add(path);
        }
        if(result.size() == 0) result.add(""+root.val);
        return result;
    }
}
