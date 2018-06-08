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
 
//遍历法：就是遍历左子树不空就遍历左子树，往后加，右子树不空就遍历右子树，到最后把path加到result里
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) return result;
        findPath(root,String.valueOf(root.val),result);
        return result;
    }
    private void findPath(TreeNode root, String path, List<String> result){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if(root.left!=null){
            findPath(root.left,path+"->"+String.valueOf(root.left.val),result);
        }
        if(root.right!=null){
            findPath(root.right,path+"->"+String.valueOf(root.right.val),result);
        }
    }
}

//分治法：貌似更好理解不过可能想不到怎么写？就是先把左子树的所有的path找到，加上根节点成为完整的path，右子树的所有path找到加上根节点成为完整的path这样
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) return result;
        List<String> left = binaryTreePaths(root.left);
        for(String path : left){
            result.add(root.val+"->"+path);
        }
        List<String> right = binaryTreePaths(root.right);
        for(String path : right){
            result.add(root.val+"->"+path);//直接相加出来就是string
        }
        //如果left和right都是null的话，上面的两个for loop就不会运行，result.size() == 0
        if(result.size() == 0){
            result.add(""+root.val);
        }
        return result;
    }
}
