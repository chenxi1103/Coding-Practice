// 根据平衡二叉树的性质
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public TreeNode prev = null;
    public boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) return true;
        inOrder(root);
        return valid;
    }
    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(prev == null){
            prev = root;
        } else {
            if (prev.val < root.val) {
                prev = root;
            } else {
                valid = false;
            }
        }
        inOrder(root.right);
    }
}

//////////////分治法1:这种方法也太厉害了把。。。///////////////
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) return true;
        return devConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean devConq(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return devConq(root.left, min, Math.min(max, root.val)) && devConq(root.right, Math.max(min, root.val), max);
    }
}


/////////////////分治法2:普通分治法////////////////////////
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class ResultType {
        boolean isValid;
        TreeNode min;
        TreeNode max;
        public ResultType(boolean isValid) {
            this.isValid = isValid;
            this.min = null;
            this.max = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) return true;
        ResultType result = devConq(root);
        return result.isValid;
    }
    private ResultType devConq(TreeNode root) {
        if(root == null) {
            return new ResultType(true);
        }
        ResultType left = devConq(root.left);
        ResultType right = devConq(root.right);

        if(left.max != null && left.max.val >= root.val) return new ResultType(false);
        if(right.min != null && right.min.val <= root.val) return new ResultType(false);
        if(!left.isValid || !right.isValid) return new ResultType(false);

        ResultType result = new ResultType(true);
        result.min = left.min != null ? left.min : root;
        result.max = right.max != null ? right.max : root;
        return result;
    }
}
