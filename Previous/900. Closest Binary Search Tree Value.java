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
/*主要熟悉一下二分搜索树的特性：
（1）若左子树不空，则左子树上所有节点值均小于或等于它的根节点值；
（2）若右子树不空，则右子树上所有节点值均大于或等于它的根节点值；
（3）左、右子树也为二叉搜索树；
所以我们可以利用这个特性，当target比根小时，在左子树中找，比根大时在右子树中找
*/
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.val>target){
            if(root.left!=null){
                int left = closestValue(root.left,target);
                if(Math.abs(left-target)<Math.abs(root.val-target)){
                return left;
                }
            }
        }else if(root.val<target){
            if(root.right!=null){
                int right = closestValue(root.right,target);
                if(Math.abs(right-target)<Math.abs(root.val-target)){
                return right;
                }
            }
        }
        return root.val;
    }
}
