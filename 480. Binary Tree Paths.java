public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);  //求左右子树的paths
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);        //在每个path上加上当前root的值
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);        //在每个path上加上当前root的值
        }
        
        // root is a leaf   //叶子节点
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        
        return paths;
    }
}
